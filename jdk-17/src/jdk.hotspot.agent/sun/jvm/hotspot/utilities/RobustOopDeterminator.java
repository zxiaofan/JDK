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

package sun.jvm.hotspot.utilities;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.oops.Metadata;
import sun.jvm.hotspot.oops.Klass;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

/** This class determines to the best of its ability, and in a
    reasonably robust fashion, whether a given pointer is an intact
    oop or not. It does this by checking the integrity of the
    metaclass hierarchy. This is only intended for use in the
    debugging system. It may provide more resilience to unexpected VM
    states than the ObjectHeap code. */

public class RobustOopDeterminator {
  private static AddressField klassField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static void initialize(TypeDataBase db) {
    Type type = db.lookupType("oopDesc");

    if (VM.getVM().isCompressedKlassPointersEnabled()) {
      klassField = type.getAddressField("_metadata._compressed_klass");
    } else {
      klassField = type.getAddressField("_metadata._klass");
    }
  }

  public static boolean oopLooksValid(OopHandle oop) {
    if (oop == null) {
      return false;
    }
    if (!VM.getVM().getUniverse().isIn(oop)) {
      return false;
    }
    try {
      // Try to instantiate the Klass
      if (VM.getVM().isCompressedKlassPointersEnabled()) {
        Metadata.instantiateWrapperFor(oop.getCompKlassAddressAt(klassField.getOffset()));
      } else {
        Metadata.instantiateWrapperFor(klassField.getValue(oop));
      }
      return true;
    } catch (AddressException e) {
      return false;
    } catch (WrongTypeException e) {
      return false;
    }
  }
}
