/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

// A HeapVisitor is used for visiting all object in the heap

public interface HeapVisitor {
  // This is called at the beginning of the iteration to provide the
  // HeapVisitor with information about the amount of memory which
  // will be traversed (for example, for displaying a progress bar)
  public void prologue(long usedSize);

  // Callback method for each object
  // Return true if the iteration should be stopped.
  public boolean doObj(Oop obj);

  // This is called after the traversal is complete
  public void epilogue();
};
