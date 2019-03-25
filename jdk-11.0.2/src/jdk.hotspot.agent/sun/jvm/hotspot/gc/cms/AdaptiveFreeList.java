/*
 * @(#)AdaptiveFreeList.java
 *
 * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.cms;

import java.util.Observable;
import java.util.Observer;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class AdaptiveFreeList extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
      public void update(Observable o, Object data) {
        initialize(VM.getVM().getTypeDataBase());
      }
    });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("AdaptiveFreeList<FreeChunk>");
    sizeField = type.getCIntegerField("_size");
    countField = type.getCIntegerField("_count");
    headerSize = type.getSize();
  }

  // Fields
  private static CIntegerField sizeField;
  private static CIntegerField countField;
  private static long          headerSize;

  //Constructor
  public AdaptiveFreeList(Address address) {
    super(address);
  }

  // Accessors
  public long size() {
    return sizeField.getValue(addr);
  }

  public long count() {
    return  countField.getValue(addr);
  }

  public static long sizeOf() {
    return headerSize;
  }
}
