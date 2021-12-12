/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class BasicObjectLock extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type  = db.lookupType("BasicObjectLock");
    lockField  = type.getField("_lock");
    objField   = type.getOopField("_obj");
    size       = (int) type.getSize();
  }

  private static sun.jvm.hotspot.types.Field    lockField;
  private static sun.jvm.hotspot.types.OopField objField;
  private static int        size;

  public BasicObjectLock(Address addr) {
    super(addr);
  }

  public OopHandle obj()  { return objField.getValue(addr); }
  public BasicLock lock() { return new BasicLock(addr.addOffsetTo(lockField.getOffset())); }

  /** Note: Use frame::interpreter_frame_monitor_size() for the size
      of BasicObjectLocks in interpreter activation frames since it
      includes machine-specific padding. This routine returns a size
      in BYTES in this system! */
  public static int size() { return size; }

  /** Helper routine for Frames (also probably needed for iteration) */
  public Address address() { return addr; }
}
