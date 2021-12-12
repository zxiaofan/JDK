/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.bsd.x86;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.bsd.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.cdbg.basic.*;
import sun.jvm.hotspot.debugger.x86.*;

final public class BsdX86CFrame extends BasicCFrame {
   // package/class internals only
   public BsdX86CFrame(BsdDebugger dbg, Address ebp, Address pc) {
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
      Address esp = context.getRegisterAsAddress(X86ThreadContext.ESP);

      if ( (ebp == null) || ebp.lessThan(esp) ) {
        return null;
      }

      Address nextEBP = ebp.getAddressAt( 0 * ADDRESS_SIZE);
      if (nextEBP == null) {
        return null;
      }
      Address nextPC  = ebp.getAddressAt( 1 * ADDRESS_SIZE);
      if (nextPC == null) {
        return null;
      }
      return new BsdX86CFrame(dbg, nextEBP, nextPC);
   }

   private static final int ADDRESS_SIZE = 4;
   private Address pc;
   private Address ebp;
   private BsdDebugger dbg;
}
