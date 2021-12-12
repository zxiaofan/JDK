/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2015, Red Hat Inc.
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

package sun.jvm.hotspot.debugger.remote.aarch64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.remote.*;

public class RemoteAARCH64ThreadFactory implements RemoteThreadFactory {
  private RemoteDebuggerClient debugger;

  public RemoteAARCH64ThreadFactory(RemoteDebuggerClient debugger) {
    this.debugger = debugger;
  }

  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
    return new RemoteAARCH64Thread(debugger, threadIdentifierAddr);
  }

  public ThreadProxy createThreadWrapper(long id) {
    return new RemoteAARCH64Thread(debugger, id);
  }
}
