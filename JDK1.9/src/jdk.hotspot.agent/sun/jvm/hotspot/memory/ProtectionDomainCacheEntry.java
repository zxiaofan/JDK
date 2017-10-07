/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.memory;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;

public class ProtectionDomainCacheEntry extends VMObject {
  private static sun.jvm.hotspot.types.OopField protectionDomainField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("ProtectionDomainCacheEntry");
    protectionDomainField = type.getOopField("_literal");
  }

  public ProtectionDomainCacheEntry(Address addr) {
    super(addr);
  }

  public Oop protectionDomain() {
    return VM.getVM().getObjectHeap().newOop(protectionDomainField.getValue(addr));
  }
}
