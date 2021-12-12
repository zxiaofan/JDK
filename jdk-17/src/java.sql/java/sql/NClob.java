/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.sql;

/**
 * The mapping in the Java programming language
 * for the SQL {@code NCLOB} type.
 * An SQL {@code NCLOB} is a built-in type
 * that stores a Character Large Object using the National Character Set
 *  as a column value in a row of  a database table.
 * <P>The {@code NClob} interface extends the {@code Clob} interface
 * which provides methods for getting the
 * length of an SQL {@code NCLOB} value,
 * for materializing a {@code NCLOB} value on the client, and for
 * searching for a substring or {@code NCLOB} object within a
 * {@code NCLOB} value. A {@code NClob} object, just like a {@code Clob} object, is valid for the duration
 * of the transaction in which it was created.
 * Methods in the interfaces {@link ResultSet},
 * {@link CallableStatement}, and {@link PreparedStatement}, such as
 * {@code getNClob} and {@code setNClob} allow a programmer to
 * access an SQL {@code NCLOB} value.  In addition, this interface
 * has methods for updating a {@code NCLOB} value.
 * <p>
 * All methods on the {@code NClob} interface must be fully implemented if the
 * JDBC driver supports the data type.
 *
 * @since 1.6
 */

public interface NClob extends Clob { }
