/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.types.basic.*;

/** This class implements the compiler-specific access to the vtbl for
    a given C++ type. */
public class HotSpotSolarisVtblAccess extends BasicVtblAccess {

  public HotSpotSolarisVtblAccess(SymbolLookup symbolLookup,
                                  String[] jvmLibNames) {
    super(symbolLookup, jvmLibNames);
  }

  protected String vtblSymbolForType(Type type) {
    String demangledSymbol = type.getName() + "::__vtbl";
    return mangle(demangledSymbol);
  }

  //--------------------------------------------------------------------------------
  // Internals only below this point
  //

  private String mangle(String symbol) {
    String[] parts = symbol.split("::");
    StringBuffer mangled = new StringBuffer("__1c");
    for (int i = 0; i < parts.length; i++) {
      int len = parts[i].length();
      if (len >= 26) {
        mangled.append((char)('a' + (len / 26)));
        len = len % 26;
      }
      mangled.append((char)('A' + len));
      mangled.append(parts[i]);
    }
    mangled.append("_");
    return mangled.toString();
  }
}
