/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.ldap.pool;

/**
 * Represents a callback used to release or remove a PooledConnection back
 * into the pool.
 *
 * A pooled connection typically has a close method that its clients
 * use to indicate that they no longer need the connection. This close
 * method should use the methods defined in this interface to
 * interact with the connection pool to return the connection
 * to the pool.
 *
 * The methods in this interface are typically invoked by a PooledConnection.
 * The methods in this interface are typically implemented by the connection
 * pool manager.
 *
 * @author Rosanna Lee
 */
public interface PoolCallback {
    /**
     * Releases a useable connection back to the pool.
     *
     * @param conn The connection to release.
     * @return true if the connection released; false if the connection
     * is no longer in the pool.
     */
    public abstract boolean releasePooledConnection(PooledConnection conn);

    /**
     * Removes a connection from the pool. The connection should not be reused.
     * The physical connection should have already been closed.
     *
     * @param conn The connection to return.
     * @return true if the connection was removed; false if the connection
     * is no longer in the pool prior to removal.
     */
    public abstract boolean removePooledConnection(PooledConnection conn);
}
