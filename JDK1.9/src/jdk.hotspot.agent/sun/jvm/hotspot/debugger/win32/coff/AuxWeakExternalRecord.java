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

/** Describes an Auxiliary Weak External record, which follows a
    weak-external symbol record. (Some of the descriptions are taken
    directly from Microsoft's documentation and are copyrighted by
    Microsoft.)  */

public interface AuxWeakExternalRecord extends AuxSymbolRecord {
  public static final int IMAGE_WEAK_EXTERN_SEARCH_NOLIBRARY = 1;
  public static final int IMAGE_WEAK_EXTERN_SEARCH_LIBRARY   = 2;
  public static final int IMAGE_WEAK_EXTERN_SEARCH_ALIAS     = 3;

  /** Symbol-table index of sym2, the symbol to be linked if sym1 is
      not found. */
  public int getTagIndex();

  /** <P> A value of {@link #IMAGE_WEAK_EXTERN_SEARCH_NOLIBRARY}
      indicates that no library search for sym1 should be
      performed. </P>

      <P> A value of {@link #IMAGE_WEAK_EXTERN_SEARCH_LIBRARY}
      indicates that a library search for sym1 should be
      performed. </P>

      <P> A value of {@link #IMAGE_WEAK_EXTERN_SEARCH_ALIAS} indicates
      that sym1 is an alias for sym2. </P> */
  public int getCharacteristics();
}
