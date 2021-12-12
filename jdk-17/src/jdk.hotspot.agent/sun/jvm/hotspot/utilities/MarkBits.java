/*
 * Copyright (c) 2001, 2019, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.gc.shared.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.*;

/** Helper class which covers the reserved area of the heap with an
    (object-external) set of mark bits, used for GC-like scans through
    the heap like liveness analysis. */

public class MarkBits {
  public MarkBits(CollectedHeap heap) {
    MemRegion reserved = heap.reservedRegion();
    // Must cover "reserved" with one bit for each OopHandle
    start = reserved.start();
    end   = reserved.end();
    long numOopHandles = end.minus(start) / VM.getVM().getOopSize();
    bits = heap.createBitMap(numOopHandles);
  }

  public void clear() {
    bits.clear();
  }

  /** Returns true if a mark was newly placed for the given Oop, or
      false if the Oop was already marked. If the Oop happens to lie
      outside the heap (should not happen), prints a warning and
      returns false. */
  public boolean mark(Oop obj) {
    if (obj == null) {
      System.err.println("MarkBits: WARNING: null object, ignoring");
      return false;
    }

    OopHandle handle = obj.getHandle();
    long idx = handle.minus(start) / VM.getVM().getOopSize();
    if (bits.at(idx)) {
      return false; // already marked
    }
    bits.atPut(idx, true);
    return true;
  }

  /** Forces clearing of a given mark bit. */
  public void clear(Oop obj) {
    OopHandle handle = obj.getHandle();
    long idx = handle.minus(start) / VM.getVM().getOopSize();
    bits.atPut(idx, false);
  }

  private BitMapInterface bits;
  private Address start;
  private Address end;
}
