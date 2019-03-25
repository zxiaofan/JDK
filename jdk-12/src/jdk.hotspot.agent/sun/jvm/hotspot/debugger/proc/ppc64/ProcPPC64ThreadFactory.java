/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.proc.ppc64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.proc.*;

public class ProcPPC64ThreadFactory implements ProcThreadFactory {
  private ProcDebugger debugger;

  public ProcPPC64ThreadFactory(ProcDebugger debugger) {
    this.debugger = debugger;
  }

  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
    return new ProcPPC64Thread(debugger, threadIdentifierAddr);
  }

  public ThreadProxy createThreadWrapper(long id) {
    return new ProcPPC64Thread(debugger, id);
  }
}
