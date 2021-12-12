/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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
package javax.sql;

import java.sql.*;

/**
 * An object that provides support for distributed transactions. An
 * {@code XAConnection} object may be enlisted in a distributed transaction
 * by means of an {@code XAResource} object. A transaction manager, usually
 * part of a middle tier server, manages an {@code XAConnection} object
 * through the {@code XAResource} object.
 * <P>
 * An application programmer does not use this interface directly; rather, it is
 * used by a transaction manager working in the middle tier server.
 *
 * @since 1.4
 */
public interface XAConnection extends PooledConnection {

    /**
     * Retrieves an {@code XAResource} object that the transaction manager
     * will use to manage this {@code XAConnection} object's participation
     * in a distributed transaction.
     *
     * @return the {@code XAResource} object
     * @throws SQLException if a database access error occurs
     * @throws SQLFeatureNotSupportedException if the JDBC driver does not
     * support this method
     * @since 1.4
     */
    javax.transaction.xa.XAResource getXAResource() throws SQLException;
}
