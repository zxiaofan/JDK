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

/** Describes an Auxiliary .bf/.ef Record, which follows a .bf or .ef
    symbol. (Some of the descriptions are taken directly from
    Microsoft's documentation and are copyrighted by Microsoft.)  */

public interface AuxBfEfRecord extends AuxSymbolRecord {
  /** Actual ordinal line number (1, 2, 3, etc.) within source file,
      corresponding to the .bf or .ef record. */
  public short getLineNumber();

  /** Symbol-table index of the next .bf symbol record. If the
      function is the last in the symbol table, this field is set to
      zero. Not used for .ef records. */
  public int getPointerToNextFunction();
}
