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

package sun.jvm.hotspot.debugger.win32.coff;

/** Bit field definitions used in {@link
    sun.jvm.hotspot.debugger.win32.coff.DebugVC50SegDesc}. */

public interface DebugVC50SegDescEnums {
  // FIXME: verify these are correct

  /** If set, the descriptor represents a group. Since groups are not
      assigned logical segment numbers, these entries are placed after
      the logcial segment descriptors in the descriptor array. */
  public static final short SEGMAP_GROUP_MASK = (short) 0x1000;

  /** <i>frame</i> represents an absolute address. */
  public static final short SEGMAP_ABS_MASK = (short) 0x0200;

  /** <i>frame</i> represents a selector. */
  public static final short SEGMAP_SEL_MASK = (short) 0x0100;

  /** The descriptor describes a 32-bit linear address. */
  public static final short SEGMAP_32BIT_MASK = (short) 0x0008;

  /** The segment is executable. */
  public static final short SEGMAP_EXECUTABLE_MASK = (short) 0x0004;

  /** The segment is writable. */
  public static final short SEGMAP_WRITABLE_MASK = (short) 0x0002;

  /** The segment is readable. */
  public static final short SEGMAP_READABLE_MASK = (short) 0x0001;
}
