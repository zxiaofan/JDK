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

/** Describes a COFF line number. (Some of the descriptions are taken
    directly from Microsoft's documentation and are copyrighted by
    Microsoft.) */

public interface COFFLineNumber {
  /** <P> Union of two fields: Symbol Table Index and RVA. Whether
      Symbol Table Index or RVA is used depends on the value of
      getLineNumber(). </P>

      <P> SymbolTableIndex is used when getLineNumber() is 0: index to
      symbol table entry for a function. This format is used to
      indicate the function that a group of line-number records refer
      to. </P>

      <P> VirtualAddress is used when LineNumber is non-zero: relative
      virtual address of the executable code that corresponds to the
      source line indicated. In an object file, this contains the
      virtual address within the section. </P> */
  public int getType();

  /** When nonzero, this field specifies a one-based line number. When
      zero, the Type field is interpreted as a Symbol Table Index for
      a function. */
  public short getLineNumber();
}
