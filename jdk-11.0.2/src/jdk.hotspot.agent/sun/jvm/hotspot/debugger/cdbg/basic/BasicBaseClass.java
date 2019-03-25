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

public class BasicBaseClass implements BaseClass {
  private int     accessControl;
  private boolean isVirtual;
  private Type    type;

  public BasicBaseClass(int accessControl, boolean isVirtual, Type type) {
    this.accessControl = accessControl;
    this.isVirtual     = isVirtual;
    this.type          = type;
  }

  public int     getAccessControl() { return accessControl; }
  public boolean isVirtual()        { return isVirtual; }
  public Type    getType()          { return type; }

  public void resolveTypes(Type containingType, BasicCDebugInfoDataBase db, ResolveListener listener) {
    type = db.resolveType(containingType, type, listener, "resolving base class");
  }
}
