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

import java.io.PrintStream;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ciKlass extends ciType {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("ciKlass");
    nameField = type.getAddressField("_name");
  }

  private static AddressField nameField;

  public String name() {
    ciSymbol sym = new ciSymbol(nameField.getValue(getAddress()));
    return sym.asUtf88();
  }

  public ciKlass(Address addr) {
    super(addr);
  }

  public void printValueOn(PrintStream tty) {
    Klass k = (Klass)getMetadata();
    k.printValueOn(tty);
  }
}
