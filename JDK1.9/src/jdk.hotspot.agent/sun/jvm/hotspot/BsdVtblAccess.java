/*
 * Copyright (c) 2002, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.types.basic.*;

public class BsdVtblAccess extends BasicVtblAccess {
  private String vt;

  public BsdVtblAccess(SymbolLookup symbolLookup,
                         String[] dllNames) {
    super(symbolLookup, dllNames);
    boolean oldVT = false;
    boolean isDarwin = dllNames[0].lastIndexOf(".dylib") != -1;
    String vtJavaThread = isDarwin ? "_vt_10JavaThread" : "__vt_10JavaThread";
    for (String dllName : dllNames) {
       if (symbolLookup.lookup(dllName, vtJavaThread) != null) {
         oldVT = true;
         break;
       }
    }
    if (oldVT) {
       // old C++ ABI
       vt = isDarwin ? "_vt_" :  "__vt_";
    } else {
       // new C++ ABI
       vt = "_ZTV";
    }
  }

  protected String vtblSymbolForType(Type type) {
    return vt + type.getName().length() + type;
  }
}
