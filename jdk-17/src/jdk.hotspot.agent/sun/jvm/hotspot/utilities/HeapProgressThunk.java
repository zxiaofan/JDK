/*
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
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

/** Indicates progress in iterating the heap. Used by
    ProgressiveHeapVisitor and implemented by various GUIs. */

public interface HeapProgressThunk {
  /** Will be called periodically with a number between 0 and 1. */
  public void heapIterationFractionUpdate(double fractionOfHeapVisited);

  /** Will be called after the iteration is complete. */
  public void heapIterationComplete();
}
