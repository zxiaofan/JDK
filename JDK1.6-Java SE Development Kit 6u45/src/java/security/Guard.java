/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.security;

/**
 * <p> This interface represents a guard, which is an object that is used
 * to protect access to another object.
 *
 * <p>This interface contains a single method, <code>checkGuard</code>,
 * with a single <code>object</code> argument. <code>checkGuard</code> is
 * invoked (by the GuardedObject <code>getObject</code> method)
 * to determine whether or not to allow access to the object.
 *
 * @see GuardedObject
 *
 * @version %I% %E%
 * @author Roland Schemers
 * @author Li Gong
 */

public interface Guard {

    /**
     * Determines whether or not to allow access to the guarded object
     * <code>object</code>. Returns silently if access is allowed.
     * Otherwise, throws a SecurityException.
     *
     * @param object the object being protected by the guard.
     *
     * @exception SecurityException if access is denied.
     *
     */
    void checkGuard(Object object) throws SecurityException;
}
