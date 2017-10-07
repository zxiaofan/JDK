/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.shared;

//These definitions should be kept in sync with the definitions in the HotSpot
//code.

public enum G1YCType {
  Normal ("Normal"),
  InitialMark ("Initial Mark"),
  DuringMark ("During Mark"),
  Mixed ("Mixed"),
  G1YCTypeEndSentinel ("Unknown");

  private final String value;

  G1YCType(String val) {
    this.value = val;
  }
  public String value() {
    return value;
  }
}
