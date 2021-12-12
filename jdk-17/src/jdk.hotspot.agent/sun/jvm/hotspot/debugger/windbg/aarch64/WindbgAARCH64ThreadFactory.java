/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020, Microsoft Corporation. All rights reserved.
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

package sun.jvm.hotspot.debugger.windbg.aarch64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.windbg.*;

public class WindbgAARCH64ThreadFactory implements WindbgThreadFactory {
  private WindbgDebugger debugger;

  public WindbgAARCH64ThreadFactory(WindbgDebugger debugger) {
    this.debugger = debugger;
  }

  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
    return new WindbgAARCH64Thread(debugger, threadIdentifierAddr);
  }

  public ThreadProxy createThreadWrapper(long id) {
    return new WindbgAARCH64Thread(debugger, id);
  }
}
