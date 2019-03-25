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

/** Describes code segments that receive code from a given source
    file. See {@link
    sun.jvm.hotspot.debugger.win32.coff.DebugVC50SSSrcModule}. */

public interface DebugVC50SrcModFileDesc {
  /** The number of code segments receiving code from this module. */
  public int getNumCodeSegments();

  /** Get the <i>i</i>th (0..getNumCodeSegments() - 1) line
      number/address map for the given segment. */
  public DebugVC50SrcModLineNumberMap getLineNumberMap(int i);

  /** Get <i>i</i>th (0..getNumCodeSegments() - 1) start offset,
      within a segment, of code contributed to that segment. If this
      and the end offset are both 0, the start/end offsets are not
      known and the file and line tables must be examined to find
      information about the program counter of interest. */
  public int getSegmentStartOffset(int i);

  /** Get <i>i</i>th (0..getNumCodeSegments() - 1) end offset, within
      a segment, of code contributed to that segment. If this and the
      start offset are both 0, the start/end offsets are not known and
      the file and line tables must be examined to find information
      about the program counter of interest. */
  public int getSegmentEndOffset(int i);

  /** Source file name. This can be a fully or partially qualified
      path name. */
  public String getSourceFileName();
}
