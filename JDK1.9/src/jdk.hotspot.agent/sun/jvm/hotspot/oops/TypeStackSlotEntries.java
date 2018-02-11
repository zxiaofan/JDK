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

// Type entries used for arguments passed at a call and parameters on
// method entry. 2 cells per entry: one for the type encoded as in
// TypeEntries and one initialized with the stack slot where the
// profiled object is to be found so that the interpreter can locate
// it quickly.
public class TypeStackSlotEntries<K,M> extends TypeEntries<K,M> {
  static final int stackSlotEntry = 0;
  static final int typeEntry = 1;
  static final int perArgCellCount = 2;

  int stackSlotOffset(int i) {
    return baseOff + stackSlotLocalOffset(i);
  }

  final int numberOfEntries;

  int typeOffsetInCells(int i) {
    return baseOff + typeLocalOffset(i);
  }

  TypeStackSlotEntries(MethodDataInterface<K,M> methodData, ProfileData pd, int baseOff, int nbEntries) {
    super(methodData, pd, baseOff);
    numberOfEntries = nbEntries;
  }

  static int stackSlotLocalOffset(int i) {
    return i * perArgCellCount + stackSlotEntry;
  }

  static int typeLocalOffset(int i) {
    return i * perArgCellCount + typeEntry;
  }

  int stackSlot(int i) {
    return pd.uintAt(stackSlotOffset(i));
  }

  K type(int i) {
    return validKlass(typeOffsetInCells(i));
  }

  static int perArgCount() {
    return perArgCellCount;
  }

  int typeIndex(int i) {
    return typeOffsetInCells(i);
  }

  void printDataOn(PrintStream st) {
    for (int i = 0; i < numberOfEntries; i++) {
      pd.tab(st);
      st.print(i + ": stack(" + stackSlot(i)+ ") ");
      printKlass(st, typeOffsetInCells(i));
      st.println();
    }
  }
}
