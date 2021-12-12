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

package sun.jvm.hotspot.utilities;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class GenericGrowableArray extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("GrowableArrayBase");
    _max_field = new CIntField(type.getCIntegerField("_max"), 0);
    _len_field = new CIntField(type.getCIntegerField("_len"), 0);
  }

  private static CIntField _max_field;
  private static CIntField _len_field;

  public int max() {
    return (int)_max_field.getValue(getAddress());
  }

  public int length() {
    return (int)_len_field.getValue(getAddress());
  }

  public GenericGrowableArray(Address addr) {
    super(addr);
  }
}
