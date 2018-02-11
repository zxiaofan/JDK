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
    Java int value (in either a C/C++ data structure or a Java
    object) and which adds typechecked getValue() routines returning
    ints. */

public class BasicJIntField extends BasicField implements JIntField {
  public BasicJIntField(BasicTypeDataBase db, Type containingType, String name, Type type,
                          boolean isStatic, long offset, Address staticFieldAddress) {
    super(db, containingType, name, type, isStatic, offset, staticFieldAddress);

    if (!type.equals(db.getJIntType())) {
      throw new WrongTypeException("Type of a BasicJIntField must be equal to TypeDataBase.getJIntType()");
    }
  }

  /** The field must be nonstatic and the type of the field must be a
      Java int, or a WrongTypeException will be thrown. */
  public int getValue(Address addr) throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getJInt(addr);
  }

  /** The field must be static and the type of the field must be a
      Java int, or a WrongTypeException will be thrown. */
  public int getValue() throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getJInt();
  }
}
