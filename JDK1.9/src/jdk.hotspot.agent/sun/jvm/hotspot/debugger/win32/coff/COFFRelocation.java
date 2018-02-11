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

/** Describes a COFF relocation, only present in an object file. (Some
    of the descriptions are taken directly from Microsoft's
    documentation and are copyrighted by Microsoft.) */

public interface COFFRelocation {
  /** Address of the item to which relocation is applied: this is the
      offset from the beginning of the section, plus the value of the
      section's RVA/Offset field (see {@link
      sun.jvm.hotspot.debugger.win32.coff.SectionHeader}.) For example, if
      the first byte of the section has an address of 0x10, the third
      byte has an address of 0x12. */
  public int getVirtualAddress();

  /** A zero-based index into the symbol table. This symbol gives the
      address to be used for the relocation. If the specified symbol
      has section storage class, then the symbol's address is the
      address with the first section of the same name. */
  public int getSymbolTableIndex();

  /** A value indicating what kind of relocation should be
      performed. Valid relocation types depend on machine type. See
      {@link sun.jvm.hotspot.debugger.win32.coff.TypeIndicators}. */
  public short getType();
}
