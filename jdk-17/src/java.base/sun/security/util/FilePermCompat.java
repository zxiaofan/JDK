/*
 * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.util;

import sun.security.action.GetPropertyAction;

import java.io.FilePermission;
import java.security.Permission;
import jdk.internal.access.SharedSecrets;

/**
 * Take care of FilePermission compatibility after JDK-8164705.
 */
public class FilePermCompat {
    /**
     * New behavior? Keep compatibility? Both default true.
     */
    public static final boolean nb;
    public static final boolean compat;

    static {
        String flag = SecurityProperties.privilegedGetOverridable(
                "jdk.io.permissionsUseCanonicalPath");
        if (flag == null) {
            flag = "false";
        }
        switch (flag) {
            case "true":
                nb = false;
                compat = false;
                break;
            case "false":
                nb = true;
                compat = true;
                break;
            default:
                throw new RuntimeException(
                        "Invalid jdk.io.permissionsUseCanonicalPath: " + flag);
        }
    }

    public static Permission newPermPlusAltPath(Permission input) {
        if (compat && input instanceof FilePermission) {
            return SharedSecrets.getJavaIOFilePermissionAccess()
                    .newPermPlusAltPath((FilePermission) input);
        }
        return input;
    }

    public static Permission newPermUsingAltPath(Permission input) {
        if (input instanceof FilePermission) {
            return SharedSecrets.getJavaIOFilePermissionAccess()
                    .newPermUsingAltPath((FilePermission) input);
        }
        return null;
    }
}
