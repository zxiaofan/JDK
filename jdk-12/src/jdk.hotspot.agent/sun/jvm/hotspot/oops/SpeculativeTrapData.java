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

// SpeculativeTrapData
//
// A SpeculativeTrapData is used to record traps due to type
// speculation. It records the root of the compilation.
public class SpeculativeTrapData<K, M> extends ProfileData {
  static final int speculativeTrapMethod = 0;
  static final int speculativeTrapCellCount = 1;
  final MethodDataInterface<K, M> methodData;

  public SpeculativeTrapData(MethodDataInterface<K,M> methodData, DataLayout layout) {
    super(layout);
    this.methodData = methodData;
  }

  static int staticCellCount() {
    return speculativeTrapCellCount;
  }

  public int cellCount() {
    return staticCellCount();
  }

  public M method() {
    return methodData.getMethodAtAddress(addressAt(speculativeTrapMethod));
  }

  static public int methodIndex() {
    return speculativeTrapMethod;
  }

  public void printDataOn(PrintStream st) {
    printShared(st, "SpeculativeTrapData");
    tab(st);
    methodData.printMethodValueOn(method(), st);
    st.println();
  }
}
