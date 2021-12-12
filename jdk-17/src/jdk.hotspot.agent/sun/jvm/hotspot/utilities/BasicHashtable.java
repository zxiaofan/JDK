/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

// Superclass for symbol and string tables.

public class BasicHashtable extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("BasicHashtable<mtInternal>");
    tableSizeField = type.getCIntegerField("_table_size");
    bucketsField   = type.getAddressField("_buckets");
    bucketSize = db.lookupType("HashtableBucket<mtInternal>").getSize();
  }

  // Fields
  private static CIntegerField tableSizeField;
  private static AddressField  bucketsField;
  private static long bucketSize;

  // Accessors
  protected int tableSize() {
    return (int) tableSizeField.getValue(addr);
  }

  protected BasicHashtableEntry bucket(int i) {
    if (Assert.ASSERTS_ENABLED) {
       Assert.that(i >= 0 && i < tableSize(), "Invalid bucket id");
    }
    Address tmp = bucketsField.getValue(addr);
    tmp = tmp.addOffsetTo(i * bucketSize);
    HashtableBucket bucket = VMObjectFactory.newObject(
                                              HashtableBucket.class, tmp);
    return bucket.getEntry(getHashtableEntryClass());
  }

  // derived class may return Class<? extends BasicHashtableEntry>
  protected Class<? extends BasicHashtableEntry> getHashtableEntryClass() {
    return BasicHashtableEntry.class;
  }

  public BasicHashtable(Address addr) {
    super(addr);
  }
}
