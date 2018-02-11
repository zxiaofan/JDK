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

public class ProtectionDomainEntry extends VMObject {
  private static AddressField nextField;
  private static AddressField pdCacheField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("ProtectionDomainEntry");

    nextField = type.getAddressField("_next");
    pdCacheField = type.getAddressField("_pd_cache");
  }

  public ProtectionDomainEntry(Address addr) {
    super(addr);
  }

  public ProtectionDomainEntry next() {
    return (ProtectionDomainEntry) VMObjectFactory.newObject(ProtectionDomainEntry.class, nextField.getValue(addr));
  }

  public Oop protectionDomain() {
    ProtectionDomainCacheEntry pd_cache = (ProtectionDomainCacheEntry)
      VMObjectFactory.newObject(ProtectionDomainCacheEntry.class, pdCacheField.getValue(addr));
    return pd_cache.protectionDomain();
  }
}
