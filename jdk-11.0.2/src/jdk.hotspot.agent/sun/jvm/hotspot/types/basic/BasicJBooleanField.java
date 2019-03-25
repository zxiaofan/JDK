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

/** A specialization of Field which represents a field containing a
    Java boolean value (in either a C/C++ data structure or a Java
    object) and which adds typechecked getValue() routines returning
    booleans. */

public class BasicJBooleanField extends BasicField implements JBooleanField {
  public BasicJBooleanField(BasicTypeDataBase db, Type containingType, String name, Type type,
                         boolean isStatic, long offset, Address staticFieldAddress) {
    super(db, containingType, name, type, isStatic, offset, staticFieldAddress);

    if (!type.equals(db.getJBooleanType())) {
      throw new WrongTypeException("Type of a BasicJBooleanField must be db.getJBooleanType()");
    }
  }

  /** The field must be nonstatic and the type of the field must be a
      Java boolean, or a WrongTypeException will be thrown. */
  public boolean getValue(Address addr) throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getJBoolean(addr);
  }

  /** The field must be static and the type of the field must be a
      Java boolean, or a WrongTypeException will be thrown. */
  public boolean getValue() throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getJBoolean();
  }
}
