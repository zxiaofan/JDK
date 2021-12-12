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
import sun.jvm.hotspot.gc.shared.OopStorage;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class JNIHandles {
  private static AddressField      globalHandlesField;
  private static AddressField      weakGlobalHandlesField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("JNIHandles");

    globalHandlesField = type.getAddressField("_global_handles");
    weakGlobalHandlesField = type.getAddressField("_weak_global_handles");

  }

  public JNIHandles() {
  }

  public OopStorage globalHandles() {
    Address handleAddr  = globalHandlesField.getValue();
    if (handleAddr == null) {
      return null;
    }
    return new OopStorage(handleAddr);
  }

  public OopStorage weakGlobalHandles() {
    Address handleAddr  = weakGlobalHandlesField.getValue();
    if (handleAddr == null) {
      return null;
    }
    return new OopStorage(handleAddr);
  }

}
