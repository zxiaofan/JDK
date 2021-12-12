/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger;

/** An extension of the Debugger interface which can be configured
    with Java type sizes to allow the sizes of primitive Java types to
    be read from the remote JVM. */

public interface JVMDebugger extends Debugger {
  /** This intent is that this can be called late in the bootstrapping
      sequence, after which the debugger can handle reading of Java
      primitive types, and thereby implement the Java functionality in
      class Address. FIXME: consider adding oop size here as well and
      removing it from the MachineDescription. */
  public void configureJavaPrimitiveTypeSizes(long jbooleanSize,
                                              long jbyteSize,
                                              long jcharSize,
                                              long jdoubleSize,
                                              long jfloatSize,
                                              long jintSize,
                                              long jlongSize,
                                              long jshortSize);
  public void putHeapConst(long heapOopSize, long klassPtrSize,
                           long narrowKlassBase, int narrowKlassShift,
                           long narrowOopBase, int narrowOopShift);
  public Address newAddress(long value);
}
