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
import sun.jvm.hotspot.ci.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class Compile extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("Compile");
    rootField = type.getAddressField("_root");
    uniqueField = new CIntField(type.getCIntegerField("_unique"), 0);
    entryBciField = new CIntField(type.getCIntegerField("_entry_bci"), 0);
    topField = type.getAddressField("_top");
    cfgField = type.getAddressField("_cfg");
    regallocField = type.getAddressField("_regalloc");
    methodField = type.getAddressField("_method");
    iltField = type.getAddressField("_ilt");
  }

  private static AddressField rootField;
  private static CIntField uniqueField;
  private static CIntField entryBciField;
  private static AddressField topField;
  private static AddressField cfgField;
  private static AddressField regallocField;
  private static AddressField methodField;
  private static AddressField iltField;

  public Compile(Address addr) {
    super(addr);
  }

  public Node root() {
    return new RootNode(rootField.getValue(this.getAddress()));
  }

  public int entryBci() {
    return (int)entryBciField.getValue(getAddress());
  }

  public ciMethod method() {
    return (ciMethod) ciObjectFactory.getMetadata(methodField.getValue(getAddress()));
  }

  public PhaseCFG cfg() {
    Address a = cfgField.getValue(this.getAddress());
    if (a != null) {
      return new PhaseCFG(a);
    }
    return null;
  }

  public InlineTree ilt() {
    Address a = iltField.getValue(this.getAddress());
    if (a != null) {
      return new InlineTree(a);
    }
    return null;
  }

  public void dumpInlineData(PrintStream out) {
    InlineTree inlTree = ilt();
    if (inlTree != null) {
      out.print(" inline " + inlTree.count());
      inlTree.dumpReplayData(out);
    }
  }

}
