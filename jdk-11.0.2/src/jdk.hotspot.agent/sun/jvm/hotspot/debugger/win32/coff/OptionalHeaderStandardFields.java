/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

/** Models the information stored in the standard fields portion of
    the optional header of a Portable Executable file. (Some of the
    descriptions are taken directly from Microsoft's documentation and
    are copyrighted by Microsoft.) */

public interface OptionalHeaderStandardFields {
  public byte getMajorLinkerVersion();
  public byte getMinorLinkerVersion();

  /** Size of the code (text) section, or the sum of all code sections
      if there are multiple sections. */
  public int getSizeOfCode();

  /** Size of the initialized data section, or the sum of all such
      sections if there are multiple data sections. */
  public int getSizeOfInitializedData();

  /** Size of the uninitialized data section (BSS), or the sum of all
      such sections if there are multiple BSS sections. */
  public int getSizeOfUninitializedData();

  /** Address of entry point, relative to image base, when executable
      file is loaded into memory. For program images, this is the
      starting address. For device drivers, this is the address of the
      initialization function. An entry point is optional for DLLs.
      When none is present this field should be 0. */
  public int getAddressOfEntryPoint();

  /** Address, relative to image base, of beginning of code section,
      when loaded into memory. */
  public int getBaseOfCode();

  /** Onle present in PE32 files; absent in PE32+ files. Address,
      relative to image base, of beginning of data section, when
      loaded into memory. */
  public int getBaseOfData() throws COFFException;
}
