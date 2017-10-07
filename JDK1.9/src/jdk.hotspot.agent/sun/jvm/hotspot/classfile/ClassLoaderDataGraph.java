/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

  public static interface KlassVisitor {
    public void visit(Klass k);
  }

  /** Iterate over all anonymous class loaders and the klasses in those */
  public void allAnonymousKlassesDo(final KlassVisitor v) {
    for (ClassLoaderData cl = getClassLoaderGraphHead();
         cl != null;
         cl = cl.next()) {
      if (cl.getIsAnonymous() == true) {
        for (Klass k = cl.getKlasses(); k != null; k = k.getNextLinkKlass()) {
          v.visit(k);
        }
      }
    }
  }

}
