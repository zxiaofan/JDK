/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.rowset.internal;

import java.sql.*;
import java.io.*;
import java.util.Arrays;

/**
 * The abstract base class from which the classes <code>Row</code>
 * The class <code>BaseRow</code> stores
 * a row's original values as an array of <code>Object</code>
 * values, which can be retrieved with the method <code>getOrigRow</code>.
 * This class also provides methods for getting and setting individual
 * values in the row.
 * <P>
 * A row's original values are the values it contained before it was last
 * modified.  For example, when the <code>CachedRowSet</code>method
 * <code>acceptChanges</code> is called, it will reset a row's original
 * values to be the row's current values.  Then, when the row is modified,
 * the values that were previously the current values will become the row's
 * original values (the values the row had immediately before it was modified).
 * If a row has not been modified, its original values are its initial values.
 * <P>
 * Subclasses of this class contain more specific details, such as
 * the conditions under which an exception is thrown or the bounds for
 * index parameters.
 */
public abstract class BaseRow implements Serializable, Cloneable {

/**
 * Specify the serialVersionUID
 */
private static final long serialVersionUID = 4152013523511412238L;

/**
 * The array containing the original values for this <code>BaseRow</code>
 * object.
 * @serial
 */
    protected Object[] origVals;

/**
 * Retrieves the values that this row contained immediately
 * prior to its last modification.
 *
 * @return an array of <code>Object</code> values containing this row's
 * original values
 */
    public Object[] getOrigRow() {
        Object[] origRow = this.origVals;
        return (origRow == null) ? null: Arrays.copyOf(origRow, origRow.length);
    }

/**
 * Retrieves the array element at the given index, which is
 * the original value of column number <i>idx</i> in this row.
 *
 * @param idx the index of the element to return
 * @return the <code>Object</code> value at the given index into this
 *         row's array of original values
 * @throws SQLException if there is an error
 */
    public abstract Object getColumnObject(int idx) throws SQLException;

/**
 * Sets the element at the given index into this row's array of
 * original values to the given value.  Implementations of the classes
 * <code>Row</code> and determine what happens
 * when the cursor is on the insert row and when it is on any other row.
 *
 * @param idx the index of the element to be set
 * @param obj the <code>Object</code> to which the element at index
 *              <code>idx</code> to be set
 * @throws SQLException if there is an error
 */
    public abstract void setColumnObject(int idx, Object obj) throws SQLException;
}
