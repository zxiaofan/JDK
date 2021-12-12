/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.proc;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.utilities.*;

class ProcCDebugger implements CDebugger {
  private ProcDebugger dbg;

  ProcCDebugger(ProcDebugger dbg) {
    this.dbg = dbg;
  }

  public List<ThreadProxy> getThreadList() throws DebuggerException {
    return dbg.getThreadList();
  }

  public List<LoadObject> getLoadObjectList() throws DebuggerException {
    return dbg.getLoadObjectList();
  }

  public LoadObject loadObjectContainingPC(Address pc) throws DebuggerException {
    if (pc == null) {
      return null;
    }
    List<LoadObject> objs = getLoadObjectList();
    Object[] arr = objs.toArray();
    // load objects are sorted by base address, do binary search
    int mid  = -1;
    int low  = 0;
    int high = arr.length - 1;

    while (low <= high) {
       mid = (low + high) >> 1;
       LoadObject midVal = (LoadObject) arr[mid];
       long cmp = pc.minus(midVal.getBase());
       if (cmp < 0) {
          high = mid - 1;
       } else if (cmp > 0) {
          long size = midVal.getSize();
          if (cmp >= size) {
             low = mid + 1;
          } else {
             return (LoadObject) arr[mid];
          }
       } else { // match found
          return (LoadObject) arr[mid];
       }
    }
    // no match found.
    return null;
  }

  public CFrame topFrameForThread(ThreadProxy thread) throws DebuggerException {
    return dbg.topFrameForThread(thread);
  }

  public String getNameOfFile(String fileName) {
    return new File(fileName).getName();
  }

  public ProcessControl getProcessControl() throws DebuggerException {
    // FIXME: after stabs parser
    return null;
  }

  // C++ name demangling
  public boolean canDemangle() {
    return true;
  }

  public String demangle(String sym) {
    return dbg.demangle(sym);
  }
}
