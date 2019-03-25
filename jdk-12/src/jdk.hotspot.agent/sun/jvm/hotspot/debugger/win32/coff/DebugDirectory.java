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

/** Models the Debug Directory, which is an entry in the image
    optional header. This directory indicates where in the image the
    CodeView debug information appears, if enabled using /Z7
    /PDB:NONE. (Some of the descriptions are taken directly from
    Microsoft's documentation and are copyrighted by Microsoft.) */

public interface DebugDirectory {
  /** Number of entries in the directory */
  public int getNumEntries();

  /** Fetch the <i>i</i>th entry (0..getNumEntries() - 1) */
  public DebugDirectoryEntry getEntry(int i);
}
