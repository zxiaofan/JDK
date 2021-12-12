/*
 * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.auth;

/**
 * An object that implements the {@code java.security.Principal}
 * interface typically also implements this interface to provide
 * a means for comparing that object to a specified {@code Subject}.
 *
 * <p> The comparison is achieved via the {@code implies} method.
 * The implementation of the {@code implies} method determines
 * whether this object "implies" the specified {@code Subject}.
 * One example application of this method may be for
 * a "group" object to imply a particular {@code Subject}
 * if that {@code Subject} belongs to the group.
 * Another example application of this method would be for
 * "role" object to imply a particular {@code Subject}
 * if that {@code Subject} is currently acting in that role.
 *
 * <p> Although classes that implement this interface typically
 * also implement the {@code java.security.Principal} interface,
 * it is not required.  In other words, classes may implement the
 * {@code java.security.Principal} interface by itself,
 * the {@code PrincipalComparator} interface by itself,
 * or both at the same time.
 *
 * @see java.security.Principal
 * @see javax.security.auth.Subject
 */
public interface PrincipalComparator {
    /**
     * Check if the specified {@code Subject} is implied by
     * this object.
     *
     * @param  subject the subject to compare
     *
     * @return true if the specified {@code Subject} is implied by
     *          this object, or false otherwise.
     */
    boolean implies(javax.security.auth.Subject subject);
}
