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

package sun.jvm.hotspot.oops;

import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.AddressField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

/** A utility class encapsulating useful oop operations */

// initialize fields for java.lang.Class
public class java_lang_Class {

  // java.lang.Class fields
  static int klassOffset;
  static int arrayKlassOffset;
  static IntField oopSizeField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    // klass and oop_size are HotSpot magic fields and hence we can't
    // find them from InstanceKlass for java.lang.Class.
    Type jlc = db.lookupType("java_lang_Class");
    klassOffset = (int) jlc.getCIntegerField("_klass_offset").getValue();
    arrayKlassOffset = (int) jlc.getCIntegerField("_array_klass_offset").getValue();
    int oopSizeOffset = (int) jlc.getCIntegerField("_oop_size_offset").getValue();
    oopSizeField = new IntField(new NamedFieldIdentifier("oop_size"), oopSizeOffset, true);
  }

  /** get Klass* field at offset hc_klass_offset from a java.lang.Class object */
  public static Klass asKlass(Oop aClass) {
    return (Klass)Metadata.instantiateWrapperFor(aClass.getHandle().getAddressAt(klassOffset));
  }

  /** get oop_size field at offset oop_size_offset from a java.lang.Class object */
  public static long getOopSize(Oop aClass) {
    return java_lang_Class.oopSizeField.getValue(aClass);
  }

  /**
   * Returns the Java name for this Java mirror
   */
  public static String asExternalName(Oop aClass) {
    Klass k = java_lang_Class.asKlass(aClass);
    if (k == null) { // primitive array
      BasicType type = BasicType.T_VOID;
      ArrayKlass ak = (ArrayKlass)Metadata.instantiateWrapperFor(
                             aClass.getHandle().getAddressAt(arrayKlassOffset));
      if (ak != null) {
        type = BasicType.intToBasicType(ak.getElementType());
      }
      return type.getName();
    } else {
      return k.getName().asString();
    }
  }

}
