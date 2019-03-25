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

/** Models the "sstSegMap" subsection in Visual C++ 5.0 debug
    information. This subsection contains the mapping between the
    logical segment indices used in the symbol table and the physical
    segments where the program was loaded. There is one sstSegMap per
    executable or DLL. (Some of the descriptions are taken directly
    from Microsoft's documentation and are copyrighted by Microsoft.) */

public interface DebugVC50SSSegMap extends DebugVC50Subsection {
  /** Count of the number of segment descriptors in table. */
  public short getNumSegDesc();

  /** The total number of logical segments. All group descriptors
      follow the logical segment descriptors. The number of group
      descriptors is given by <i>cSeg - cSegLog</i>. */
  public short getNumLogicalSegDesc();

  /** Get the <i>i</i>th segment descriptor (0..getNumSegDesc() -
      1). */
  public DebugVC50SegDesc getSegDesc(int i);
}
