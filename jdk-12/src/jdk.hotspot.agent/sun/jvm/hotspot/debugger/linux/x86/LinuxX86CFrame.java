/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.linux.x86;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.linux.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.cdbg.basic.*;
import sun.jvm.hotspot.debugger.x86.*;

final public class LinuxX86CFrame extends BasicCFrame {
   // package/class internals only
   public LinuxX86CFrame(LinuxDebugger dbg, Address ebp, Address pc) {
      super(dbg.getCDebugger());
      this.ebp = ebp;
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
      return ebp;
   }

   public CFrame sender(ThreadProxy thread) {
      X86ThreadContext context = (X86ThreadContext) thread.getContext();
      /*
       * Native code fills in the stack pointer register value using index
       * X86ThreadContext.SP.
       * See file LinuxDebuggerLocal.c macro REG_INDEX(reg).
       *
       * Be sure to use SP, or UESP which is aliased to SP in Java code,
       * for the frame pointer validity check.
       */
      Address esp = context.getRegisterAsAddress(X86ThreadContext.SP);

      if ( (ebp == null) || ebp.lessThan(esp) ) {
        return null;
      }

      // Check alignment of ebp
      if ( dbg.getAddressValue(ebp) % ADDRESS_SIZE != 0) {
        return null;
      }

      Address nextEBP = ebp.getAddressAt( 0 * ADDRESS_SIZE);
      if (nextEBP == null || nextEBP.lessThanOrEqual(ebp)) {
        return null;
      }
      Address nextPC  = ebp.getAddressAt( 1 * ADDRESS_SIZE);
      if (nextPC == null) {
        return null;
      }
      return new LinuxX86CFrame(dbg, nextEBP, nextPC);
   }

   private static final int ADDRESS_SIZE = 4;
   private Address pc;
   private Address ebp;
   private LinuxDebugger dbg;
}
