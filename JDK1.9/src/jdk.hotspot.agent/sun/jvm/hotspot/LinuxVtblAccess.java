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

import sun.jvm.hotspot.debugger.SymbolLookup;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.basic.BasicVtblAccess;

public class LinuxVtblAccess extends BasicVtblAccess {
  private String vt;

  public LinuxVtblAccess(SymbolLookup symbolLookup,
                         String[] dllNames) {
    super(symbolLookup, dllNames);

    if (symbolLookup.lookup("libjvm.so", "__vt_10JavaThread") != null) {
       // old C++ ABI
       vt = "__vt_";
    } else {
       // new C++ ABI
       vt = "_ZTV";
    }
  }

  protected String vtblSymbolForType(Type type) {
    return vt + type.getName().length() + type;
  }
}
