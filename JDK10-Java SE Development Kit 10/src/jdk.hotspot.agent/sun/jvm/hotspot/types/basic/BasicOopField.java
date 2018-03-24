/*
 * Copyright (c) 2000, 2008, Oracle and/or its affiliates. All rights reserved.
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

/** A specialization of BasicField which represents a field containing
    an oop value and which adds typechecked getValue() routines
    returning OopHandles. */

public class BasicOopField extends BasicField implements OopField {


  public BasicOopField(OopField oopf) {
    super(oopf);
  }

  public BasicOopField(BasicTypeDataBase db, Type containingType, String name, Type type,
                       boolean isStatic, long offset, Address staticFieldAddress) {
    super(db, containingType, name, type, isStatic, offset, staticFieldAddress);

    if (!type.isOopType()) {
      throw new WrongTypeException("Type of a BasicOopField must be an oop type");
    }
  }

  /** The field must be nonstatic and the type of the field must be a
      Java oop, or a WrongTypeException will be thrown. */
  public OopHandle getValue(Address addr) throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getOopHandle(addr);
  }

  /** The field must be static and the type of the field must be a
      Java oop, or a WrongTypeException will be thrown. */
  public OopHandle getValue() throws UnmappedAddressException, UnalignedAddressException, WrongTypeException {
    return getOopHandle();
  }
}
