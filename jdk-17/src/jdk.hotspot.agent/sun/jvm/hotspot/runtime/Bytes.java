/*
 * Copyright (c) 2001, 2016, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.utilities.PlatformInfo;

/** Encapsulates some byte-swapping operations defined in the VM */

public class Bytes {
  private boolean swap;

  public Bytes(MachineDescription machDesc) {
    swap = !machDesc.isBigEndian();
  }

  /** Should only swap if the hardware's underlying byte order is
      different from Java's */
  public short swapShort(short x) {
    if (!swap)
      return x;

    return (short) (((x >> 8) & 0xFF) | (x << 8));
  }

  /** Should only swap if the hardware's underlying byte order is
      different from Java's */
  public int swapInt(int x) {
    if (!swap)
      return x;

    return ((int)swapShort((short) x) << 16) | (swapShort((short) (x >> 16)) & 0xFFFF);
  }

  /** Should only swap if the hardware's underlying byte order is
      different from Java's */
  public long swapLong(long x) {
    if (!swap)
      return x;

    return ((long)swapInt((int) x) << 32) | (swapInt((int) (x >> 32)) & 0xFFFFFFFF);
  }
}
