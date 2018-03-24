/*
 * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.shared;

import sun.jvm.hotspot.debugger.*;

/** No additional functionality for now */

public class OffsetTableContigSpace extends ContiguousSpace {
  public OffsetTableContigSpace(Address addr) {
    super(addr);
  }
}
