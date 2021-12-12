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
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class Block extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("Block");
    nodesField = type.getAddressField("_nodes");
    succsField = type.getAddressField("_succs");
    numSuccsField = new CIntField(type.getCIntegerField("_num_succs"), 0);
    preOrderField = new CIntField(type.getCIntegerField("_pre_order"), 0);
    domDepthField = new CIntField(type.getCIntegerField("_dom_depth"), 0);
    idomField = type.getAddressField("_idom");
    freqField = type.getJDoubleField("_freq");
  }

  private static AddressField nodesField;
  private static AddressField succsField;
  private static CIntField numSuccsField;
  private static CIntField preOrderField;
  private static CIntField domDepthField;
  private static AddressField idomField;
  private static JDoubleField freqField;

  public Block(Address addr) {
    super(addr);
  }

  public int preOrder() {
    return (int)preOrderField.getValue(getAddress());
  }

  public double freq() {
    return (double)freqField.getValue(getAddress());
  }

  public Node_List nodes() {
    return new Node_List(getAddress().addOffsetTo(nodesField.getOffset()));
  }

  public void dump(PrintStream out) {
    out.print("B" + preOrder());
    out.print(" Freq: " + freq());
    out.println();
    Node_List nl = nodes();
    int cnt = nl.size();
    for( int i=0; i<cnt; i++ )
      nl.at(i).dump(out);
    out.print("\n");
  }
}
