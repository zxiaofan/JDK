/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.utilities;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.runtime.*;

public class HashtableBucket extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("HashtableBucket<mtInternal>");
    entryField = type.getAddressField("_entry");
  }

  // Field
  private static AddressField entryField;

  // Accessor - accepts Class<? extends BasicHashtableEntry>
  public BasicHashtableEntry getEntry(Class clazz) {
    Address tmp = entryField.getValue(addr);
    return (BasicHashtableEntry) VMObjectFactory.newObject(clazz, tmp);
  }

  public BasicHashtableEntry entry() {
    return getEntry(HashtableEntry.class);
  }

  public HashtableBucket(Address addr) {
    super(addr);
  }
}
