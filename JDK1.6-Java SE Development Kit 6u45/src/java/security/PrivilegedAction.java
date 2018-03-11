/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.security;


/**
 * A computation to be performed with privileges enabled.  The computation is
 * performed by invoking <code>AccessController.doPrivileged</code> on the
 * <code>PrivilegedAction</code> object.  This interface is used only for
 * computations that do not throw checked exceptions; computations that
 * throw checked exceptions must use <code>PrivilegedExceptionAction</code>
 * instead.
 *
 * @see AccessController
 * @see AccessController#doPrivileged(PrivilegedAction)
 * @see PrivilegedExceptionAction
 */

public interface PrivilegedAction<T> {
    /**
     * Performs the computation.  This method will be called by
     * <code>AccessController.doPrivileged</code> after enabling privileges.
     *
     * @return a class-dependent value that may represent the results of the
     *	       computation. Each class that implements
     *         <code>PrivilegedAction</code>
     *	       should document what (if anything) this value represents.
     * @see AccessController#doPrivileged(PrivilegedAction)
     * @see AccessController#doPrivileged(PrivilegedAction,
     *                                     AccessControlContext)
     */
    T run();
}
