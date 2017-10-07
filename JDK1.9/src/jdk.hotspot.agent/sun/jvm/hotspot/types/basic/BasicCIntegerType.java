/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.types.basic;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;

/** <P> This specialization of BasicType implements the CIntegerType
    interface and describes all C integer types. */

public class BasicCIntegerType extends BasicType implements CIntegerType {
  private boolean isUnsigned;

  public BasicCIntegerType(BasicTypeDataBase db, String name, boolean isUnsigned) {
    super(db, name, null);

    this.isUnsigned = isUnsigned;
  }

  public boolean equals(Object obj) {
    if (!super.equals(obj)) {
      return false;
    }

    if (!(obj instanceof BasicCIntegerType)) {
      return false;
    }

    BasicCIntegerType arg = (BasicCIntegerType) obj;

    if (isUnsigned != arg.isUnsigned) {
      return false;
    }

    return true;
  }

  public String toString() {
    String prefix = null;
    if (isUnsigned) {
      prefix = "unsigned";
    }

    if (prefix != null) {
      return prefix + " " + getName();
    }

    return getName();
  }

  public boolean isCIntegerType() {
    return true;
  }

  public boolean isUnsigned() {
    return isUnsigned;
  }

  /** This should be called at most once, and only by the builder of
      the TypeDataBase */
  public void setIsUnsigned(boolean isUnsigned) {
    this.isUnsigned = isUnsigned;
  }

  public long maxValue() {
    return db.cIntegerTypeMaxValue(getSize(), isUnsigned());
  }

  public long minValue() {
    return db.cIntegerTypeMinValue(getSize(), isUnsigned());
  }
}
