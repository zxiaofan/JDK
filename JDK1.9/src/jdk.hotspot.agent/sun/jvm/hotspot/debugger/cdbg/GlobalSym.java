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

/** Models either a global variable or a module-local variable. */

public interface GlobalSym extends Sym {
  /** Name of the variable */
  public String getName();

  /** Type of the variable */
  public Type getType();

  /** Address of the variable */
  public Address getAddress();

  /** Indicates whether this symbol is module-local (i.e., static) */
  public boolean isModuleLocal();
}
