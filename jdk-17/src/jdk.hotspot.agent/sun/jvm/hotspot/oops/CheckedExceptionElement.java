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

public class CheckedExceptionElement {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type            = db.lookupType("CheckedExceptionElement");
    offsetOfClassCPIndex = type.getCIntegerField("class_cp_index").getOffset();
  }

  private static long offsetOfClassCPIndex;

  private Address   handle;
  private long      offset;

  public CheckedExceptionElement(Address handle, long offset) {
    this.handle = handle;
    this.offset = offset;
  }

  public int getClassCPIndex() {
    return (int) handle.getCIntegerAt(offset + offsetOfClassCPIndex, 2, true);
  }
}
