/*
 * Copyright (c) 2010, 2011, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

import java.security.AccessControlContext;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

public interface JavaSecurityAccess {

    <T> T doIntersectionPrivilege(PrivilegedAction<T> action,
                                  AccessControlContext stack,
                                  AccessControlContext context);

    <T> T doIntersectionPrivilege(PrivilegedAction<T> action,
                                  AccessControlContext context);

    ProtectionDomain[] getProtectDomains(AccessControlContext context);
}
