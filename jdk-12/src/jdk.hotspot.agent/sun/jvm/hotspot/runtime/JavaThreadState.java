/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

/** This is a type-safe enum mirroring the JavaThreadState enum in
    globalDefinitions.hpp. The conversion between the underlying ints
    and these values is done in JavaThread. */

public class JavaThreadState {
  private String stringVal;

  /** Should never happen (missing initialization) */
  public static final JavaThreadState UNINITIALIZED     = new JavaThreadState("UNINITIALIZED");
  /** Just starting up, i.e., in process of being initialized */
  public static final JavaThreadState NEW               = new JavaThreadState("NEW");
  /** Corresponding transition state (not used, included for completness) */
  public static final JavaThreadState NEW_TRANS         = new JavaThreadState("NEW_TRANS");
  /** Running in native code */
  public static final JavaThreadState IN_NATIVE         = new JavaThreadState("IN_NATIVE");
  /** Corresponding transition state */
  public static final JavaThreadState IN_NATIVE_TRANS   = new JavaThreadState("IN_NATIVE_TRANS");
  /** Running in VM */
  public static final JavaThreadState IN_VM             = new JavaThreadState("IN_VM");
  /** Corresponding transition state */
  public static final JavaThreadState IN_VM_TRANS       = new JavaThreadState("IN_VM_TRANS");
  /** Running in Java or in stub code */
  public static final JavaThreadState IN_JAVA           = new JavaThreadState("IN_JAVA");
  /** Corresponding transition state (not used, included for completness) */
  public static final JavaThreadState IN_JAVA_TRANS     = new JavaThreadState("IN_JAVA_TRANS");
  /** Blocked in vm */
  public static final JavaThreadState BLOCKED           = new JavaThreadState("BLOCKED");
  /** Corresponding transition state   */
  public static final JavaThreadState BLOCKED_TRANS     = new JavaThreadState("BLOCKED_TRANS");
  /** Special state needed, since we cannot suspend a thread when it is in native_trans */

  private JavaThreadState(String stringVal) {
    this.stringVal = stringVal;
  }

  public String toString() {
    return stringVal;
  }
}
