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
import sun.jvm.hotspot.utilities.Assert;

public class LazyType extends BasicType {
  private Object key;
  private int    cvAttributes;

  public LazyType(Object key) {
    this(key, 0);
  }

  private LazyType(Object key, int cvAttributes) {
    super(null, 0, cvAttributes);
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(key != null, "key must not be null");
    }
    this.key = key;
    this.cvAttributes = cvAttributes;
  }

  public boolean isLazy() { return true; }
  public Object getKey()  { return key; }

  Type resolveTypes(BasicCDebugInfoDataBase db, ResolveListener listener) {
    BasicType t = (BasicType) db.resolveType(this, this, listener, "resolving lazy type");
    // Returned type might be lazy if there was an error
    if (t.isLazy()) {
      return this;
    }
    if (cvAttributes != 0) {
      return t.getCVVariant(cvAttributes);
    }
    return t;
  }

  public void iterateObject(Address a, ObjectVisitor v, FieldIdentifier f) {}
  protected Type createCVVariant(int cvAttributes) {
    return new LazyType(key, cvAttributes);
  }

  public void visit(TypeVisitor v) {}
}
