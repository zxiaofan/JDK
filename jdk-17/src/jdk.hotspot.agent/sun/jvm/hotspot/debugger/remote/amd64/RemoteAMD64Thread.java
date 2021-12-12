/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.remote.amd64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.amd64.*;
import sun.jvm.hotspot.debugger.remote.*;
import sun.jvm.hotspot.utilities.*;

public class RemoteAMD64Thread extends RemoteThread  {
  public RemoteAMD64Thread(RemoteDebuggerClient debugger, Address addr) {
     super(debugger, addr);
  }

  public RemoteAMD64Thread(RemoteDebuggerClient debugger, long id) {
     super(debugger, id);
  }

  public ThreadContext getContext() throws IllegalThreadStateException {
    RemoteAMD64ThreadContext context = new RemoteAMD64ThreadContext(debugger);
    long[] regs = (addr != null)? debugger.getThreadIntegerRegisterSet(addr) :
                                  debugger.getThreadIntegerRegisterSet(id);
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(regs.length == AMD64ThreadContext.NPRGREG, "size of register set must match");
    }
    for (int i = 0; i < regs.length; i++) {
      context.setRegister(i, regs[i]);
    }
    return context;
  }
}
