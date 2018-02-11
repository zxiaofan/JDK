/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

public class JNIHandles {
  private static AddressField      globalHandlesField;
  private static AddressField      weakGlobalHandlesField;
  private static OopField          deletedHandleField;

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
    deletedHandleField = type.getOopField("_deleted_handle");

  }

  public JNIHandles() {
  }

  public JNIHandleBlock globalHandles() {
    Address handleAddr  = globalHandlesField.getValue();
    if (handleAddr == null) {
      return null;
    }
    return new JNIHandleBlock(handleAddr);
  }

  public JNIHandleBlock weakGlobalHandles() {
    Address handleAddr  = weakGlobalHandlesField.getValue();
    if (handleAddr == null) {
      return null;
    }
    return new JNIHandleBlock(handleAddr);
  }

  public OopHandle deletedHandle() {
    return deletedHandleField.getValue();
  }

  public boolean isDeletedHandle(OopHandle handle) {
    return (handle != null && handle.equals(deletedHandle()));
  }

}
