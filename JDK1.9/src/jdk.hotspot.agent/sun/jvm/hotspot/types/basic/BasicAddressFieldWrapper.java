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

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;

/** A wrapper for a Field which adds getValue() methods returning
    Addresses. Must be a wrapper since the concrete type of the Field
    implementation will not be, for example, a BasicAddressField
    because, for simplicity, we don't currently understand pointer
    types in the Type system. */

public class BasicAddressFieldWrapper extends BasicFieldWrapper implements AddressField {
  public BasicAddressFieldWrapper(Field field) {
    super(field);
  }

  public Address getValue(Address addr)
    throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return field.getAddress(addr);
  }

  public Address getValue()
    throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return field.getAddress();
  }
}
