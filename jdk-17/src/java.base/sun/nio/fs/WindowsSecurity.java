/*
 * Copyright (c) 2008, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package sun.nio.fs;

import static sun.nio.fs.WindowsNativeDispatcher.*;
import static sun.nio.fs.WindowsConstants.*;

/**
 * Security related utility methods.
 */

class WindowsSecurity {
    private WindowsSecurity() { }

    // opens process token for given access
    private static long openProcessToken(int access) {
        try {
            return OpenProcessToken(GetCurrentProcess(), access);
        } catch (WindowsException x) {
            return 0L;
        }
    }

    /**
     * Returns the access token for this process with TOKEN_DUPLICATE access
     */
    static final long processTokenWithDuplicateAccess =
        openProcessToken(TOKEN_DUPLICATE);

    /**
     * Returns the access token for this process with TOKEN_QUERY access
     */
    static final long processTokenWithQueryAccess =
        openProcessToken(TOKEN_QUERY);

    /**
     * Returned by enablePrivilege when code may require a given privilege.
     * The drop method should be invoked after the operation completes so as
     * to revert the privilege.
     */
    static interface Privilege {
        void drop();
    }

    /**
     * Attempts to enable the given privilege for this method.
     */
    static Privilege enablePrivilege(String priv) {
        final long pLuid;
        try {
            pLuid = LookupPrivilegeValue(priv);
        } catch (WindowsException x) {
            // indicates bug in caller
            throw new AssertionError(x);
        }

        long hToken = 0L;
        boolean impersontating = false;
        boolean elevated = false;
        try {
            hToken = OpenThreadToken(GetCurrentThread(),
                                     TOKEN_ADJUST_PRIVILEGES, false);
            if (hToken == 0L && processTokenWithDuplicateAccess != 0L) {
                hToken = DuplicateTokenEx(processTokenWithDuplicateAccess,
                    (TOKEN_ADJUST_PRIVILEGES|TOKEN_IMPERSONATE));
                SetThreadToken(0L, hToken);
                impersontating = true;
            }

            if (hToken != 0L) {
                AdjustTokenPrivileges(hToken, pLuid, SE_PRIVILEGE_ENABLED);
                elevated = true;
            }
        } catch (WindowsException x) {
            // nothing to do, privilege not enabled
        }

        final long token = hToken;
        final boolean stopImpersontating = impersontating;
        final boolean needToRevert = elevated;

        return () -> {
            try {
                if (token != 0L) {
                    try {
                        if (stopImpersontating)
                            SetThreadToken(0L, 0L);
                        else if (needToRevert)
                            AdjustTokenPrivileges(token, pLuid, 0);
                    } catch (WindowsException x) {
                        // should not happen
                        throw new AssertionError(x);
                    } finally {
                        CloseHandle(token);
                    }
                }
            } finally {
                LocalFree(pLuid);
            }
        };
    }

    /**
     * Check the access right against the securityInfo in the current thread.
     */
    static boolean checkAccessMask(long securityInfo, int accessMask,
        int genericRead, int genericWrite, int genericExecute, int genericAll)
        throws WindowsException
    {
        int privileges = TOKEN_QUERY;
        long hToken = OpenThreadToken(GetCurrentThread(), privileges, false);
        if (hToken == 0L && processTokenWithDuplicateAccess != 0L)
            hToken = DuplicateTokenEx(processTokenWithDuplicateAccess,
                privileges);

        boolean hasRight = false;
        if (hToken != 0L) {
            try {
                hasRight = AccessCheck(hToken, securityInfo, accessMask,
                    genericRead, genericWrite, genericExecute, genericAll);
            } finally {
                CloseHandle(hToken);
            }
        }
        return hasRight;
    }

}
