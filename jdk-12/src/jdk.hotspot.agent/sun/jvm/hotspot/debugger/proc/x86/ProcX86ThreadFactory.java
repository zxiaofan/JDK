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

package sun.jvm.hotspot.debugger.proc.x86;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.proc.*;

public class ProcX86ThreadFactory implements ProcThreadFactory {
  private ProcDebugger debugger;

  public ProcX86ThreadFactory(ProcDebugger debugger) {
    this.debugger = debugger;
  }

  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
    return new ProcX86Thread(debugger, threadIdentifierAddr);
  }

  public ThreadProxy createThreadWrapper(long id) {
    return new ProcX86Thread(debugger, id);
  }
}
