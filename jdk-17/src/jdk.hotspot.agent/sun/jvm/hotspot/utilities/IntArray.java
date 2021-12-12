/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;
import sun.jvm.hotspot.types.WrongTypeException;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class IntArray extends GenericArray {
  static {
    VM.registerVMInitializedObserver(new Observer() {
      public void update(Observable o, Object data) {
        initialize(VM.getVM().getTypeDataBase());
      }
    });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    elemType = db.lookupType("int");

    Type type = db.lookupType("Array<int>");
    dataFieldOffset = type.getAddressField("_data").getOffset();
  }

  private static long dataFieldOffset;
  protected static Type elemType;

  public IntArray(Address addr) {
    super(addr, dataFieldOffset);
  }

  public int at(int i) {
    return (int)getIntegerAt(i);
  }

  public Type getElemType() {
    return elemType;
  }
}
