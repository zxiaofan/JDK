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

package sun.jvm.hotspot.prims;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class JvmtiExport {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("JvmtiExport");
    // XXX
    // canAccessLocalVariables =    type.getCIntegerField("_can_access_local_variables");
    // canHotswapOrPostBreakpoint = type.getCIntegerField("_can_hotswap_or_post_breakpoint");
    // canPostOnExceptions =        type.getCIntegerField("_can_post_on_exceptions");
  }

  private static CIntegerField canAccessLocalVariables;
  private static CIntegerField canHotswapOrPostBreakpoint;
  private static CIntegerField canPostOnExceptions;

  public static boolean canAccessLocalVariables() {
    // return canAccessLocalVariables.getValue() != 0;
    return false;
  }
  public static boolean canHotswapOrPostBreakpoint() {
    // return canHotswapOrPostBreakpoint.getValue() != 0;
    return false;
  }
  public static boolean canPostOnExceptions() {
    // return canPostOnExceptions.getValue() != 0;
    return false;
  }
}
