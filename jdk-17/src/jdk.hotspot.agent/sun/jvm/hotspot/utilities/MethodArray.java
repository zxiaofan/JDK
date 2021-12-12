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
import sun.jvm.hotspot.oops.Metadata;
import sun.jvm.hotspot.oops.Method;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;
import sun.jvm.hotspot.types.WrongTypeException;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class MethodArray extends GenericArray {
  static {
    VM.registerVMInitializedObserver(new Observer() {
      public void update(Observable o, Object data) {
        initialize(VM.getVM().getTypeDataBase());
      }
    });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    elemType = db.lookupType("Method*");

    Type type = db.lookupType("Array<Method*>");
    dataFieldOffset = type.getAddressField("_data").getOffset();
  }

  private static long dataFieldOffset;
  protected static Type elemType;

  public MethodArray(Address addr) {
    super(addr, dataFieldOffset);
  }

  public Method at(int i) {
    return (Method) Metadata.instantiateWrapperFor(getAddressAt(i));
  }

  public Type getElemType() {
    return elemType;
  }
}
