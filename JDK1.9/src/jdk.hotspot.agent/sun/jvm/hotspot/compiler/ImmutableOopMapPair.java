/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.compiler;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

import java.util.Observable;
import java.util.Observer;

public class ImmutableOopMapPair {
  private static CIntegerField pcField;
  private static CIntegerField offsetField;
  private static long classSize;

  static {
    VM.registerVMInitializedObserver(new Observer() {
      public void update(Observable o, Object data) {
        initialize(VM.getVM().getTypeDataBase());
      }
    });
  }

  private final Address address;

  public ImmutableOopMapPair(Address address) {
    this.address = address;
  }

  public static long classSize() {
    return classSize;
  }

  public int getPC() {
    return (int) pcField.getValue(address);
  }

  public int getOffset() {
    return (int) offsetField.getValue(address);
  }

  private static void initialize(TypeDataBase db) {
    Type type = db.lookupType("ImmutableOopMapPair");

    pcField = type.getCIntegerField("_pc_offset");
    offsetField = type.getCIntegerField("_oopmap_offset");
    classSize = type.getSize();
  }

  public String toString() {
    return "Pair{pc_offset = " + getPC() + ", data_offset = " + getOffset() + "}";
  }
}
