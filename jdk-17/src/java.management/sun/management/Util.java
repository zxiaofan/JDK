/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.management;

import java.lang.management.ManagementPermission;
import java.util.List;
import javax.management.ObjectName;
import javax.management.MalformedObjectNameException;


public class Util {
    private Util() {}  // there are no instances of this class

    static RuntimeException newException(Exception e) {
        throw new RuntimeException(e);
    }

    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    static String[] toStringArray(List<String> list) {
        return list.toArray(EMPTY_STRING_ARRAY);
    }

    public static ObjectName newObjectName(String domainAndType, String name) {
        return newObjectName(domainAndType + ",name=" + name);
    }

    public static ObjectName newObjectName(String name) {
        try {
            return ObjectName.getInstance(name);
        } catch (MalformedObjectNameException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static ManagementPermission monitorPermission =
        new ManagementPermission("monitor");
    private static ManagementPermission controlPermission =
        new ManagementPermission("control");

    /**
     * Check that the current context is trusted to perform monitoring
     * or management.
     * <p>
     * If the check fails we throw a SecurityException, otherwise
     * we return normally.
     *
     * @exception  SecurityException  if a security manager exists and if
     *             the caller does not have ManagementPermission("control").
     */
    static void checkAccess(ManagementPermission p)
         throws SecurityException {
        @SuppressWarnings("removal")
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(p);
        }
    }

    static void checkMonitorAccess() throws SecurityException {
        checkAccess(monitorPermission);
    }
    public static void checkControlAccess() throws SecurityException {
        checkAccess(controlPermission);
    }
}
