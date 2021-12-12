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

package sun.jvm.hotspot.compiler;

import java.io.PrintStream;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.opto.*;
import sun.jvm.hotspot.prims.JvmtiExport;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class CompileTask extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("CompileTask");
    methodField = type.getAddressField("_method");
    osrBciField = new CIntField(type.getCIntegerField("_osr_bci"), 0);
    compLevelField = new CIntField(type.getCIntegerField("_comp_level"), 0);
  }

  private static AddressField methodField;
  private static CIntField osrBciField;
  private static CIntField compLevelField;

  public CompileTask(Address addr) {
    super(addr);
  }

  public Method method() {
    Address oh =  methodField.getValue(getAddress());
    return (Method)Metadata.instantiateWrapperFor(oh);
  }

  public int osrBci() {
    return (int)osrBciField.getValue(getAddress());
  }

  public int compLevel() {
      return (int)compLevelField.getValue(getAddress());
  }
}
