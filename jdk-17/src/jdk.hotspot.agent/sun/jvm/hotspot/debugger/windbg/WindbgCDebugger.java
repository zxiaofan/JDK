/*
 * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.windbg;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.x86.*;
import sun.jvm.hotspot.debugger.amd64.*;
import sun.jvm.hotspot.debugger.windows.x86.*;
import sun.jvm.hotspot.debugger.windows.amd64.*;
import sun.jvm.hotspot.utilities.AddressOps;

class WindbgCDebugger implements CDebugger {
  // FIXME: think about how to make this work in a remote debugging
  // scenario; who should keep open DLLs? Need local copies of these
  // DLLs on the debugging machine?
  private WindbgDebugger dbg;

  WindbgCDebugger(WindbgDebugger dbg) {
    this.dbg = dbg;
  }

  public List<ThreadProxy> getThreadList() throws DebuggerException {
    return dbg.getThreadList();
  }

  public List<LoadObject> getLoadObjectList() throws DebuggerException{
    return dbg.getLoadObjectList();
  }

  public LoadObject loadObjectContainingPC(Address pc) throws DebuggerException {
    // FIXME: could keep sorted list of these to be able to do binary
    // searches, for better scalability
    if (pc == null) {
      return null;
    }
    List<LoadObject> objs = getLoadObjectList();
    for (Iterator iter = objs.iterator(); iter.hasNext(); ) {
      LoadObject obj = (LoadObject) iter.next();
      if (AddressOps.lte(obj.getBase(), pc) && (pc.minus(obj.getBase()) < obj.getSize())) {
        return obj;
      }
    }
    return null;
  }

  public CFrame topFrameForThread(ThreadProxy thread) throws DebuggerException {
    if (dbg.getCPU().equals("x86")) {
      X86ThreadContext context = (X86ThreadContext) thread.getContext();
      Address ebp = context.getRegisterAsAddress(X86ThreadContext.EBP);
      if (ebp == null) return null;
      Address pc  = context.getRegisterAsAddress(X86ThreadContext.EIP);
      if (pc == null) return null;
      return new WindowsX86CFrame(dbg, ebp, pc);
    } else if (dbg.getCPU().equals("amd64")) {
      AMD64ThreadContext context = (AMD64ThreadContext) thread.getContext();
      Address rbp = context.getRegisterAsAddress(AMD64ThreadContext.RBP);
      if (rbp == null) return null;
      Address pc  = context.getRegisterAsAddress(AMD64ThreadContext.RIP);
      if (pc == null) return null;
      return new WindowsAMD64CFrame(dbg, rbp, pc);
    } else {
      // unsupported CPU!
      return null;
    }
  }

  public String getNameOfFile(String fileName) {
    return new File(fileName).getName();
  }

  public ProcessControl getProcessControl() throws DebuggerException {
    return null;
  }

  // C++ name demangling
  public boolean canDemangle() {
    return false;
  }

  public String demangle(String sym) {
    throw new UnsupportedOperationException();
  }
}
