/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.utilities;

/** <p> A two-way unbounded-length message queue useful for
    communication between threads. Messages written on one side become
    readable on the other in first-in, first-out order. This is an
    interface to one of two "sides" of an underlying backend, for
    example, the MessageQueueBackend. </p> */

public interface MessageQueue {
  /** This blocks until a message is available. Even if the thread is
      interrupted while it is waiting, this will not return until a
      message is written by the entity on the other side of the
      queue. */
  public Object readMessage();

  /** This blocks for up to <code>millis</code> milliseconds until a
      message is available. If no message becomes available within
      this time period, or the thread is interrupted during the wait,
      returns null. (This implies that passing the value null back and
      forth is not distinguishable with this method.) Passing a value
      of 0 for the <code>millis</code> argument causes this method to
      return without blocking. The millis argument must be greater
      than or equal to zero. */
  public Object readMessageWithTimeout(long millis);

  /** Write a message to the queue */
  public void writeMessage(Object obj);
}
