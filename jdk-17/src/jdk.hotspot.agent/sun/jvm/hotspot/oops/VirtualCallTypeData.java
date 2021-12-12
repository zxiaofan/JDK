/*
 * Copyright (c) 2014, 2020, Oracle and/or its affiliates. All rights reserved.
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

// VirtualCallTypeData
//
// A VirtualCallTypeData is used to access profiling information about
// a virtual call for which we collect type information about
// arguments and return value.
public class VirtualCallTypeData<K,M> extends VirtualCallData<K,M> implements CallTypeDataInterface<K> {
  final TypeStackSlotEntries<K,M> args;
  final ReturnTypeEntry<K,M> ret;

  int cellCountGlobalOffset() {
    return VirtualCallData.staticCellCount() + TypeEntriesAtCall.cellCountLocalOffset();
  }

  int cellCountNoHeader() {
    return uintAt(cellCountGlobalOffset());
  }

  public VirtualCallTypeData(MethodDataInterface<K,M> methodData, DataLayout layout) {
    super(methodData, layout);
    args = new TypeStackSlotEntries<K,M>(methodData, this, VirtualCallData.staticCellCount()+TypeEntriesAtCall.headerCellCount(), numberOfArguments());
    ret = new ReturnTypeEntry<K,M>(methodData, this, cellCount() - ReturnTypeEntry.staticCellCount());
  }

  static int staticCellCount() {
    return -1;
  }

  public int cellCount() {
    return VirtualCallData.staticCellCount() +
      TypeEntriesAtCall.headerCellCount() +
      intAt(cellCountGlobalOffset());
  }

  public int numberOfArguments() {
    return cellCountNoHeader() / TypeStackSlotEntries.perArgCount();
  }

  public boolean hasArguments() {
    return cellCountNoHeader() >= TypeStackSlotEntries.perArgCount();
  }

  public K argumentType(int i) {
    return args.type(i);
  }

  public boolean hasReturn() {
    return (cellCountNoHeader() % TypeStackSlotEntries.perArgCount()) != 0;
  }

  public K returnType() {
    return ret.type();
  }

  public int argumentTypeIndex(int i) {
    return args.typeIndex(i);
  }

  public int returnTypeIndex() {
    return ret.typeIndex();
  }

  public void printDataOn(PrintStream st) {
    super.printDataOn(st);
    if (hasArguments()) {
      tab(st);
      st.print("argument types");
      args.printDataOn(st);
    }
    if (hasReturn()) {
      tab(st);
      st.print("return type");
      ret.printDataOn(st);
    }
  }
};
