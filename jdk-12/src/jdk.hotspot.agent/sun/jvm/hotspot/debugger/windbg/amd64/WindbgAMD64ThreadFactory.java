/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.debugger.windbg.*;

public class WindbgAMD64ThreadFactory implements WindbgThreadFactory {
  private WindbgDebugger debugger;

  public WindbgAMD64ThreadFactory(WindbgDebugger debugger) {
    this.debugger = debugger;
  }

  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
    return new WindbgAMD64Thread(debugger, threadIdentifierAddr);
  }

  public ThreadProxy createThreadWrapper(long id) {
    return new WindbgAMD64Thread(debugger, id);
  }
}
