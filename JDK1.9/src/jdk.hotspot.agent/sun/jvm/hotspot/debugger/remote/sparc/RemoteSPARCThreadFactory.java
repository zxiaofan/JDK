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

package sun.jvm.hotspot.debugger.remote.sparc;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.remote.*;

public class RemoteSPARCThreadFactory implements RemoteThreadFactory {
  private RemoteDebuggerClient debugger;

  public RemoteSPARCThreadFactory(RemoteDebuggerClient debugger) {
    this.debugger = debugger;
  }

  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
    return new RemoteSPARCThread(debugger, threadIdentifierAddr);
  }

  public ThreadProxy createThreadWrapper(long id) {
    return new RemoteSPARCThread(debugger, id);
  }
}
