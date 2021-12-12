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

// The class for a char field simply provides access to the value.
public class CharField extends Field {
  public CharField(FieldIdentifier id, long offset, boolean isVMField) {
    super(id, offset, isVMField);
  }

  public CharField(sun.jvm.hotspot.types.JCharField vmField, long startOffset) {
    super(new NamedFieldIdentifier(vmField.getName()), vmField.getOffset() + startOffset, true);
  }

  public CharField(InstanceKlass holder, int fieldArrayIndex) {
    super(holder, fieldArrayIndex);
  }

  public char getValue(Oop obj) { return obj.getHandle().getJCharAt(getOffset()); }
  public char getValue(VMObject obj) { return obj.getAddress().getJCharAt(getOffset()); }
  public void setValue(Oop obj, char value) throws MutationException {
    // Fix this: setJCharAt is missing in Address
  }
}
