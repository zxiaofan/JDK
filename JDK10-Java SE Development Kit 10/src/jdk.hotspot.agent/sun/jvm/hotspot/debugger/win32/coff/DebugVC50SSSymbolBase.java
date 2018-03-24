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

/** Base interface for subsections containing symbols: sstGlobalSym,
    sstGlobalPub, sstStaticSym. */

public interface DebugVC50SSSymbolBase extends DebugVC50Subsection {
  /** Index of the symbol hash function */
  public short getSymHashIndex();

  /** Index of the address hash function */
  public short getAddrHashIndex();

  /** Size in bytes of the symbol table */
  public int getSymTabSize();

  /** Size in bytes of the symbol hash table */
  public int getSymHashSize();

  /** Size in bytes of the address hash table */
  public int getAddrHashSize();

  // Following this header is the symbol information, followed by the
  // symbol hash tables, followed by the address hash tables.

  /** Retrieves an iterator over the symbols, which can be used to
      parse these platform-dependent symbols into a platform-
      independent format. Returns null if there are no symbols. */
  public DebugVC50SymbolIterator getSymbolIterator();
}
