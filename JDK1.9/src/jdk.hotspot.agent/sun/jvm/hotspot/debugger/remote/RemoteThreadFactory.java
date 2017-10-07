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

/** An interface used only internally by the ProcDebugger to be able to
    create platform-specific Thread objects */

public interface RemoteThreadFactory {
  public ThreadProxy createThreadWrapper(Address threadIdentifierAddr);
  public ThreadProxy createThreadWrapper(long id);
}
