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

// ParametersTypeData
//
// A ParametersTypeData is used to access profiling information about
// types of parameters to a method
public class ParametersTypeData<K,M> extends ArrayData {
  final TypeStackSlotEntries<K,M> parameters;

  static int stackSlotLocalOffset(int i) {
    return arrayStartOffSet + TypeStackSlotEntries.stackSlotLocalOffset(i);
  }

  static int typeLocalOffset(int i) {
    return arrayStartOffSet + TypeStackSlotEntries.typeLocalOffset(i);
  }

  public ParametersTypeData(MethodDataInterface<K,M> methodData, DataLayout layout) {
    super(layout);
    parameters = new TypeStackSlotEntries<K,M>(methodData, this, 1, numberOfParameters());
  }

  public int numberOfParameters() {
    return arrayLen() / TypeStackSlotEntries.perArgCount();
  }

  int stackSlot(int i) {
    return parameters.stackSlot(i);
  }

  public K type(int i) {
    return parameters.type(i);
  }

  static public int typeIndex(int i) {
    return typeLocalOffset(i);
  }

  public void printDataOn(PrintStream st) {
    st.print("parameter types");
    parameters.printDataOn(st);
  }
}
