/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.utilities;

/** A class enabling simple construction of type-safe integer
    enumerations */

public class IntegerEnum {
  private int value;

  /** Constructor is protected because it will only be used by the
      subclass */
  protected IntegerEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
