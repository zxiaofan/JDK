/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.classfile;

import java.io.PrintStream;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;

public class ClassLoaderData extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("ClassLoaderData");
    classLoaderField = type.getOopField("_class_loader");
    nextField = type.getAddressField("_next");
    klassesField = type.getAddressField("_klasses");
    isAnonymousField = new CIntField(type.getCIntegerField("_is_anonymous"), 0);
  }

  private static sun.jvm.hotspot.types.OopField classLoaderField;
  private static AddressField nextField;
  private static AddressField klassesField;
  private static CIntField isAnonymousField;

  public ClassLoaderData(Address addr) {
    super(addr);
  }

  public static ClassLoaderData instantiateWrapperFor(Address addr) {
    if (addr == null) {
      return null;
    }
    return new ClassLoaderData(addr);
  }

  public Oop getClassLoader() {
    return VM.getVM().getObjectHeap().newOop(classLoaderField.getValue(getAddress()));
  }

  public boolean getIsAnonymous() {
    return isAnonymousField.getValue(this) != 0;
  }

  public ClassLoaderData next() {
    return instantiateWrapperFor(nextField.getValue(getAddress()));
  }

  public Klass getKlasses() {
    return (InstanceKlass)Metadata.instantiateWrapperFor(klassesField.getValue(getAddress()));
  }
}
