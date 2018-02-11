/*
 * Copyright (c) 2001, 2005, Oracle and/or its affiliates. All rights reserved.
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

/** A DefaultHeapVisitor implements basic no-op HeapVisitor
    functionality. */

public class DefaultHeapVisitor implements HeapVisitor {
  public void prologue(long usedSize) {}
  public boolean doObj(Oop obj)          {return false;}
  public void epilogue()              {}
}
