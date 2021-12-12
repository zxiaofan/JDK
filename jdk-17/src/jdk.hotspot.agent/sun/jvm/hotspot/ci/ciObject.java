/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.ci;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ciObject extends ciBaseObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("ciObject");
    klassField = type.getAddressField("_klass");
    handleField = type.getAddressField("_handle");
  }

  private static AddressField klassField;
  private static AddressField handleField;

  public Oop getOop() {
    OopHandle oh =  handleField.getValue(getAddress()).getOopHandleAt(0);
    return VM.getVM().getObjectHeap().newOop(oh);
  }

  public ciObject(Address addr) {
    super(addr);
  }

  public void printOn(PrintStream out) {
    getOop().printValueOn(out);
    out.println();
  }

  public String toString() {
    return getOop().toString();
  }
}
