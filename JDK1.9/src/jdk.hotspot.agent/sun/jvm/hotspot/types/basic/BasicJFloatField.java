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
    Java float value (in either a C/C++ data structure or a Java
    object) and which adds typechecked getValue() routines returning
    floats. */

public class BasicJFloatField extends BasicField implements JFloatField {
  public BasicJFloatField(BasicTypeDataBase db, Type containingType, String name, Type type,
                          boolean isStatic, long offset, Address staticFieldAddress) {
    super(db, containingType, name, type, isStatic, offset, staticFieldAddress);

    if (!type.equals(db.getJFloatType())) {
      throw new WrongTypeException("Type of a BasicJFloatField must be equal to TypeDataBase.getJFloatType()");
    }
  }

  /** The field must be nonstatic and the type of the field must be a
      Java float, or a WrongTypeException will be thrown. */
  public float getValue(Address addr) throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getJFloat(addr);
  }

  /** The field must be static and the type of the field must be a
      Java float, or a WrongTypeException will be thrown. */
  public float getValue() throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getJFloat();
  }
}
