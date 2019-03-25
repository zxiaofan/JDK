/*
 * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.shared;

import java.io.*;
import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;

public abstract class CollectedHeap extends VMObject {
  private static long         reservedFieldOffset;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("CollectedHeap");

    reservedFieldOffset = type.getField("_reserved").getOffset();
  }

  public CollectedHeap(Address addr) {
    super(addr);
  }

  /** Returns the lowest address of the heap. */
  public Address start() {
    return reservedRegion().start();
  }

  public long capacity() { return 0; }
  public long used()     { return 0; }

  public MemRegion reservedRegion() {
    return new MemRegion(addr.addOffsetTo(reservedFieldOffset));
  }

  public boolean isIn(Address a) {
    return isInReserved(a);
  }

  public boolean isInReserved(Address a) {
    return reservedRegion().contains(a);
  }

  public abstract CollectedHeapName kind();

  public String oopAddressDescription(OopHandle handle) {
      return handle.toString();
  }

  public OopHandle oop_load_at(OopHandle handle, long offset) {
      return handle.getOopHandleAt(offset);
  }

  public void print() { printOn(System.out); }
  public void printOn(PrintStream tty) {
    MemRegion mr = reservedRegion();
    tty.println("unknown subtype of CollectedHeap @ " + getAddress() + " (" +
                mr.start() + "," + mr.end() + ")");
  }
}
