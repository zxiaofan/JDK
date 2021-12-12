/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;

public class ArgInfoData extends ArrayData {

  public ArgInfoData(DataLayout layout) {
    super(layout);
  }

  int numberOfArgs() {
    return arrayLen();
  }

  int argModified(int arg) {
    return arrayUintAt(arg);
  }

  public void printDataOn(PrintStream st) {
    printShared(st, "ArgInfoData");
    int nargs = numberOfArgs();
    for (int i = 0; i < nargs; i++) {
      st.print("  0x" + Integer.toHexString(argModified(i)));
    }
    st.println();
  }
}
