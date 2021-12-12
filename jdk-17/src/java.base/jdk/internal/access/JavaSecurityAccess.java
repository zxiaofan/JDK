/*
 * Copyright (c) 2010, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.security.AccessControlContext;
import java.security.PermissionCollection;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

public interface JavaSecurityAccess {

    <T> T doIntersectionPrivilege(PrivilegedAction<T> action,
                                  @SuppressWarnings("removal") AccessControlContext stack,
                                  @SuppressWarnings("removal") AccessControlContext context);

    <T> T doIntersectionPrivilege(PrivilegedAction<T> action,
                                  @SuppressWarnings("removal") AccessControlContext context);

    ProtectionDomain[] getProtectDomains(@SuppressWarnings("removal") AccessControlContext context);

    interface ProtectionDomainCache {
        void put(ProtectionDomain pd, PermissionCollection pc);
        PermissionCollection get(ProtectionDomain pd);
    }

    /**
     * Returns the ProtectionDomainCache.
     */
    ProtectionDomainCache getProtectionDomainCache();
}
