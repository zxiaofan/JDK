/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;

public class BasicBlockSym extends BasicSym implements BlockSym {
  private BlockSym parent;
  private long     length;
  private Address  addr;

  private List<LocalSym> locals;

  /** Creates a new BlockSym. Parent can be null. */
  public BasicBlockSym(BlockSym parent, long length, Address addr, String name) {
    super(name);
    this.parent = parent;
    this.length = length;
    this.addr   = addr;
  }

  public BlockSym asBlock()   { return this; }

  public BlockSym getParent() { return parent; }
  public long getLength()     { return length; }
  public Address getAddress() { return addr; }

  public int getNumLocals() {
    if (locals == null) {
      return 0;
    }

    return locals.size();
  }

  public LocalSym getLocal(int i) {
    return (LocalSym) locals.get(i);
  }

  public void addLocal(LocalSym local) {
    if (locals == null) {
      locals = new ArrayList<>();
    }
    locals.add(local);
  }

  public void resolve(BasicCDebugInfoDataBase db, ResolveListener listener) {
    parent = (BlockSym) db.resolveSym(this, parent, listener, "resolving parent of block");
    if (locals != null) {
      for (Iterator iter = locals.iterator(); iter.hasNext(); ) {
        ((BasicLocalSym) iter.next()).resolve(db, listener);
      }
    }
  }
}
