/*
 * Copyright (c) 2001, 2021, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;

public class BasicFunctionSym extends BasicBlockSym implements FunctionSym {
  private Type         type;
  private boolean      isModuleLocal;

  public BasicFunctionSym(BlockSym parent, long length, Address addr, String name,
                          Type type, boolean isModuleLocal) {
    super(parent, length, addr, name);
    this.type          = type;
    this.isModuleLocal = isModuleLocal;
  }

  public FunctionSym  asFunction()    { return this; }

  public Type         getType()       { return type; }
  public boolean      isModuleLocal() { return isModuleLocal; }

  public void resolve(BasicCDebugInfoDataBase db, ResolveListener listener) {
    super.resolve(db, listener);
    type = db.resolveType(this, type, listener, "resolving type of function symbol");
  }

  public String toString() {
    if (getName() == null) {
      return null;
    }

    StringBuilder res = new StringBuilder();
    res.append(getName());
    res.append("(");
    FunctionType type = (FunctionType) getType();
    if (type != null) {
      int nargs = type.getNumArguments();
      for (int i = 0; i < nargs; i++) {
        res.append(type.getArgumentType(i).toString());
        if (i != nargs - 1) {
          res.append(", ");
        }
      }
    }
    res.append(")");
    return res.toString();
  }
}
