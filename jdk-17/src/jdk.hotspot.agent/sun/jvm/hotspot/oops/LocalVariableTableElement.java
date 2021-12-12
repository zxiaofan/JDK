/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.interpreter.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class LocalVariableTableElement {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type                 = db.lookupType("LocalVariableTableElement");
    offsetOfStartBCI          = type.getCIntegerField("start_bci").getOffset();
    offsetOfLength            = type.getCIntegerField("length").getOffset();
    offsetOfNameCPIndex       = type.getCIntegerField("name_cp_index").getOffset();
    offsetOfDescriptorCPIndex = type.getCIntegerField("descriptor_cp_index").getOffset();
    offsetOfSignatureCPIndex  = type.getCIntegerField("signature_cp_index").getOffset();
    offsetOfSlot              = type.getCIntegerField("slot").getOffset();
  }

  private static long offsetOfStartBCI;
  private static long offsetOfLength;
  private static long offsetOfNameCPIndex;
  private static long offsetOfDescriptorCPIndex;
  private static long offsetOfSignatureCPIndex;
  private static long offsetOfSlot;

  private Address   handle;
  private long      offset;

  public LocalVariableTableElement(Address handle, long offset) {
    this.handle = handle;
    this.offset = offset;
  }

  public int getStartBCI() {
    return (int) handle.getCIntegerAt(offset + offsetOfStartBCI, 2, true);
  }

  public int getLength() {
    return (int) handle.getCIntegerAt(offset + offsetOfLength, 2, true);
  }

  public int getNameCPIndex() {
    return (int) handle.getCIntegerAt(offset + offsetOfNameCPIndex, 2, true);
  }

  public int getDescriptorCPIndex() {
    return (int) handle.getCIntegerAt(offset + offsetOfDescriptorCPIndex, 2, true);
  }

  public int getSignatureCPIndex() {
    return (int) handle.getCIntegerAt(offset + offsetOfSignatureCPIndex, 2, true);
  }

  public int getSlot() {
    return (int) handle.getCIntegerAt(offset + offsetOfSlot, 2, true);
  }
}
