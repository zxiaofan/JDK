/*
 * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.windbg.x86;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.x86.*;
import sun.jvm.hotspot.debugger.windbg.*;

class WindbgX86Thread implements ThreadProxy {
  private WindbgDebugger debugger;
  private long           sysId;
  private boolean        gotID;
  private long           id;

  // The address argument must be the address of OSThread::_thread_id
  WindbgX86Thread(WindbgDebugger debugger, Address addr) {
    this.debugger = debugger;
    this.sysId    = (long)addr.getCIntegerAt(0, 4, true);
    gotID         = false;
  }

  WindbgX86Thread(WindbgDebugger debugger, long sysId) {
    this.debugger = debugger;
    this.sysId    = sysId;
    gotID         = false;
  }

  public ThreadContext getContext() throws IllegalThreadStateException {
    long[] data = debugger.getThreadIntegerRegisterSet(getThreadID());
    WindbgX86ThreadContext context = new WindbgX86ThreadContext(debugger);
    for (int i = 0; i < data.length; i++) {
      context.setRegister(i, data[i]);
    }
    return context;
  }

  public boolean canSetContext() throws DebuggerException {
    return false;
  }

  public void setContext(ThreadContext thrCtx)
    throws IllegalThreadStateException, DebuggerException {
    throw new DebuggerException("Unimplemented");
  }

  public boolean equals(Object obj) {
    if ((obj == null) || !(obj instanceof WindbgX86Thread)) {
      return false;
    }

    return (((WindbgX86Thread) obj).getThreadID() == getThreadID());
  }

  public int hashCode() {
    return Long.hashCode(getThreadID());
  }

  public String toString() {
    return Long.toString(getThreadID());
  }

  /** Retrieves the thread ID of this thread by examining the Thread
      Information Block. */
  private long getThreadID() {
    if (!gotID) {
       id = debugger.getThreadIdFromSysId(sysId);
    }

    return id;
  }
}
