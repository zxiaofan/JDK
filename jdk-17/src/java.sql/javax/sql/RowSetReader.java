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
 * The facility that a disconnected {@code RowSet} object calls on
 * to populate itself with rows of data. A reader (an object implementing the
 * {@code RowSetReader} interface) may be registered with
 * a {@code RowSet} object that supports the reader/writer paradigm.
 * When the {@code RowSet} object's {@code execute} method is
 * called, it in turn calls the reader's {@code readData} method.
 *
 * @since 1.4
 */

public interface RowSetReader {

  /**
   * Reads the new contents of the calling {@code RowSet} object.
   * In order to call this method, a {@code RowSet}
   * object must have implemented the {@code RowSetInternal} interface
   * and registered this {@code RowSetReader} object as its reader.
   * The {@code readData}  method is invoked internally
   * by the {@code RowSet.execute} method for rowsets that support the
   * reader/writer paradigm.
   *
   * <P>The {@code readData} method adds rows to the caller.
   * It can be implemented in a wide variety of ways and can even
   * populate the caller with rows from a nonrelational data source.
   * In general, a reader may invoke any of the rowset's methods,
   * with one exception. Calling the method {@code execute} will
   * cause an {@code SQLException} to be thrown
   * because {@code execute} may not be called recursively.  Also,
   * when a reader invokes {@code RowSet} methods, no listeners
   * are notified; that is, no {@code RowSetEvent} objects are
   * generated and no {@code RowSetListener} methods are invoked.
   * This is true because listeners are already being notified by the method
   * {@code execute}.
   *
   * @param caller the {@code RowSet} object (1) that has implemented the
   *         {@code RowSetInternal} interface, (2) with which this reader is
   *        registered, and (3) whose {@code execute} method called this reader
   * @throws SQLException if a database access error occurs or this method
   *         invokes the {@code RowSet.execute} method
   */
  void readData(RowSetInternal caller) throws SQLException;

}
