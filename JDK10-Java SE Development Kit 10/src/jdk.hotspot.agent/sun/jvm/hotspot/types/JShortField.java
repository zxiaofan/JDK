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

/** A specialization of Field which represents a field containing a
    Java short value (in either a C/C++ data structure or a Java
    object) and which adds typechecked getValue() routines returning
    shorts. */

public interface JShortField extends Field {
  /** The field must be nonstatic and the type of the field must be a
      Java short, or a WrongTypeException will be thrown. */
  public short getValue(Address addr) throws UnmappedAddressException, UnalignedAddressException, WrongTypeException;

  /** The field must be static and the type of the field must be a
      Java short, or a WrongTypeException will be thrown. */
  public short getValue() throws UnmappedAddressException, UnalignedAddressException, WrongTypeException;
}
