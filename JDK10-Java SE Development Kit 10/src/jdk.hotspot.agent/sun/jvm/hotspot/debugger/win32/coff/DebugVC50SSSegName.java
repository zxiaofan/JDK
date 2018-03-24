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

/** Models the "sstSegName" subsection in Visual C++ 5.0 debug
    information. This subsection contains all of the logical segment
    and class names. The table is an array of zero-terminated strings.
    Each string is indexed by its beginning from the start of the
    table. See {@link
    sun.jvm.hotspot.debugger.win32.coff.DebugVC50SSSegMap}. (Some of
    the descriptions are taken directly from Microsoft's documentation
    and are copyrighted by Microsoft.) */

public interface DebugVC50SSSegName extends DebugVC50Subsection {
  /** Indexed by (0..DebugVC50SSSegMap.getNumSegDesc() - 1) */
  public String getSegName(int i);
}
