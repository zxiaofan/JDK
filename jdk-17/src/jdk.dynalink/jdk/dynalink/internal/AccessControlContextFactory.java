/*
 * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.dynalink.internal;

import java.security.AccessControlContext;
import java.security.Permission;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.util.stream.Stream;

/**
 * Utility class for creating permission-restricting {@link AccessControlContext}s.
 */
public final class AccessControlContextFactory {
    private AccessControlContextFactory () {
    }

    /**
     * Creates an access control context with no permissions.
     * @return an access control context with no permissions.
     */
    @SuppressWarnings("removal")
    public static AccessControlContext createAccessControlContext() {
        return createAccessControlContext(new Permission[0]);
    }

    /**
     * Creates an access control context limited to only the specified permissions.
     * @param permissions the permissions for the newly created access control context.
     * @return a new access control context limited to only the specified permissions.
     */
    @SuppressWarnings("removal")
    public static AccessControlContext createAccessControlContext(final Permission... permissions) {
        final Permissions perms = new Permissions();
        for(final Permission permission: permissions) {
            perms.add(permission);
        }
        return new AccessControlContext(new ProtectionDomain[] { new ProtectionDomain(null, perms) });
    }

    /**
     * Creates an access control context limited to only the {@link RuntimePermission}s
     * of the given names.
     * @param runtimePermissionNames the names of runtime permissions for the
     * newly created access control context.
     * @return a new access control context limited to only the runtime
     * permissions with the specified names.
     */
    @SuppressWarnings("removal")
    public static AccessControlContext createAccessControlContext(final String... runtimePermissionNames) {
        return createAccessControlContext(makeRuntimePermissions(runtimePermissionNames));
    }

    private static Permission[] makeRuntimePermissions(final String... runtimePermissionNames) {
        return Stream.of(runtimePermissionNames).map(RuntimePermission::new).toArray(Permission[]::new);
    }
}
