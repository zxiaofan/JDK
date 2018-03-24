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

/** Models the information stored in the optional header of a Portable
    Executable file. */

public interface OptionalHeader {
  /** Magic number for a PE32 file */
  public static final short MAGIC_PE32 = (short) 0x10B;

  /** Magic number for a PE32+ file */
  public static final short MAGIC_PE32_PLUS = (short) 0x20B;

  /** Magic number for a "ROM image" */
  public static final short MAGIC_ROM_IMAGE = (short) 0x107;

  /** Returns the magic number of the Optional Header ({@link
      #MAGIC_PE32}, {@link #MAGIC_PE32_PLUS}, or {@link
      #MAGIC_ROM_IMAGE}) */
  public short getMagicNumber();

  /** These are defined for all implementations of COFF, including
      UNIX. */
  public OptionalHeaderStandardFields getStandardFields();

  /** These include additional fields to support specific features of
      Windows (for example, subsystem). */
  public OptionalHeaderWindowsSpecificFields getWindowsSpecificFields();

  /** Gets the data directories portion of the optional header. */
  public OptionalHeaderDataDirectories getDataDirectories();
}
