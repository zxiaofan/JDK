/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.remote;

import sun.jvm.hotspot.debugger.*;

public abstract class RemoteThread implements ThreadProxy {
   protected RemoteDebuggerClient debugger;
   protected Address addr;
   protected long id;

   public RemoteThread(RemoteDebuggerClient debugger, Address addr) {
      this.debugger = debugger;
      this.addr = addr;
      this.id = -1L;  // invalid, but don't depend on it. check null for addr
   }

   public RemoteThread(RemoteDebuggerClient debugger, long id) {
      this.debugger = debugger;
      this.addr = null;
      this.id = id;
   }

   public boolean canSetContext() throws DebuggerException {
     return false;
   }

   public void setContext(ThreadContext context)
     throws IllegalThreadStateException, DebuggerException {
     throw new DebuggerException("Unimplemented");
   }

   public boolean equals(Object o) {
      if (o == null) {
         return false;
      }

      if (! (o instanceof RemoteThread)) {
         return false;
      }
      RemoteThread other = (RemoteThread)o;
      boolean isOtherAddress = (other.addr != null);
      boolean isAddress = (addr != null);

      if (isAddress) {
         return (isOtherAddress)? debugger.areThreadsEqual(addr, other.addr) :
                                  debugger.areThreadsEqual(addr, other.id);
      } else {
         return (isOtherAddress)? debugger.areThreadsEqual(id, other.addr) :
                                  debugger.areThreadsEqual(id, other.id);
      }
   }

   public int hashCode() {
      return (addr != null)? debugger.getThreadHashCode(addr) :
                             debugger.getThreadHashCode(id);
   }

   public String toString() {
      return "t@ " + hashCode();
   }
}
