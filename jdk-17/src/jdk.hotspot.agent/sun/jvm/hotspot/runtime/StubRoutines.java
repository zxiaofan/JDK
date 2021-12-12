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

package sun.jvm.hotspot.runtime;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

/** Very minimal port for now to get frames working */

public class StubRoutines {
  private static AddressField callStubReturnAddressField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("StubRoutines");
    callStubReturnAddressField = type.getAddressField("_call_stub_return_address");
  }

  public StubRoutines() {
  }

  public boolean returnsToCallStub(Address returnPC) {
    Address addr = callStubReturnAddressField.getValue();
    if (addr == null) {
      return (addr == returnPC);
    } else {
      return (addr.equals(returnPC));
    }
  }
}
