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
 *
 */

package sun.jvm.hotspot.classfile;

import java.io.PrintStream;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.classfile.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ClassLoaderDataGraph {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type = db.lookupType("ClassLoaderDataGraph");

    headField = type.getAddressField("_head");
  }

  private static AddressField headField;

  public ClassLoaderData getClassLoaderGraphHead() {
    return ClassLoaderData.instantiateWrapperFor(headField.getValue());
  }

  /** Lookup an already loaded class in any class loader. */
  public Klass find(String className) {
    for (ClassLoaderData cld = getClassLoaderGraphHead(); cld != null; cld = cld.next()) {
        Klass k = cld.find(className);
        if (k != null) {
            return k;
        }
    }
    return null;
  }

  /** Interface for iterating through all classes. */
  public static interface ClassVisitor {
    public void visit(Klass k);
  }

  /** Interface for iterating through all classes and their class
      loaders in dictionary */
  public static interface ClassAndLoaderVisitor {
    public void visit(Klass k, Oop loader);
  }

  /** Iterate over all klasses - including object, primitive
      array klasses */
  public void classesDo(ClassVisitor v) {
    for (ClassLoaderData cld = getClassLoaderGraphHead(); cld != null; cld = cld.next()) {
        cld.classesDo(v);
    }
  }

  /** Iterate over all klasses - including object, primitive
      array klasses, pass initiating loader. */
  public void allEntriesDo(ClassAndLoaderVisitor v) {
    for (ClassLoaderData cld = getClassLoaderGraphHead(); cld != null; cld = cld.next()) {
        cld.allEntriesDo(v);
    }
  }
}
