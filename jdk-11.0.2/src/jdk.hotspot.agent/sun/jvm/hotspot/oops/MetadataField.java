/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

public class MetadataField extends Field {

  public MetadataField(sun.jvm.hotspot.types.AddressField vmField, long startOffset) {
    super(new NamedFieldIdentifier(vmField.getName()), vmField.getOffset() + startOffset, true);
  }

  public Metadata getValue(Oop obj) {
    return getValue(obj.getHandle());
  }
  public Metadata getValue(VMObject obj) {
    return getValue(obj.getAddress());
  }
  public Metadata getValue(Address addr) {
    return Metadata.instantiateWrapperFor(addr.getAddressAt(getOffset()));
  }
  public void setValue(Oop obj, long value) throws MutationException {
    // Fix this: set* missing in Address
  }
}
