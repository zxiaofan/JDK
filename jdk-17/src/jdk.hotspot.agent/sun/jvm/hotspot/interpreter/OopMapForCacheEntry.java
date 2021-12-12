/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.interpreter;

import java.util.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.utilities.*;

class OopMapForCacheEntry extends GenerateOopMap {
  private OopMapCacheEntry entry;
  private int              bci;
  private int              stackTop;

  OopMapForCacheEntry(Method method, int bci, OopMapCacheEntry entry) {
    super(method);
    this.entry = entry;
    this.bci = bci;
    this.stackTop = -1;
  }

  public boolean reportResults() { return false; }

  public boolean possibleGCPoint(BytecodeStream bcs) {
    return false; // We are not reporting any result. We call resultForBasicblock directly
  }

  public void fillStackmapProlog(int nof_gc_points) {
    // Do nothing
  }

  public void fillStackmapEpilog() {
    // Do nothing
  }

  public void fillStackmapForOpcodes(BytecodeStream bcs,
                                     CellTypeStateList vars,
                                     CellTypeStateList stack,
                                     int stackTop) {
    // Only interested in one specific bci
    if (bcs.bci() == bci) {
      entry.setMask(vars, stack, stackTop);
      this.stackTop = stackTop;
    }
  }

  public void fillInitVars(List<Integer> initVars) {
    // Do nothing
  }

  public void computeMap() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(!method().isNative(), "cannot compute oop map for native methods");
    }
    // First check if it is a method where the stackmap is always empty
    if (method().getCodeSize() == 0 || method().getMaxLocals() + method().getMaxStack() == 0) {
      entry.setEmptyMask();
    } else {
      super.computeMap();
      resultForBasicblock(bci);
    }
  }

  public int size() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(stackTop != -1, "computeMap must be called first");
    }
    return (int) ((method().isStatic() ? 0 : 1) + method().getMaxLocals() + stackTop);
  }
}
