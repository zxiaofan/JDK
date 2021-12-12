/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

// VirtualCallData
//
// A VirtualCallData is used to access profiling information about a
// call.  For now, it has nothing more than a ReceiverTypeData.
public class VirtualCallData<K,M> extends ReceiverTypeData<K,M> {
  public VirtualCallData(MethodDataInterface<K,M> methodData, DataLayout layout) {
    super(methodData, layout);
    //assert(layout.tag() == DataLayout.virtualCallDataTag, "wrong type");
  }

  static int staticCellCount() {
    // At this point we could add more profile state, e.g., for arguments.
    // But for now it's the same size as the base record type.
    int cellCount = ReceiverTypeData.staticCellCount();
    return cellCount;
  }

  public int cellCount() {
    return staticCellCount();
  }

  // Direct accessors
  static int virtualCallDataSize() {
    return cellOffset(staticCellCount());
  }

  public void printDataOn(PrintStream st) {
    printShared(st, "VirtualCallData");
    printReceiverDataOn(st);
  }
}
