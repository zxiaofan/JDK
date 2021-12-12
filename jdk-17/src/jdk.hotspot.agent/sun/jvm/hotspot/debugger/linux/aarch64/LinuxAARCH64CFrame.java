/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.linux.aarch64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.aarch64.*;
import sun.jvm.hotspot.debugger.linux.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.cdbg.basic.*;

final public class LinuxAARCH64CFrame extends BasicCFrame {
   public LinuxAARCH64CFrame(LinuxDebugger dbg, Address fp, Address pc) {
      super(dbg.getCDebugger());
      this.fp = fp;
      this.pc = pc;
      this.dbg = dbg;
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
      return fp;
   }

   public CFrame sender(ThreadProxy thread) {
      AARCH64ThreadContext context = (AARCH64ThreadContext) thread.getContext();
      Address rsp = context.getRegisterAsAddress(AARCH64ThreadContext.SP);

      if ((fp == null) || fp.lessThan(rsp)) {
        return null;
      }

      // Check alignment of fp
      if (dbg.getAddressValue(fp) % (2 * ADDRESS_SIZE) != 0) {
        return null;
      }

      Address nextFP = fp.getAddressAt(0 * ADDRESS_SIZE);
      if (nextFP == null || nextFP.lessThanOrEqual(fp)) {
        return null;
      }
      Address nextPC  = fp.getAddressAt(1 * ADDRESS_SIZE);
      if (nextPC == null) {
        return null;
      }
      return new LinuxAARCH64CFrame(dbg, nextFP, nextPC);
   }

   // package/class internals only
   private static final int ADDRESS_SIZE = 8;
   private Address pc;
   private Address sp;
   private Address fp;
   private LinuxDebugger dbg;
}
