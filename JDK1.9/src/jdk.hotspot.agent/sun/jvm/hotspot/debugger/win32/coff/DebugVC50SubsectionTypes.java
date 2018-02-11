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

/** Type enumeration for subsections in Visual C++ 5.0 debug
    information. */

public interface DebugVC50SubsectionTypes {
  public static final short SST_MODULE        = (short) 0x120;
  public static final short SST_TYPES         = (short) 0x121;
  public static final short SST_PUBLIC        = (short) 0x122;
  public static final short SST_PUBLIC_SYM    = (short) 0x123;
  public static final short SST_SYMBOLS       = (short) 0x124;
  public static final short SST_ALIGN_SYM     = (short) 0x125;
  public static final short SST_SRC_LN_SEG    = (short) 0x126;
  public static final short SST_SRC_MODULE    = (short) 0x127;
  public static final short SST_LIBRARIES     = (short) 0x128;
  public static final short SST_GLOBAL_SYM    = (short) 0x129;
  public static final short SST_GLOBAL_PUB    = (short) 0x12a;
  public static final short SST_GLOBAL_TYPES  = (short) 0x12b;
  public static final short SST_MPC           = (short) 0x12c;
  public static final short SST_SEG_MAP       = (short) 0x12d;
  public static final short SST_SEG_NAME      = (short) 0x12e;
  public static final short SST_PRE_COMP      = (short) 0x12f;
  public static final short SST_UNUSED        = (short) 0x130;
  public static final short SST_OFFSET_MAP_16 = (short) 0x131;
  public static final short SST_OFFSET_MAP_32 = (short) 0x132;
  public static final short SST_FILE_INDEX    = (short) 0x133;
  public static final short SST_STATIC_SYM    = (short) 0x134;
}
