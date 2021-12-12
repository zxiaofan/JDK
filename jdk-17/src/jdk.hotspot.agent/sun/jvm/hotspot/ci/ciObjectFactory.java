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

package sun.jvm.hotspot.ci;

import java.lang.reflect.Constructor;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ciObjectFactory extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("ciObjectFactory");
    ciMetadataField = type.getAddressField("_ci_metadata");
    symbolsField = type.getAddressField("_symbols");

    ciObjectConstructor = new VirtualBaseConstructor<ciObject>(db, db.lookupType("ciObject"), "sun.jvm.hotspot.ci", ciObject.class);
    ciMetadataConstructor = new VirtualBaseConstructor<ciMetadata>(db, db.lookupType("ciMetadata"), "sun.jvm.hotspot.ci", ciMetadata.class);
    ciSymbolConstructor = new VirtualBaseConstructor<ciSymbol>(db, db.lookupType("ciSymbol"), "sun.jvm.hotspot.ci", ciSymbol.class);
  }

  private static AddressField ciMetadataField;
  private static AddressField symbolsField;

  private static VirtualBaseConstructor<ciObject> ciObjectConstructor;
  private static VirtualBaseConstructor<ciMetadata> ciMetadataConstructor;
  private static VirtualBaseConstructor<ciSymbol> ciSymbolConstructor;

  public static ciObject get(Address addr) {
    if (addr == null) return null;

    return ciObjectConstructor.instantiateWrapperFor(addr);
  }

  public static ciMetadata getMetadata(Address addr) {
    if (addr == null) return null;

    return ciMetadataConstructor.instantiateWrapperFor(addr);
  }

  public GrowableArray<ciMetadata> objects() {
    Address addr = getAddress().addOffsetTo(ciMetadataField.getOffset());
    return GrowableArray.create(addr, ciMetadataConstructor);
  }

  public GrowableArray<ciSymbol> symbols() {
    Address addr = getAddress().addOffsetTo(symbolsField.getOffset());
    return GrowableArray.create(addr, ciSymbolConstructor);
  }

  public ciObjectFactory(Address addr) {
    super(addr);
  }
}
