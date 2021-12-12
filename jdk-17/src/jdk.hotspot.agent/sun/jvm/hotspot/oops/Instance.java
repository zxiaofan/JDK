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

// An Instance is an instance of a Java Class

public class Instance extends Oop {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }
  private static long typeSize;

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type = db.lookupType("instanceOopDesc");
    typeSize = type.getSize();
  }

  Instance(OopHandle handle, ObjectHeap heap) {
    super(handle, heap);
  }

  // Returns header size in bytes.
  public static long getHeaderSize() {
    if (VM.getVM().isCompressedKlassPointersEnabled()) {
      return typeSize - VM.getVM().getIntSize();
    } else {
      return typeSize;
    }
  }

  public boolean isInstance()          { return true; }

  public void iterateFields(OopVisitor visitor, boolean doVMFields) {
    super.iterateFields(visitor, doVMFields);
    ((InstanceKlass) getKlass()).iterateNonStaticFields(visitor, this);
  }

  public void printValueOn(PrintStream tty) {
    // Special-case strings.
    // FIXME: would like to do this in more type-safe fashion (need
    // SystemDictionary analogue)
    if (getKlass().getName().asString().equals("java/lang/String")) {
      tty.print("\"" + OopUtilities.stringOopToString(this) + "\"");
    } else {
      super.printValueOn(tty);
    }
  }
}
