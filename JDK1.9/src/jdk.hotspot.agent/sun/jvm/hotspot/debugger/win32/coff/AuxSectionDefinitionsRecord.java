/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

/** Describes an Auxiliary Section Definitions record, which follows a
    symbol that defines a section. Such a symbol has a name that is
    the name of a section (such as <B>.text</B> or <B>drectve</B> and
    has storage class STATIC. The auxiliary record provides
    information on the section referred to. Thus it duplicates some of
    the information in the section header. (Some of the descriptions
    are taken directly from Microsoft's documentation and are
    copyrighted by Microsoft.)  */

public interface AuxSectionDefinitionsRecord extends AuxSymbolRecord {
  /** Size of section data; same as Size of Raw Data in the section
      header. */
  public int getLength();

  /** Number of relocation entries for the section. */
  public short getNumberOfRelocations();

  /** Number of line-number entries for the section. */
  public short getNumberOfLineNumbers();

  /** Checksum for communal data. Applicable if the
      IMAGE_SCN_LNK_COMDAT flag is set in the section header. */
  public int getCheckSum();

  /** One-based index into the Section Table for the associated
      section; used when the COMDAT Selection setting is 5. */
  public short getNumber();

  /** COMDAT selection number. Applicable if the section is a COMDAT
      section. See {@link
      sun.jvm.hotspot.debugger.win32.coff.COMDATSelectionTypes}. */
  public byte getSelection();
}
