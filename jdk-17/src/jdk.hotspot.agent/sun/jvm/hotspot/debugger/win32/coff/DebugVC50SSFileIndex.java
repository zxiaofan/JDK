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

/** Models the "sstFileIndex" subsection in Visual C++ 5.0 debug
    information. This subsection contains a list of all of the source
    files that contribute code to any module (compiland) in the
    executable. File names are partially qualified relative to the
    compilation directory. */
public interface DebugVC50SSFileIndex extends DebugVC50Subsection {
  /** Number of file name references per module. */
  public short getNumModules();

  /** Count of the total number of file name references. */
  public short getNumReferences();

  /** Array of indices into the <i>NameOffset</i> table for each
      module. Each index is the start of the file name references for
      each module. */
  public short[] getModStart();

  /** Number of file name references per module. */
  public short[] getRefCount();

  /** Array of offsets into the Names table. For each module, the
      offset to first referenced file name is at NameRef[ModStart] and
      continues for cRefCnt entries. FIXME: this probably is useless
      and needs fixup to convert these offsets into indices into the
      following array. */
  public int[] getNameRef();

  /** List of zero terminated file names. Each file name is partially
      qualified relative to the compilation directory. */
  public String[] getNames();
}
