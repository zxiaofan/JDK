/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.code;

import java.util.*;

import sun.jvm.hotspot.compiler.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class RuntimeBlob extends CodeBlob {

  // Only used by server compiler on x86; computed over in SA rather
  // than relying on computation in target VM
  private static final int     NOT_YET_COMPUTED = -2;
  private static final int     UNDEFINED        = -1;
  private              int     linkOffset       = NOT_YET_COMPUTED;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static void initialize(TypeDataBase db) {
    Type type = db.lookupType("RuntimeBlob");
  }

  public RuntimeBlob(Address addr) {
    super(addr);
  }
}
