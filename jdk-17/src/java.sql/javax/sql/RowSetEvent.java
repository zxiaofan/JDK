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

/**
 * An {@code Event} object generated when an event occurs to a
 * {@code RowSet} object.  A {@code RowSetEvent} object is
 * generated when a single row in a rowset is changed, the whole rowset
 * is changed, or the rowset cursor moves.
 * <P>
 * When an event occurs on a {@code RowSet} object, one of the
 * {@code RowSetListener} methods will be sent to all registered
 * listeners to notify them of the event.  An {@code Event} object
 * is supplied to the {@code RowSetListener} method so that the
 * listener can use it to find out which {@code RowSet} object is
 * the source of the event.
 *
 * @since 1.4
 */

public class RowSetEvent extends java.util.EventObject {

  /**
   * Constructs a {@code RowSetEvent} object initialized with the
   * given {@code RowSet} object.
   *
   * @param source the {@code RowSet} object whose data has changed or
   *        whose cursor has moved
   * @throws IllegalArgumentException if {@code source} is null.
   */
  public RowSetEvent(RowSet source)
    { super(source); }

  /**
   * Private serial version unique ID to ensure serialization
   * compatibility.
   */
  static final long serialVersionUID = -1875450876546332005L;
}
