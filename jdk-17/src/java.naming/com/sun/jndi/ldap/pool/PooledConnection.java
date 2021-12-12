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
 * Represents a connection that is managed in a pool. The connection
 * may be reused by multiple clients.
 *
 * A pooled connection typically has a close method that its clients
 * use to indicate that they no longer need the connection. This close
 * method would interact with the connection pool to return the connection
 * to the pool (see PoolCallback).
 *<p>
 * The pooled connection also needs to provide a close method that the
 * connection pool can use to physically close the connection.
 * The pool might need to physically close the connection as determined
 * by the pool's policy (for example, to manage the pool size or idle
 * connections). This second close method should *not* use PoolCallback
 * methods. It should only do what is required to close the physical
 * connection.
 *
 * @author Rosanna Lee
 */
public interface PooledConnection {

    /**
     * Closes the physical connection.
     */
    public abstract void closeConnection();
}
