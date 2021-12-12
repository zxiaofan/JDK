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

package sun.jvm.hotspot.opto;

import java.util.*;
import java.io.PrintStream;
import sun.jvm.hotspot.ci.ciMethod;
import sun.jvm.hotspot.ci.ciObjectFactory;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class MachCallJavaNode extends MachCallNode {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("MachCallJavaNode");
    methodField = type.getAddressField("_method");
    bciField = new CIntField(type.getCIntegerField("_bci"), 0);
  }

  private static AddressField methodField;
  private static CIntField bciField;

  public ciMethod method() {
    return (ciMethod) ciObjectFactory.getMetadata(methodField.getValue(getAddress()));
  }

  public MachCallJavaNode(Address addr) {
    super(addr);
  }

  public void dumpSpec(PrintStream st) {
    ciMethod m = method();
    if (m != null) {
      m.printShortName(st);
      st.print(" ");
    }
    super.dumpSpec(st);
  }
}
