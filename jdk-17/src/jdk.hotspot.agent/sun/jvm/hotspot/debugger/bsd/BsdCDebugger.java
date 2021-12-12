/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2021, Azul Systems, Inc. All rights reserved.
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

package sun.jvm.hotspot.debugger.bsd;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.x86.*;
import sun.jvm.hotspot.debugger.amd64.*;
import sun.jvm.hotspot.debugger.aarch64.*;
import sun.jvm.hotspot.debugger.bsd.x86.*;
import sun.jvm.hotspot.debugger.bsd.amd64.*;
import sun.jvm.hotspot.debugger.bsd.aarch64.*;
import sun.jvm.hotspot.utilities.*;

class BsdCDebugger implements CDebugger {
  private BsdDebugger dbg;

  BsdCDebugger(BsdDebugger dbg) {
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
    String cpu = dbg.getCPU();
    if (cpu.equals("x86")) {
       X86ThreadContext context = (X86ThreadContext) thread.getContext();
       Address ebp = context.getRegisterAsAddress(X86ThreadContext.EBP);
       if (ebp == null) return null;
       Address pc  = context.getRegisterAsAddress(X86ThreadContext.EIP);
       if (pc == null) return null;
       return new BsdX86CFrame(dbg, ebp, pc);
    } else if (cpu.equals("amd64") || cpu.equals("x86_64")) {
       AMD64ThreadContext context = (AMD64ThreadContext) thread.getContext();
       Address rbp = context.getRegisterAsAddress(AMD64ThreadContext.RBP);
       if (rbp == null) return null;
       Address pc  = context.getRegisterAsAddress(AMD64ThreadContext.RIP);
       if (pc == null) return null;
       return new BsdAMD64CFrame(dbg, rbp, pc);
    } else if (cpu.equals("aarch64")) {
       AARCH64ThreadContext context = (AARCH64ThreadContext) thread.getContext();
       Address fp = context.getRegisterAsAddress(AARCH64ThreadContext.FP);
       if (fp == null) return null;
       Address pc  = context.getRegisterAsAddress(AARCH64ThreadContext.PC);
       if (pc == null) return null;
       return new BsdAARCH64CFrame(dbg, fp, pc);
    } else {
       throw new DebuggerException(cpu + " is not yet supported");
    }
  }

  public String getNameOfFile(String fileName) {
    return new File(fileName).getName();
  }

  public ProcessControl getProcessControl() throws DebuggerException {
    // FIXME: after stabs parser
    return null;
  }

  public boolean canDemangle() {
    return false;
  }

  public String demangle(String sym) {
    throw new UnsupportedOperationException();
  }
}
