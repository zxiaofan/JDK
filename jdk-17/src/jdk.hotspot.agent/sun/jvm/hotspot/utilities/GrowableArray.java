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

package sun.jvm.hotspot.utilities;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class GrowableArray<T> extends GenericGrowableArray {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("GrowableArray<int>");
    dataField = type.getAddressField("_data");
  }

  private static AddressField dataField;

  private InstanceConstructor<T> virtualConstructor;

  public static <S> GrowableArray<S> create(Address addr, InstanceConstructor<S> v) {
    if (addr == null) return null;
    return new GrowableArray<S>(addr, v);
  }

  public T at(int i) {
    if (i < 0 || i >= length()) throw new ArrayIndexOutOfBoundsException(i);
    Address data = dataField.getValue(getAddress());
    Address addr = data.getAddressAt(i * VM.getVM().getAddressSize());
    if (addr == null) return null;
    return (T) virtualConstructor.instantiateWrapperFor(addr);
  }

  private GrowableArray(Address addr, InstanceConstructor<T> v) {
    super(addr);
    virtualConstructor = v;
  }
  public Address getData() {
    return dataField.getValue(getAddress());
  }
}
