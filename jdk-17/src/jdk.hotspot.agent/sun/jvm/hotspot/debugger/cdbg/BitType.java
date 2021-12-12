/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.cdbg;

public interface BitType extends IntType {
  /** Size in bits of this type */
  public int getSizeInBits();

  /** Offset from the least-significant bit (LSB) of the LSB of this
      type */
  public int getOffset();
}
