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

// The class for a double field simply provides access to the value.
public class DoubleField extends Field {
  public DoubleField(FieldIdentifier id, long offset, boolean isVMField) {
    super(id, offset, isVMField);
  }

  public DoubleField(sun.jvm.hotspot.types.JDoubleField vmField, long startOffset) {
    super(new NamedFieldIdentifier(vmField.getName()), vmField.getOffset() + startOffset, true);
  }

  public DoubleField(InstanceKlass holder, int fieldArrayIndex) {
    super(holder, fieldArrayIndex);
  }

  public double getValue(Oop obj) { return obj.getHandle().getJDoubleAt(getOffset()); }
  public double getValue(VMObject obj) { return obj.getAddress().getJDoubleAt(getOffset()); }
  public void setValue(Oop obj, double value) throws MutationException {
    // Fix this: setJDoubleAt is missing in Address
  }
}
