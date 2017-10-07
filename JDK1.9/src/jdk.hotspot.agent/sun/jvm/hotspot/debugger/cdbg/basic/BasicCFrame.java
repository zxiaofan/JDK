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

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;

/** Basic implementation of the CFrame interface providing some of the
    functionality in a platform-independent manner. */

public abstract class BasicCFrame implements CFrame {
  private CDebugger dbg;

  protected BasicCFrame(CDebugger dbg) {
    this.dbg = dbg;
  }

  protected CDebugger dbg() {
    return dbg;
  }

  public LoadObject loadObjectForPC() {
    return dbg.loadObjectContainingPC(pc());
  }

  public BlockSym blockForPC() {
    LoadObject lo = loadObjectForPC();
    if (lo == null) {
      return null;
    }
    return lo.debugInfoForPC(pc());
  }

  public ClosestSymbol closestSymbolToPC() {
    LoadObject lo = loadObjectForPC();
    if (lo == null) {
      return null;
    }
    return lo.closestSymbolToPC(pc());
  }

  public void iterateLocals(ObjectVisitor v) {
    BlockSym block = blockForPC();
    while (block != null) {
      for (int i = 0; i < block.getNumLocals(); i++) {
        final LocalSym local = block.getLocal(i);
        Type t = local.getType();
        // t should not be null, but be robust in case of bugs in
        // debug info
        if (t != null) {
          t.iterateObject(localVariableBase().addOffsetTo(local.getFrameOffset()),
                          v,
                          new NamedFieldIdentifier() {
                              public Type getType() {
                                return local.getType();
                              }

                              public String getName() {
                                return local.getName();
                              }

                              public String toString() {
                                return getName();
                              }
                            });
        }
      }

      block = block.getParent();
    }
  }
}
