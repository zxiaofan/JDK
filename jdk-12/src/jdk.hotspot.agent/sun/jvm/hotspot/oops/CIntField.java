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

import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.debugger.*;

// The class for an C int field simply provides access to the value.
public class CIntField extends Field {

  public CIntField(sun.jvm.hotspot.types.CIntegerField vmField, long startOffset) {
    super(new NamedFieldIdentifier(vmField.getName()), vmField.getOffset() + startOffset, true);
    size       = vmField.getSize();
    isUnsigned = ((sun.jvm.hotspot.types.CIntegerType) vmField.getType()).isUnsigned();
  }

  private long size;
  private boolean isUnsigned;

  public long getValue(Oop obj) {
    return getValue(obj.getHandle());
  }
  public long getValue(VMObject obj) {
    return getValue(obj.getAddress());
  }
  public long getValue(Address addr) {
    return addr.getCIntegerAt(getOffset(), size, isUnsigned);
  }
  public void setValue(Oop obj, long value) throws MutationException {
    // Fix this: set* missing in Address
  }
}
