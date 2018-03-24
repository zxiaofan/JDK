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

// Entries to collect type information at a call: contains arguments
// (TypeStackSlotEntries), a return type (ReturnTypeEntry) and a
// number of cells.
public abstract class TypeEntriesAtCall {

  static int stackSlotLocalOffset(int i) {
    return headerCellCount() + TypeStackSlotEntries.stackSlotLocalOffset(i);
  }

  static int argumentTypeLocalOffset(int i) {
    return headerCellCount() + TypeStackSlotEntries.typeLocalOffset(i);
  }

  static int headerCellCount() {
    return 1;
  }

  static int cellCountLocalOffset() {
    return 0;
  }
}
