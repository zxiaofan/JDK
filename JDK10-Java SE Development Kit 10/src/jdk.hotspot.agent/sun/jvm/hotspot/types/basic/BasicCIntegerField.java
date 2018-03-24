/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

/** A specialization of BasicField adding typechecked getValue()
    routines returning ints. */

public class BasicCIntegerField extends BasicField implements CIntegerField {
  private CIntegerType intType;

  public BasicCIntegerField(BasicTypeDataBase db, Type containingType, String name, Type type,
                            boolean isStatic, long offset, Address staticFieldAddress) {
    super(db, containingType, name, type, isStatic, offset, staticFieldAddress);

    if (!(type instanceof CIntegerType)) {
      throw new WrongTypeException("Type of a BasicCIntegerField must be a CIntegerType");
    }

    intType = (CIntegerType) type;
  }

  public boolean isUnsigned() {
    return intType.isUnsigned();
  }

  /** The field must be nonstatic and of integer type, or a
      WrongTypeException will be thrown. */
  public long getValue(Address addr) throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getCInteger(addr, intType);
  }

  /** The field must be static and of integer type, or a
      WrongTypeException will be thrown. */
  public long getValue() throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getCInteger(intType);
  }
}
