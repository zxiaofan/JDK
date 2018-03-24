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

public class BasicPointerType extends BasicType implements PointerType {
  private Type targetType;

  public BasicPointerType(int size, Type targetType) {
    this(null, size, targetType, 0);
  }

  private BasicPointerType(String name, int size, Type targetType, int cvAttributes) {
    super(name, size, cvAttributes);
    this.targetType = targetType;
    if (!((BasicType) targetType).isLazy()) {
      computeName();
    }
  }

  public PointerType asPointer() { return this; }

  public Type getTargetType() { return targetType; }

  Type resolveTypes(BasicCDebugInfoDataBase db, ResolveListener listener) {
    super.resolveTypes(db, listener);
    targetType = db.resolveType(this, targetType, listener, "resolving pointer type");
    computeName();
    return this;
  }

  public void iterateObject(Address a, ObjectVisitor v, FieldIdentifier f) {
    v.doPointer(f, a.getAddressAt(0));
  }

  protected Type createCVVariant(int cvAttributes) {
    return new BasicPointerType(getName(), getSize(), getTargetType(), cvAttributes);
  }

  public void visit(TypeVisitor v) {
    v.doPointerType(this);
  }

  private void computeName() {
    setName(targetType.getName() + " *");
  }
}
