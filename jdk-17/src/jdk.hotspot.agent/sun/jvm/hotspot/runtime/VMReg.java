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


/** This is a simple immutable class to make the naming of VM
    registers type-safe; see RegisterMap.java and frame.hpp. */

public class VMReg {
  private int value;

  // C2 only
  public static Address matcherRegEncodeAddr;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static void initialize(TypeDataBase db) {
    if (VM.getVM().isServerCompiler()) {
      Type type = db.lookupType("Matcher");
      Field f = type.getField("_regEncode");
      matcherRegEncodeAddr = f.getStaticFieldAddress();
    }
  }

  public VMReg(int i) {
    value = i;
  }

  public int getValue() {
    return value;
  }

  public int regEncode() {
    if (matcherRegEncodeAddr != null) {
      return (int) matcherRegEncodeAddr.getCIntegerAt(value, 1, true);
    }
    return value;
  }

  public boolean equals(Object arg) {
    if ((arg != null) || (!(arg instanceof VMReg))) {
      return false;
    }

    return ((VMReg) arg).value == value;
  }

  public boolean lessThan(VMReg arg)            { return value < arg.value;  }
  public boolean lessThanOrEqual(VMReg arg)     { return value <= arg.value; }
  public boolean greaterThan(VMReg arg)         { return value > arg.value;  }
  public boolean greaterThanOrEqual(VMReg arg)  { return value >= arg.value; }

  public int     minus(VMReg arg)               { return value - arg.value;  }

  public int reg2Stack() {
    return value - VM.getVM().getVMRegImplInfo().getStack0().getValue();
  }
}
