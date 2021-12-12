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

public class BasicRefType extends BasicType implements RefType {
  private Type targetType;

  public BasicRefType(String name, int size, Type targetType) {
    this(name, size, targetType, 0);
  }

  private BasicRefType(String name, int size, Type targetType, int cvAttributes) {
    super(name, size, cvAttributes);
    this.targetType = targetType;
    if (!((BasicType) targetType).isLazy()) {
      computeName();
    }
  }

  public RefType asRef() { return this; }

  public Type getTargetType() { return targetType; }

  Type resolveTypes(BasicCDebugInfoDataBase db, ResolveListener listener) {
    super.resolveTypes(db, listener);
    targetType = db.resolveType(this, targetType, listener, "resolving ref type");
    computeName();
    return this;
  }

  public void iterateObject(Address a, ObjectVisitor v, FieldIdentifier f) {
    v.doRef(f, a.getAddressAt(0));
  }

  protected Type createCVVariant(int cvAttributes) {
    return new BasicRefType(getName(), getSize(), getTargetType(), cvAttributes);
  }

  public void visit(TypeVisitor v) {
    v.doRefType(this);
  }

  private void computeName() {
    setName(targetType.getName() + " &");
  }
}
