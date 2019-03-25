/*
 * Copyright (c) 2000, 2006, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.oops.*;

/** This class wraps a user's chosen HeapVisitor with the
    functionality that a chosen "thunk" is called periodically during
    the heap traversal. This allows a progress bar to be displayed
    during long heap scans. */

public class ProgressiveHeapVisitor implements HeapVisitor {
  private HeapVisitor userHeapVisitor;
  private HeapProgressThunk thunk;
  private long usedSize;
  private long visitedSize;
  private double lastNotificationFraction;
  private static double MINIMUM_NOTIFICATION_FRACTION = 0.01;

  public ProgressiveHeapVisitor(HeapVisitor userHeapVisitor,
                                HeapProgressThunk thunk) {
    this.userHeapVisitor = userHeapVisitor;
    this.thunk = thunk;
  }

  public void prologue(long usedSize) {
    this.usedSize = usedSize;
    visitedSize = 0;
    userHeapVisitor.prologue(usedSize);
    thunk.heapIterationFractionUpdate(0.0);
  }

  public boolean doObj(Oop obj) {
    userHeapVisitor.doObj(obj);
    visitedSize += obj.getObjectSize();
    double curFrac = (double) visitedSize / (double) usedSize;
    if (curFrac > lastNotificationFraction + MINIMUM_NOTIFICATION_FRACTION) {
      thunk.heapIterationFractionUpdate(curFrac);
      lastNotificationFraction = curFrac;
    }
    return false;
  }

  public void epilogue() {
    userHeapVisitor.epilogue();
    thunk.heapIterationComplete();
  }
}
