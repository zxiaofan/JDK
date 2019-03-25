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

package sun.jvm.hotspot.debugger.cdbg;

import sun.jvm.hotspot.debugger.*;

/** A BlockSym models a lexical scope in a block-structured
    language. It is (currently) the bottommost scope type. */

public interface BlockSym extends Sym {
  /** Get the lexically enclosing block, or null if none */
  public BlockSym getParent();

  /** Length in bytes of the machine code in this block */
  public long getLength();

  /** Address of the first machine instruction in this block */
  public Address getAddress();

  /** Name of this block, or null if none */
  public String getName();

  /** Number of local variable symbols associated with this block */
  public int getNumLocals();

  /** Return <i>i</i>th local (0..getNumLocals() - 1) */
  public LocalSym getLocal(int i);
}
