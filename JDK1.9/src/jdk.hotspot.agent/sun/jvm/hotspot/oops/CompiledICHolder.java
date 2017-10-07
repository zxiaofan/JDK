/*
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;

public class CompiledICHolder extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type    = db.lookupType("CompiledICHolder");
    holderMethod = new MetadataField(type.getAddressField("_holder_method"), 0);
    holderKlass  = new MetadataField(type.getAddressField("_holder_klass"), 0);
    headerSize   = type.getSize();
  }

  public CompiledICHolder(Address addr) {
      super(addr);
  }

  public boolean isCompiledICHolder()  { return true; }

  private static long headerSize;

  // Fields
  private static MetadataField holderMethod;
  private static MetadataField holderKlass;

  // Accessors for declared fields
  public Method getHolderMethod() { return (Method) holderMethod.getValue(this); }
  public Klass  getHolderKlass()  { return (Klass)  holderKlass.getValue(this); }

  public void printValueOn(PrintStream tty) {
    tty.print("CompiledICHolder");
  }
  }
