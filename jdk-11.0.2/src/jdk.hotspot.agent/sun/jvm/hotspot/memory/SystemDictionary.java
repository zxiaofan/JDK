/*
 * Copyright (c) 2001, 2017, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.memory;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.classfile.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;

public class SystemDictionary {
  private static AddressField sharedDictionaryField;
  private static sun.jvm.hotspot.types.OopField javaSystemLoaderField;

  private static AddressField objectKlassField;
  private static AddressField classLoaderKlassField;
  private static AddressField stringKlassField;
  private static AddressField systemKlassField;
  private static AddressField threadKlassField;
  private static AddressField threadGroupKlassField;
  private static AddressField methodHandleKlassField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("SystemDictionary");

    sharedDictionaryField = type.getAddressField("_shared_dictionary");
    javaSystemLoaderField = type.getOopField("_java_system_loader");

    objectKlassField = type.getAddressField(WK_KLASS("Object_klass"));
    classLoaderKlassField = type.getAddressField(WK_KLASS("ClassLoader_klass"));
    stringKlassField = type.getAddressField(WK_KLASS("String_klass"));
    systemKlassField = type.getAddressField(WK_KLASS("System_klass"));
    threadKlassField = type.getAddressField(WK_KLASS("Thread_klass"));
    threadGroupKlassField = type.getAddressField(WK_KLASS("ThreadGroup_klass"));
    methodHandleKlassField = type.getAddressField(WK_KLASS("MethodHandle_klass"));
  }

  // This WK functions must follow the definitions in systemDictionary.hpp:
  private static String WK_KLASS(String name) {
      //#define WK_KLASS(name) _well_known_klasses[SystemDictionary::WK_KLASS_ENUM_NAME(name)]
      return ("_well_known_klasses[SystemDictionary::"+WK_KLASS_ENUM_NAME(name)+"]");
  }
  private static String WK_KLASS_ENUM_NAME(String kname) {
      //#define WK_KLASS_ENUM_NAME(kname)    kname##_knum
      return (kname+"_knum");
  }

  public Dictionary sharedDictionary() {
    Address tmp = sharedDictionaryField.getValue();
    return (Dictionary) VMObjectFactory.newObject(Dictionary.class, tmp);
  }

  // few well known classes -- not all are added here.
  // add more if needed.
  public static InstanceKlass getThreadKlass() {
    return (InstanceKlass)Metadata.instantiateWrapperFor(threadKlassField.getValue());
  }

  public static InstanceKlass getThreadGroupKlass() {
    return (InstanceKlass)Metadata.instantiateWrapperFor(threadGroupKlassField.getValue());
  }

  public static InstanceKlass getObjectKlass() {
    return (InstanceKlass)Metadata.instantiateWrapperFor(objectKlassField.getValue());
  }

  public static InstanceKlass getStringKlass() {
    return (InstanceKlass)Metadata.instantiateWrapperFor(stringKlassField.getValue());
  }

  public static InstanceKlass getClassLoaderKlass() {
    return (InstanceKlass)Metadata.instantiateWrapperFor(classLoaderKlassField.getValue());
  }

  public static InstanceKlass getSystemKlass() {
    return (InstanceKlass)Metadata.instantiateWrapperFor(systemKlassField.getValue());
  }

  public static InstanceKlass getMethodHandleKlass() {
    return (InstanceKlass)Metadata.instantiateWrapperFor(methodHandleKlassField.getValue());
  }

  public InstanceKlass getAbstractOwnableSynchronizerKlass() {
    ClassLoaderDataGraph cldg = VM.getVM().getClassLoaderDataGraph();
    return (InstanceKlass) cldg.find("java/util/concurrent/locks/AbstractOwnableSynchronizer");
  }

  public static Oop javaSystemLoader() {
    return newOop(javaSystemLoaderField.getValue());
  }

  private static Oop newOop(OopHandle handle) {
    return VM.getVM().getObjectHeap().newOop(handle);
  }
}
