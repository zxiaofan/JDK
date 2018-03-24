/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

// RetData
//
// A RetData is used to access profiling information for a ret bytecode.
// It is composed of a count of the number of times that the ret has
// been executed, followed by a series of triples of the form
// (bci, count, di) which count the number of times that some bci was the
// target of the ret and cache a corresponding data displacement.
public class RetData extends CounterData {

  static final int   bci0Offset = counterCellCount;
  static final int     count0Offset = bci0Offset + 1;
  static final int     displacement0Offset = count0Offset + 1;
  static final int     retRowCellCount = (displacement0Offset + 1) - bci0Offset;

  public RetData(DataLayout layout) {
    super(layout);
    //assert(layout.tag() == DataLayout.retDataTag, "wrong type");
  }

  static final int noBci = -1; // value of bci when bci1/2 are not in use.

  static int staticCellCount() {
    return counterCellCount + MethodData.BciProfileWidth * retRowCellCount;
  }

  public int cellCount() {
    return staticCellCount();
  }

  static int rowLimit() {
    return MethodData.BciProfileWidth;
  }
  static int bciCellIndex(int row) {
    return bci0Offset + row * retRowCellCount;
  }
  static int bciCountCellIndex(int row) {
    return count0Offset + row * retRowCellCount;
  }
  static int bciDisplacementCellIndex(int row) {
    return displacement0Offset + row * retRowCellCount;
  }

  // Direct accessors
  int bci(int row) {
    return intAt(bciCellIndex(row));
  }
  int bciCount(int row) {
    return uintAt(bciCountCellIndex(row));
  }
  int bciDisplacement(int row) {
    return intAt(bciDisplacementCellIndex(row));
  }

  // Code generation support
  static int bciOffset(int row) {
    return cellOffset(bciCellIndex(row));
  }
  static int bciCountOffset(int row) {
    return cellOffset(bciCountCellIndex(row));
  }
  static int bciDisplacementOffset(int row) {
    return cellOffset(bciDisplacementCellIndex(row));
  }

  public void printDataOn(PrintStream st) {
    printShared(st, "RetData");
    int row;
    int entries = 0;
    for (row = 0; row < rowLimit(); row++) {
      if (bci(row) != noBci)  entries++;
    }
    st.println("count(" + count() + ") entries(" + entries + ")");
    for (row = 0; row < rowLimit(); row++) {
      if (bci(row) != noBci) {
        tab(st);
        st.println(" bci(" + bci(row) + ": count(" + bciCount(row) + ") displacement(" + bciDisplacement(row) + "))");
      }
    }
  }
}
