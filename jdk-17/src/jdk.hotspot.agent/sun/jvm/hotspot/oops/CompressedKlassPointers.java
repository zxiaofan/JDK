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

package sun.jvm.hotspot.oops;

import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.types.AddressField;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class CompressedKlassPointers {
  private static AddressField baseField;
  private static CIntegerField shiftField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static boolean typeExists(TypeDataBase db, String type) {
      try {
          db.lookupType(type);
      } catch (RuntimeException e) {
          return false;
      }
      return true;
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("CompressedKlassPointers");

    baseField = type.getAddressField("_narrow_klass._base");
    shiftField = type.getCIntegerField("_narrow_klass._shift");
  }

  public CompressedKlassPointers() {
  }

  public static long getBase() {
    if (baseField.getValue() == null) {
      return 0;
    } else {
      return baseField.getValue().minus(null);
    }
  }

  public static int getShift() {
    return (int)shiftField.getValue();
  }
}
