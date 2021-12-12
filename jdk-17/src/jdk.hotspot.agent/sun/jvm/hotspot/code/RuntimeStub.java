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

package sun.jvm.hotspot.code;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class RuntimeStub extends RuntimeBlob {
  private static CIntegerField callerMustGCArgumentsField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static void initialize(TypeDataBase db) {
    Type type = db.lookupType("RuntimeStub");
    callerMustGCArgumentsField                = type.getCIntegerField("_caller_must_gc_arguments");

    // FIXME: add any needed fields
  }

  public RuntimeStub(Address addr) {
    super(addr);
  }

  public boolean isRuntimeStub() {
    return true;
  }

  public boolean callerMustGCArguments() {
    return callerMustGCArgumentsField.getValue(addr) != 0;
  }


  public String getName() {
    return "RuntimeStub: " + super.getName();
  }
}
