/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

//These definitions should be kept in sync with the definitions in the HotSpot code.

public enum Flags {
  // value origin
  DEFAULT ("Default"),
  COMMAND_LINE ("Command line"),
  ENVIRON_VAR ("Environment variable"),
  CONFIG_FILE ("Config file"),
  MANAGEMENT ("Management"),
  ERGONOMIC ("Ergonomic"),
  ATTACH_ON_DEMAND ("Attach on demand"),
  INTERNAL ("Internal"),
  JIMAGE_RESOURCE ("JImage");

  private final String value;

  Flags(String val) {
    this.value = val;
  }
  public String value() {
    return value;
  }
}
