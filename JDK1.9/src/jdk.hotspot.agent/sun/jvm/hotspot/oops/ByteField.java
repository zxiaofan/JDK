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

// The class for a byte field simply provides access to the value.
public class ByteField extends Field {
  public ByteField(FieldIdentifier id, long offset, boolean isVMField) {
    super(id, offset, isVMField);
  }

  public ByteField(sun.jvm.hotspot.types.JByteField vmField, long startOffset) {
    super(new NamedFieldIdentifier(vmField.getName()), vmField.getOffset() + startOffset, true);
  }

  public ByteField(InstanceKlass holder, int fieldArrayIndex) {
    super(holder, fieldArrayIndex);
  }

  public byte getValue(Oop obj) { return obj.getHandle().getJByteAt(getOffset()); }
  public byte getValue(VMObject obj) { return obj.getAddress().getJByteAt(getOffset()); }
  public void setValue(Oop obj, char value) throws MutationException {
    // Fix this: setJCharAt is missing in Address
  }
}
