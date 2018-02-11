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

package sun.jvm.hotspot.debugger.windows.amd64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.amd64.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.cdbg.basic.*;
import sun.jvm.hotspot.debugger.windbg.*;

public class WindowsAMD64CFrame extends BasicCFrame {
  private Address rbp;
  private Address pc;

  private static final int ADDRESS_SIZE = 8;

  /** Constructor for topmost frame */
  public WindowsAMD64CFrame(WindbgDebugger dbg, Address rbp, Address pc) {
    super(dbg.getCDebugger());
    this.rbp = rbp;
    this.pc  = pc;
    this.dbg = dbg;
  }

  public CFrame sender(ThreadProxy thread) {
    AMD64ThreadContext context = (AMD64ThreadContext) thread.getContext();
    Address rsp = context.getRegisterAsAddress(AMD64ThreadContext.RSP);

    if ( (rbp == null) || rbp.lessThan(rsp) ) {
      return null;
    }

    // Check alignment of rbp
    if ( dbg.getAddressValue(rbp) % ADDRESS_SIZE != 0) {
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
    return new WindowsAMD64CFrame(dbg, nextRBP, nextPC);
  }

  public Address pc() {
    return pc;
  }

  public Address localVariableBase() {
    return rbp;
  }

  private WindbgDebugger dbg;
}
