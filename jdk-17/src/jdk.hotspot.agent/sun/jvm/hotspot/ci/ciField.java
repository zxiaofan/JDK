/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.ci;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ciField extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("ciField");
    constantValueField = type.getAddressField("_constant_value");
    isConstantField = type.getAddressField("_is_constant");
    offsetField = new CIntField(type.getCIntegerField("_offset"), 0);
    signatureField = type.getAddressField("_signature");
    nameField = type.getAddressField("_name");
    holderField = type.getAddressField("_holder");
  }

  private static AddressField constantValueField;
  private static AddressField isConstantField;
  private static CIntField offsetField;
  private static AddressField signatureField;
  private static AddressField nameField;
  private static AddressField holderField;

  public ciField(Address addr) {
    super(addr);
  }
}
