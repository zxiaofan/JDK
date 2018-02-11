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

/** Models the SegInfo data structure in the Module subsection in
    Visual C++ 5.0 debug information. (Some of the descriptions are
    taken directly from Microsoft's documentation and are copyrighted
    by Microsoft.) */

public interface DebugVC50SegInfo {
  /** Segment that this structure describes */
  public short getSegment();

  /** Offset in segment where the code starts */
  public int getOffset();

  /** Count of the number of bytes of code in the segment */
  public int getSegmentCodeSize();
}
