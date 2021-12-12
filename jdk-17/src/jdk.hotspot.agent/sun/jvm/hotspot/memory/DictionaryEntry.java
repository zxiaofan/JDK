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

package sun.jvm.hotspot.memory;

import java.util.*;
import sun.jvm.hotspot.classfile.ClassLoaderData;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class DictionaryEntry extends sun.jvm.hotspot.utilities.HashtableEntry {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("DictionaryEntry");
  }

  public Klass klass() {
    return (Klass)Metadata.instantiateWrapperFor(literalValue());
  }

  public DictionaryEntry(Address addr) {
    super(addr);
  }

  public boolean equals(Symbol className) {
    InstanceKlass ik = (InstanceKlass) klass();
    return ik.getName().equals(className);
  }

  /* covariant return type :-(
  public DictionaryEntry next() {
    return (DictionaryEntry) super.next();
  }
  For now, let the caller cast it ..
  */
}
