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

package sun.jvm.hotspot.debugger.linux.ppc64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.ppc64.*;
import sun.jvm.hotspot.debugger.linux.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.cdbg.basic.*;

final public class LinuxPPC64CFrame extends BasicCFrame {
  // package/class internals only

  public LinuxPPC64CFrame(LinuxDebugger dbg, Address sp, Address pc, int address_size) {
    super(dbg.getCDebugger());
    this.sp = sp;
    this.pc = pc;
    this.dbg = dbg;
    this.address_size = address_size;
  }

  // override base class impl to avoid ELF parsing
  public ClosestSymbol closestSymbolToPC() {
    // try native lookup in debugger.
    return dbg.lookup(dbg.getAddressValue(pc()));
  }

  public Address pc() {
    return pc;
  }

  public Address localVariableBase() {
    return sp;
  }

  public CFrame sender(ThreadProxy thread) {
    if (sp == null) {
      return null;
    }

    Address nextSP = sp.getAddressAt(0);
    if (nextSP == null) {
      return null;
    }
    Address nextPC  = sp.getAddressAt(2 * address_size);
    if (nextPC == null) {
      return null;
    }
    return new LinuxPPC64CFrame(dbg, nextSP, nextPC, address_size);
  }

  public static int PPC64_STACK_BIAS = 0;
  private static int address_size;
  private Address pc;
  private Address sp;
  private LinuxDebugger dbg;
}
