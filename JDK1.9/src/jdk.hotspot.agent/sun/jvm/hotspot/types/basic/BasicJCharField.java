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
    Java char value (in either a C/C++ data structure or a Java
    object) and which adds typechecked getValue() routines returning
    chars. */

public class BasicJCharField extends BasicField implements JCharField {
  public BasicJCharField(BasicTypeDataBase db, Type containingType, String name, Type type,
                         boolean isStatic, long offset, Address staticFieldAddress) {
    super(db, containingType, name, type, isStatic, offset, staticFieldAddress);

    if (!type.equals(db.getJCharType())) {
      throw new WrongTypeException("Type of a BasicJCharField must be db.getJCharType()");
    }
  }

  /** The field must be nonstatic and the type of the field must be a
      Java char, or a WrongTypeException will be thrown. */
  public char getValue(Address addr) throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getJChar(addr);
  }

  /** The field must be static and the type of the field must be a
      Java char, or a WrongTypeException will be thrown. */
  public char getValue() throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getJChar();
  }
}
