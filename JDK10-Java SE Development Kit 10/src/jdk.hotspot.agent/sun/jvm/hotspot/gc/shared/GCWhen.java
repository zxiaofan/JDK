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

//These definitions should be kept in sync with the definitions in the HotSpot code.

public enum GCWhen {
  BeforeGC ("Before GC"),
  AfterGC ("After GC"),
  GCWhenEndSentinel ("GCWhenEndSentinel");

  private final String value;

  GCWhen(String val) {
    this.value = val;
  }
  public String value() {
    return value;
  }
}



