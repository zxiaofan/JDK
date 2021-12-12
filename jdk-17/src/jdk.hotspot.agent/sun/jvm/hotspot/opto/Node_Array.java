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
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class Node_Array extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("Node_Array");
    maxField = new CIntField(type.getCIntegerField("_max"), 0);
    nodesField = type.getAddressField("_nodes");
    aField = type.getAddressField("_a");
  }

  private static CIntField maxField;
  private static AddressField nodesField;
  private static AddressField aField;

  public Node_Array(Address addr) {
    super(addr);
  }

  public int Size() {
    return (int) maxField.getValue(getAddress());
  }

  public Node at(int i) {
    return Node.create(nodesField.getValue(getAddress()).getAddressAt(i * (int)VM.getVM().getAddressSize()));
  }
}
