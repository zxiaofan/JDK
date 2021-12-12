/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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
 */
package sun.jvm.hotspot.code;

import java.util.*;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public abstract class CompiledMethod extends CodeBlob {
  private static AddressField  methodField;
  private static AddressField  deoptHandlerBeginField;
  private static AddressField  deoptMhHandlerBeginField;
  private static AddressField  scopesDataBeginField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static void initialize(TypeDataBase db) {
    Type type = db.lookupType("CompiledMethod");

    methodField                 = type.getAddressField("_method");
    deoptHandlerBeginField      = type.getAddressField("_deopt_handler_begin");
    deoptMhHandlerBeginField    = type.getAddressField("_deopt_mh_handler_begin");
    scopesDataBeginField        = type.getAddressField("_scopes_data_begin");
  }

  public CompiledMethod(Address addr) {
    super(addr);
  }

  public Method getMethod() {
    return (Method)Metadata.instantiateWrapperFor(methodField.getValue(addr));
  }

  public Address deoptHandlerBegin()    { return deoptHandlerBeginField.getValue(addr);              }
  public Address deoptMhHandlerBegin()  { return deoptMhHandlerBeginField.getValue(addr);            }
  public Address scopesDataBegin()      { return scopesDataBeginField.getValue(addr);                }

  public static int getMethodOffset()                { return (int) methodField.getOffset();                }

  @Override
  public boolean isCompiled() {
    return true;
  }
}
