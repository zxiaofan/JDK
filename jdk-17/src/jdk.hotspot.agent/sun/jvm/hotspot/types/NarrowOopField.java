/*
 * Copyright (c) 2008, Oracle and/or its affiliates. All rights reserved.
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

/** A specialization of Field which represents a field containing an
    narrow oop value and which adds typechecked getValue() routines returning
    OopHandles. */

public interface NarrowOopField extends OopField {
  /** The field must be nonstatic and the type of the field must be an
      oop type, or a WrongTypeException will be thrown. */
  public OopHandle getValue(Address addr)     throws UnmappedAddressException, UnalignedAddressException, WrongTypeException;

  /** The field must be static and the type of the field must be an
      oop type, or a WrongTypeException will be thrown. */
  public OopHandle getValue()                 throws UnmappedAddressException, UnalignedAddressException, WrongTypeException;
}
