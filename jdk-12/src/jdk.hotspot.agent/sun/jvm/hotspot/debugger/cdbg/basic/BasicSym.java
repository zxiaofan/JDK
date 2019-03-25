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

package sun.jvm.hotspot.debugger.cdbg.basic;

import sun.jvm.hotspot.debugger.cdbg.*;

public abstract class BasicSym implements Sym {
  private String name;

  protected BasicSym(String name) {
    this.name = name;
  }

  public String      getName()    { return name; }
  public String      toString()   { return getName(); }

  public BlockSym    asBlock()    { return null; }
  public FunctionSym asFunction() { return null; }
  public GlobalSym   asGlobal()   { return null; }
  public LocalSym    asLocal()    { return null; }

  public boolean     isBlock()    { return (asBlock()    != null); }
  public boolean     isFunction() { return (asFunction() != null); }
  public boolean     isGlobal()   { return (asGlobal()   != null); }
  public boolean     isLocal()    { return (asLocal()    != null); }

  public boolean     isLazy()     { return false; }

  /** Resolve type and symbol references in this symbol */
  public abstract void resolve(BasicCDebugInfoDataBase db, ResolveListener listener);
}
