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

/** Describes an Auxiliary Function Definition record, which follows a
    function definition symbol record. (Some of the descriptions are
    taken directly from Microsoft's documentation and are copyrighted
    by Microsoft.)  */

public interface AuxFunctionDefinitionRecord extends AuxSymbolRecord {
  /** Symbol-table index of the corresponding .bf (begin function)
      symbol record. */
  public int getTagIndex();

  /** Size of the executable code for the function itself. If the
      function is in its own section, the Size of Raw Data in the
      section header will be greater or equal to this field, depending
      on alignment considerations. */
  public int getTotalSize();

  /** Index of the first COFF line-number entry for the function in
      the global array of line numbers (see {@link
      sun.jvm.hotspot.debugger.win32.coff.SectionHeader#getCOFFLineNumber}),
      or -1 if none exists. */
  public int getPointerToLineNumber();

  /** Symbol-table index of the record for the next function. If the
      function is the last in the symbol table, this field is set to
      zero. */
  public int getPointerToNextFunction();
}
