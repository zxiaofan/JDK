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
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class Hashtable extends BasicHashtable {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    // just to confirm that type exists
    Type type = db.lookupType("IntptrHashtable");
  }

  protected Class<? extends HashtableEntry> getHashtableEntryClass() {
    return HashtableEntry.class;
  }

  public long computeHash(Symbol name) {
    return name.identityHash();
  }

  public int hashToIndex(long fullHash) {
    return (int) (fullHash % tableSize());
  }

  public Hashtable(Address addr) {
    super(addr);
  }

  // VM's Hashtable::hash_symbol
  protected static long hashSymbol(byte[] buf) {
    long h = 0;
    int s = 0;
    int len = buf.length;
    while (len-- > 0) {
      h = 31*h + (0xFFL & buf[s]);
      s++;
    }
    return h & 0xFFFFFFFFL;
  }
}
