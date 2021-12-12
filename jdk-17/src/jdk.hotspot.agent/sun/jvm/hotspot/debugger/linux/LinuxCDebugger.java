/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2015, Red Hat Inc.
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

package sun.jvm.hotspot.debugger.linux;

import java.io.*;
import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.x86.*;
import sun.jvm.hotspot.debugger.amd64.*;
import sun.jvm.hotspot.debugger.aarch64.*;
import sun.jvm.hotspot.debugger.ppc64.*;
import sun.jvm.hotspot.debugger.linux.x86.*;
import sun.jvm.hotspot.debugger.linux.amd64.*;
import sun.jvm.hotspot.debugger.linux.ppc64.*;
import sun.jvm.hotspot.debugger.linux.aarch64.*;
import sun.jvm.hotspot.utilities.*;

class LinuxCDebugger implements CDebugger {
  private LinuxDebugger dbg;

  LinuxCDebugger(LinuxDebugger dbg) {
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

    /* Typically we have about ten loaded objects here. So no reason to do
      sort/binary search here. Linear search gives us acceptable performance.*/

    List<LoadObject> objs = getLoadObjectList();

    for (int i = 0; i < objs.size(); i++) {
      LoadObject ob = (LoadObject) objs.get(i);
      Address base = ob.getBase();
      long size = ob.getSize();
      if (pc.greaterThanOrEqual(base) && pc.lessThan(base.addOffsetTo(size))) {
        return ob;
      }
    }

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
       return new LinuxX86CFrame(dbg, ebp, pc);
    } else if (cpu.equals("amd64")) {
       AMD64ThreadContext context = (AMD64ThreadContext) thread.getContext();
       Address pc  = context.getRegisterAsAddress(AMD64ThreadContext.RIP);
       if (pc == null) return null;
       return LinuxAMD64CFrame.getTopFrame(dbg, pc, context);
    }  else if (cpu.equals("ppc64")) {
        PPC64ThreadContext context = (PPC64ThreadContext) thread.getContext();
        Address sp = context.getRegisterAsAddress(PPC64ThreadContext.SP);
        if (sp == null) return null;
        Address pc  = context.getRegisterAsAddress(PPC64ThreadContext.PC);
        if (pc == null) return null;
        return new LinuxPPC64CFrame(dbg, sp, pc, LinuxDebuggerLocal.getAddressSize());
    } else if (cpu.equals("aarch64")) {
       AARCH64ThreadContext context = (AARCH64ThreadContext) thread.getContext();
       Address fp = context.getRegisterAsAddress(AARCH64ThreadContext.FP);
       if (fp == null) return null;
       Address pc  = context.getRegisterAsAddress(AARCH64ThreadContext.PC);
       if (pc == null) return null;
       return new LinuxAARCH64CFrame(dbg, fp, pc);
     } else {
       // Runtime exception thrown by LinuxThreadContextFactory if unknown cpu
       ThreadContext context = (ThreadContext) thread.getContext();
       return context.getTopFrame(dbg);
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
    return true;
  }

  public String demangle(String sym) {
    return dbg.demangle(sym);
  }
}
