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

/** Enumerates the COMDAT selection types. One of these is returned
    from {@link
    sun.jvm.hotspot.debugger.win32.coff.AuxSectionDefinitionsRecord#getSelection()}. */

public interface COMDATSelectionTypes {
  /** The linker issues a multiply defined symbol error if this symbol
      is already defined. */
  public static final byte IMAGE_COMDAT_SELECT_NODUPLICATES = 1;
  /** Any section defining the same COMDAT symbol may be linked; the
      rest are removed. */
  public static final byte IMAGE_COMDAT_SELECT_ANY = 2;
  /** The linker chooses an arbitrary section among the definitions
      for this symbol. A multiply defined symbol error is issued if
      all definitions don't have the same size. */
  public static final byte IMAGE_COMDAT_SELECT_SAME_SIZE = 3;
  /** The linker chooses an arbitrary section among the definitions
      for this symbol. A multiply defined symbol error is issued if
      all definitions don't match exactly. */
  public static final byte IMAGE_COMDAT_SELECT_EXACT_MATCH = 4;
  /** The section is linked if a certain other COMDAT section is
      linked. This other section is indicated by the Number field of
      the auxiliary symbol record for the section definition. Use of
      this setting is useful for definitions that have components in
      multiple sections (for example, code in one and data in
      another), but where all must be linked or discarded as a set. */
  public static final byte IMAGE_COMDAT_SELECT_ASSOCIATIVE = 5;
  /** The linker chooses the largest from the definitions for this
      symbol. If multiple definitions have this size the choice
      between them is arbitrary. */
  public static final byte IMAGE_COMDAT_SELECT_LARGEST = 6;
}
