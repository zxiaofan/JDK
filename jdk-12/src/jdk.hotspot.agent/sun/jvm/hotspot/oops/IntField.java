/*
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.VMObject;

// The class for an int field simply provides access to the value.
public class IntField extends Field {
  public IntField(FieldIdentifier id, long offset, boolean isVMField) {
    super(id, offset, isVMField);
  }

  public IntField(sun.jvm.hotspot.types.JIntField vmField, long startOffset) {
    super(new NamedFieldIdentifier(vmField.getName()), vmField.getOffset() + startOffset, true);
  }

  public IntField(InstanceKlass holder, int fieldArrayIndex) {
    super(holder, fieldArrayIndex);
  }

  public int getValue(Oop obj) {
    if (!isVMField() && !obj.isInstance() && !obj.isArray()) {
      throw new InternalError(obj.toString());
    }
    return obj.getHandle().getJIntAt(getOffset());
  }
  public int getValue(VMObject obj) {
    return obj.getAddress().getJIntAt(getOffset());
  }
  public void setValue(Oop obj, int value) throws MutationException {
    // Fix this: setJIntAt is missing in Address
  }
}
