/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;

/** These will never show up in the threads list (from Threads.first()) */

public class WatcherThread extends Thread {
  public WatcherThread(Address addr) {
    super(addr);
  }

  public boolean isWatcherThread() { return true; }
}
