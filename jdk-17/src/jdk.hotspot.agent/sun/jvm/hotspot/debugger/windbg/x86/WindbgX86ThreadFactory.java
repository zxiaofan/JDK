/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.debugger.windbg.*;

public class WindbgX86ThreadFactory implements WindbgThreadFactory {
  private WindbgDebugger debugger;

  public WindbgX86ThreadFactory(WindbgDebugger debugger) {
    this.debugger = debugger;
  }

  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
    return new WindbgX86Thread(debugger, threadIdentifierAddr);
  }

  public ThreadProxy createThreadWrapper(long id) {
    return new WindbgX86Thread(debugger, id);
  }
}
