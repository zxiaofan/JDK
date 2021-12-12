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
 * An interface that must be implemented by a
 * component that wants to be notified when a significant
 * event happens in the life of a {@code RowSet} object.
 * A component becomes a listener by being registered with a
 * {@code RowSet} object via the method {@code RowSet.addRowSetListener}.
 * How a registered component implements this interface determines what it does
 * when it is notified of an event.
 *
 * @since 1.4
 */

public interface RowSetListener extends java.util.EventListener {

  /**
   * Notifies registered listeners that a {@code RowSet} object
   * in the given {@code RowSetEvent} object has changed its entire contents.
   * <P>
   * The source of the event can be retrieved with the method
   * {@code event.getSource}.
   *
   * @param event a {@code RowSetEvent} object that contains
   *         the {@code RowSet} object that is the source of the event
   */
  void rowSetChanged(RowSetEvent event);

  /**
   * Notifies registered listeners that a {@code RowSet} object
   * has had a change in one of its rows.
   * <P>
   * The source of the event can be retrieved with the method
   * {@code event.getSource}.
   *
   * @param event a {@code RowSetEvent} object that contains
   *         the {@code RowSet} object that is the source of the event
   */
  void rowChanged(RowSetEvent event);

  /**
   * Notifies registered listeners that a {@code RowSet} object's
   * cursor has moved.
   * <P>
   * The source of the event can be retrieved with the method
   * {@code event.getSource}.
   *
   * @param event a {@code RowSetEvent} object that contains
   *         the {@code RowSet} object that is the source of the event
   */
  void cursorMoved(RowSetEvent event);
}
