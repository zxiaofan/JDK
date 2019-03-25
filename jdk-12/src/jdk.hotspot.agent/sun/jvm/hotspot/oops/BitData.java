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

// BitData
//
// A BitData holds a flag or two in its header.
public class BitData extends ProfileData {

  // nullSeen:
  //  saw a null operand (cast/aastore/instanceof)
  static final int nullSeenFlag              = DataLayout.firstFlag + 0;
  static final int bitCellCount = 0;

  public BitData(DataLayout layout) {
    super(layout);
  }

  static int staticCellCount() {
    return bitCellCount;
  }

  public int cellCount() {
    return staticCellCount();
  }

  // Accessor

  // The nullSeen flag bit is specially known to the interpreter.
  // Consulting it allows the compiler to avoid setting up nullCheck traps.
  boolean nullSeen()     { return flagAt(nullSeenFlag); }

  // Code generation support
  // static int nullSeenByteConstant() {
  //   return flagNumberToByteConstant(nullSeenFlag);
  // }

  static int bitDataSize() {
    return cellOffset(bitCellCount);
  }

  public void printDataOn(PrintStream st) {
    printShared(st, "BitData");
  }
}
