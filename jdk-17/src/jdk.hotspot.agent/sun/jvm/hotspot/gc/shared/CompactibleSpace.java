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

package sun.jvm.hotspot.gc.shared;

import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

/** A space that supports compaction operations.  This is usually, but
    not necessarily, a space that is normally contiguous.  But, for
    example, a free-list-based space whose normal collection is a
    mark-sweep without compaction could still support compaction in
    full GC's. */

public abstract class CompactibleSpace extends Space {
  private static AddressField compactionTopField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("CompactibleSpace");

    compactionTopField = type.getAddressField("_compaction_top");
  }

  public CompactibleSpace(Address addr) {
    super(addr);
  }

  /** May be used temporarily during a compaction phase. */
  public Address compactionTop() {
    return compactionTopField.getValue(addr);
  }
}
