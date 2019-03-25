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

public class LazyBlockSym extends BasicSym implements BlockSym {
  private Object key;

  public LazyBlockSym(Object key) {
    super(null);
    this.key = key;
  }

  public BlockSym asBlock()       { return this; }
  public boolean isLazy()         { return true; }

  public Object getKey()          { return key; }

  public BlockSym getParent()     { return null; }
  public long getLength()         { return 0; }
  public Address getAddress()     { return null; }
  public int getNumLocals()       { return 0; }
  public LocalSym getLocal(int i) { throw new RuntimeException("Should not call this"); }

  public void resolve(BasicCDebugInfoDataBase db, ResolveListener listener) {}
}
