/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.security.auth;

/**
 * Objects such as credentials may optionally implement this interface
 * to provide the capability to destroy its contents.
 * 
 * @version %I%, %G%
 * @see javax.security.auth.Subject
 */
public interface Destroyable {

    /**
     * Destroy this <code>Object</code>.
     *
     * <p> Sensitive information associated with this <code>Object</code>
     * is destroyed or cleared.  Subsequent calls to certain methods
     * on this <code>Object</code> will result in an
     * <code>IllegalStateException</code> being thrown.
     *
     * <p>
     *
     * @exception DestroyFailedException if the destroy operation fails. <p>
     *
     * @exception SecurityException if the caller does not have permission
     *		to destroy this <code>Object</code>.
     */
    void destroy() throws DestroyFailedException;

    /**
     * Determine if this <code>Object</code> has been destroyed.
     *
     * <p>
     *
     * @return true if this <code>Object</code> has been destroyed,
     *		false otherwise.
     */
    boolean isDestroyed();
}
