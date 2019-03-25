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

package sun.jvm.hotspot.debugger.proc;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.cdbg.basic.*;

final class ProcCFrame extends BasicCFrame {
   public Address pc() {
      return pc;
   }

   public Address localVariableBase() {
      return fp;
   }

   public CFrame sender(ThreadProxy t) {
      return sender;
   }

   public ClosestSymbol closestSymbolToPC() {
      // we don't use base class ELF parsing based
      // symbol lookup for pc for performance reasons.
      return procDbg.lookup(procDbg.getAddressValue(pc));
   }

   // package/class internals only

   ProcCFrame(ProcDebugger dbg, Address pc, Address fp) {
      super(dbg.getCDebugger());
      this.pc = pc;
      this.fp = fp;
      this.procDbg = dbg;
   }

   void setSender(ProcCFrame sender) {
      this.sender = sender;
   }

   private Address    pc;
   private Address    fp;
   private ProcCFrame sender;
   private ProcDebugger procDbg;
}
