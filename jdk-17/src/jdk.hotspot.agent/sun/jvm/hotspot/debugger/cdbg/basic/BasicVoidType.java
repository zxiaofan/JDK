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

public class BasicVoidType extends BasicType implements VoidType {
  public BasicVoidType() {
    super("void", 0);
  }

  public VoidType asVoid() { return this; }

  public void iterateObject(Address a, ObjectVisitor v, FieldIdentifier f) {}

  protected Type createCVVariant(int cvAttributes) {
    // FIXME
    System.err.println("WARNING: Should not attempt to create const/volatile variants for void type");
    return this;
    //    throw new RuntimeException("Should not attempt to create const/volatile variants for void type");
  }

  public void visit(TypeVisitor v) {
    v.doVoidType(this);
  }
}
