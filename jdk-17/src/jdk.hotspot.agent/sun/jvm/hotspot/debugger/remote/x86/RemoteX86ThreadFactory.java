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

package sun.jvm.hotspot.debugger.remote.x86;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.remote.*;

public class RemoteX86ThreadFactory implements RemoteThreadFactory {
  private RemoteDebuggerClient debugger;

  public RemoteX86ThreadFactory(RemoteDebuggerClient debugger) {
    this.debugger = debugger;
  }

  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
    return new RemoteX86Thread(debugger, threadIdentifierAddr);
  }

  public ThreadProxy createThreadWrapper(long id) {
    return new RemoteX86Thread(debugger, id);
  }
}
