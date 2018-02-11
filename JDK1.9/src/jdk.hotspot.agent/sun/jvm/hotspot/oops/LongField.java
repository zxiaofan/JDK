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

// The class for a long field simply provides access to the value.
public class LongField extends Field {
  public LongField(FieldIdentifier id, long offset, boolean isVMField) {
    super(id, offset, isVMField);
  }

  public LongField(sun.jvm.hotspot.types.JLongField vmField, long startOffset) {
    super(new NamedFieldIdentifier(vmField.getName()), vmField.getOffset() + startOffset, true);
  }

  public LongField(InstanceKlass holder, int fieldArrayIndex) {
    super(holder, fieldArrayIndex);
  }

  public long getValue(Oop obj) { return obj.getHandle().getJLongAt(getOffset()); }
  public long getValue(VMObject obj) { return obj.getAddress().getJLongAt(getOffset()); }
  public void setValue(Oop obj, long value) {
    // Fix this: setJLongAt is missing in Address
  }
}
