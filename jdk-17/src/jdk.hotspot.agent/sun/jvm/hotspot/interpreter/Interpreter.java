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

package sun.jvm.hotspot.interpreter;

import java.util.*;
import sun.jvm.hotspot.code.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class Interpreter {
  private static AddressField codeField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("AbstractInterpreter");

    codeField     = type.getAddressField("_code");
  }

  public Interpreter() {
  }

  public StubQueue getCode() {
    Address code = codeField.getValue();
    if (code == null) return null;
    return new StubQueue(code, InterpreterCodelet.class);
  }

  public boolean contains(Address pc) {
    return getCode().contains(pc);
  }

  /** Debugging/printing */
  public InterpreterCodelet getCodeletContaining(Address pc) {
    return (InterpreterCodelet) getCode().getStubContaining(pc);
  }
}
