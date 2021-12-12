/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.windbg.amd64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.amd64.*;
import sun.jvm.hotspot.debugger.windbg.*;

class WindbgAMD64Thread implements ThreadProxy {
  private WindbgDebugger debugger;
  private long           sysId; // SystemID for Windows thread, stored in OSThread::_thread_id
  private boolean        gotID;
  private long           id;    // ThreadID for Windows thread,  returned by GetThreadIdBySystemId

  // The address argument must be the address of the OSThread::_thread_id
  WindbgAMD64Thread(WindbgDebugger debugger, Address addr) {
    this.debugger = debugger;
    this.sysId    = (long)addr.getCIntegerAt(0, 4, true);
    gotID         = false;
  }

  WindbgAMD64Thread(WindbgDebugger debugger, long sysId) {
    this.debugger = debugger;
    this.sysId    = sysId;
    gotID         = false;
  }

  public ThreadContext getContext() throws IllegalThreadStateException {
    long[] data = debugger.getThreadIntegerRegisterSet(getThreadID());
    WindbgAMD64ThreadContext context = new WindbgAMD64ThreadContext(debugger);
    // null means we failed to get the register set for some reason. The caller
    // is responsible for dealing with the set of null registers in that case.
    if (data != null) {
        for (int i = 0; i < data.length; i++) {
            context.setRegister(i, data[i]);
        }
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
    if ((obj == null) || !(obj instanceof WindbgAMD64Thread)) {
      return false;
    }

    return (((WindbgAMD64Thread) obj).getThreadID() == getThreadID());
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
       gotID = true;
    }

    return id;
  }
}
