/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.oops.Oop;
import sun.jvm.hotspot.oops.ObjectHeap;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class BasicHashtableEntry extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("BasicHashtableEntry<mtInternal>");
    hashField      = type.getCIntegerField("_hash");
    nextField      = type.getAddressField("_next");
  }

  // Fields
  private static CIntegerField hashField;
  private static AddressField  nextField;

  // Accessors
  public long hash() {
    return hashField.getValue(addr) & 0xFFFFFFFFL;
  }

  private long nextAddressValue() {
    Debugger dbg = VM.getVM().getDebugger();
    Address nextValue = nextField.getValue(addr);
    return (nextValue != null) ? dbg.getAddressValue(nextValue) : 0L;
  }

  public boolean isShared() {
    return (nextAddressValue() & 1L) != 0;
  }

  public BasicHashtableEntry next() {
    Address nextValue = nextField.getValue(addr);
    Address next = (nextValue != null)? nextValue.andWithMask(-2L) : null;
    // using this.getClass so that return type will be as expected in
    // subclass context. But, because we can't use covariant return type
    // caller has to use this next and cast the result to correct type.
    return (BasicHashtableEntry) VMObjectFactory.newObject(this.getClass(), next);
  }

  public BasicHashtableEntry(Address addr) {
    super(addr);
  }
}
