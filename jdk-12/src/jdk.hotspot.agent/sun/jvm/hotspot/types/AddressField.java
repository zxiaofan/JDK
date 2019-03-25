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

package sun.jvm.hotspot.types;

import sun.jvm.hotspot.debugger.*;

/** A specialization of Field which adds Address-typed accessor
    methods. Since we currently do not understand pointer types (and
    since coercion from integer to pointer types and back is often
    done in C programs anyway) these accessors are not typechecked as,
    for example, the Java primitive type accessors are. */

public interface AddressField extends Field {
  /** This accessor requires that the field be nonstatic, or a WrongTypeException will be thrown. */
  public Address getValue(Address addr)     throws UnmappedAddressException, UnalignedAddressException, WrongTypeException;

  /** This accessor requires that the field be static, or a WrongTypeException will be thrown. */
  public Address getValue()                 throws UnmappedAddressException, UnalignedAddressException, WrongTypeException;
}
