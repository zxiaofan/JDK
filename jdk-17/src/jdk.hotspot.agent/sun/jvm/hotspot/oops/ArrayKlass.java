/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

// ArrayKlass is the abstract class for all array classes

public class ArrayKlass extends Klass {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type          = db.lookupType("ArrayKlass");
    dimension          = new CIntField(type.getCIntegerField("_dimension"), 0);
    higherDimension    = new MetadataField(type.getAddressField("_higher_dimension"), 0);
    lowerDimension     = new MetadataField(type.getAddressField("_lower_dimension"), 0);
    javaLangCloneableName = null;
    javaLangObjectName = null;
    javaIoSerializableName = null;
  }

  public ArrayKlass(Address addr) {
    super(addr);
  }

  public boolean isArrayKlass()     { return true; }
  private static CIntField dimension;
  private static MetadataField  higherDimension;
  private static MetadataField  lowerDimension;

  public Klass getJavaSuper() {
    SystemDictionary sysDict = VM.getVM().getSystemDictionary();
    return sysDict.getObjectKlass();
  }

  public long  getDimension()       { return         dimension.getValue(this); }
  public Klass getHigherDimension() { return (Klass) higherDimension.getValue(this); }
  public Klass getLowerDimension()  { return (Klass) lowerDimension.getValue(this); }

  // constant class names - javaLangCloneable, javaIoSerializable, javaLangObject
  // Initialized lazily to avoid initialization ordering dependencies between ArrayKlass and String
  private static String javaLangCloneableName;
  private static String javaLangObjectName;
  private static String javaIoSerializableName;
  private static String javaLangCloneableName() {
    if (javaLangCloneableName == null) {
      javaLangCloneableName = "java/lang/Cloneable";
    }
    return javaLangCloneableName;
  }

  private static String javaLangObjectName() {
    if (javaLangObjectName == null) {
      javaLangObjectName = "java/lang/Object";
    }
    return javaLangObjectName;
  }

  private static String javaIoSerializableName() {
    if (javaIoSerializableName == null) {
      javaIoSerializableName = "java/io/Serializable";
    }
    return javaIoSerializableName;
  }

  public int getClassStatus() {
     return JVMDIClassStatus.VERIFIED | JVMDIClassStatus.PREPARED | JVMDIClassStatus.INITIALIZED;
  }

  public long computeModifierFlags() {
     return JVM_ACC_ABSTRACT | JVM_ACC_FINAL | JVM_ACC_PUBLIC;
  }

  public long getArrayHeaderInBytes() {
    return Bits.maskBits(getLayoutHelper() >> LH_HEADER_SIZE_SHIFT, 0xFF);
  }

  public int getLog2ElementSize() {
    return Bits.maskBits(getLayoutHelper() >> LH_LOG2_ELEMENT_SIZE_SHIFT, 0xFF);
  }

  public int getElementType() {
    return Bits.maskBits(getLayoutHelper() >> LH_ELEMENT_TYPE_SHIFT, 0xFF);
  }

  boolean computeSubtypeOf(Klass k) {
    // An array is a subtype of Serializable, Clonable, and Object
    Symbol name = k.getName();
    if (name != null && (name.equals(javaIoSerializableName()) ||
                         name.equals(javaLangCloneableName()) ||
                         name.equals(javaLangObjectName()))) {
      return true;
    } else {
      return false;
    }
  }

  public void printValueOn(PrintStream tty) {
    tty.print("ArrayKlass");
  }

  public void iterateFields(MetadataVisitor visitor) {
    super.iterateFields(visitor);
      visitor.doCInt(dimension, true);
    visitor.doMetadata(higherDimension, true);
    visitor.doMetadata(lowerDimension, true);
    }
  }
