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

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.ci.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class CompilerThread extends JavaThread {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static AddressField envField;

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("CompilerThread");

    envField = type.getAddressField("_env");
  }

  private ciEnv _env;

  public synchronized ciEnv env() {
    if (_env == null) {
      Address v = envField.getValue(this.getAddress());
      if (v != null) {
        _env = new ciEnv(v);
      }
    }
    return _env;
  }

  public CompilerThread(Address addr) {
    super(addr);
  }

  public boolean isJavaThread() { return false; }
  public boolean isHiddenFromExternalView() { return true; }
  public boolean isCompilerThread() { return true; }

}
