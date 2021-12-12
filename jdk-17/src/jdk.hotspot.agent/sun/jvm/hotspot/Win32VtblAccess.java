/*
 * Copyright (c) 2000, 2002, Oracle and/or its affiliates. All rights reserved.
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

/** This class implements the compiler-specific access to the vtbl for
    a given C++ type. As it happens, on Win32 (at least for Visual C++
    6.0) the name mangling for vtbls is very straightforward. We only
    need to ensure that these symbols are exported from the HotSpot
    DLL, which is done with a .DEF file. This class is named
    "Win32VtblAccess" because it is not necessarily HotSpot-specific. */

public class Win32VtblAccess extends BasicVtblAccess {
  public Win32VtblAccess(SymbolLookup symbolLookup,
                         String[] dllNames) {
    super(symbolLookup, dllNames);
  }

  protected String vtblSymbolForType(Type type) {
    return "??_7" + type.getName() + "@@6B@";
  }
}
