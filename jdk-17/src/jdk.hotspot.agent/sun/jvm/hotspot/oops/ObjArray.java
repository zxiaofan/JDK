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
 */

package sun.jvm.hotspot.oops;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

// An ObjArray is an array containing oops

public class ObjArray extends Array {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type   = db.lookupType("objArrayOopDesc");
    elementSize = VM.getVM().getHeapOopSize();
  }

  ObjArray(OopHandle handle, ObjectHeap heap) {
    super(handle, heap);
  }

  public boolean isObjArray()          { return true; }

  private static long elementSize;

  public OopHandle getOopHandleAt(long index) {
    long offset = baseOffsetInBytes(BasicType.T_OBJECT) + (index * elementSize);
    if (VM.getVM().isCompressedOopsEnabled()) {
      return getHandle().getCompOopHandleAt(offset);
    } else {
      return getHandle().getOopHandleAt(offset);
    }
  }

  public Oop getObjAt(long index) {
      return getHeap().newOop(getOopHandleAt(index));
  }

  public void printValueOn(PrintStream tty) {
    tty.print("ObjArray");
  }

  public void iterateFields(OopVisitor visitor, boolean doVMFields) {
    super.iterateFields(visitor, doVMFields);
    int length = (int) getLength();
    long baseOffset = baseOffsetInBytes(BasicType.T_OBJECT);
    for (int index = 0; index < length; index++) {
      long offset = baseOffset + (index * elementSize);
      OopField field;
      if (VM.getVM().isCompressedOopsEnabled()) {
        field = new NarrowOopField(new IndexableFieldIdentifier(index), offset, false);
      } else {
        field = new OopField(new IndexableFieldIdentifier(index), offset, false);
      }
      visitor.doOop(field, false);
    }
  }
}
