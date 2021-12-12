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

package sun.jvm.hotspot.debugger.bsd.amd64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.amd64.*;
import sun.jvm.hotspot.debugger.bsd.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.cdbg.basic.*;

final public class BsdAMD64CFrame extends BasicCFrame {
   public BsdAMD64CFrame(BsdDebugger dbg, Address rbp, Address rip) {
      super(dbg.getCDebugger());
      this.rbp = rbp;
      this.rip = rip;
      this.dbg = dbg;
   }

   // override base class impl to avoid ELF parsing
   public ClosestSymbol closestSymbolToPC() {
      // try native lookup in debugger.
      return dbg.lookup(dbg.getAddressValue(pc()));
   }

   public Address pc() {
      return rip;
   }

   public Address localVariableBase() {
      return rbp;
   }

   public CFrame sender(ThreadProxy thread) {
      AMD64ThreadContext context = (AMD64ThreadContext) thread.getContext();
      Address rsp = context.getRegisterAsAddress(AMD64ThreadContext.RSP);

      if ( (rbp == null) || rbp.lessThan(rsp) ) {
        return null;
      }

      // Check alignment of rbp
      if (dbg.getAddressValue(rbp) % ADDRESS_SIZE != 0) {
        return null;
      }

      Address nextRBP = rbp.getAddressAt( 0 * ADDRESS_SIZE);
      if (nextRBP == null || nextRBP.lessThanOrEqual(rbp)) {
        return null;
      }
      Address nextPC  = rbp.getAddressAt( 1 * ADDRESS_SIZE);
      if (nextPC == null) {
        return null;
      }
      return new BsdAMD64CFrame(dbg, nextRBP, nextPC);
   }

   // package/class internals only
   private static final int ADDRESS_SIZE = 8;
   private Address rip;
   private Address rbp;
   private BsdDebugger dbg;
}
