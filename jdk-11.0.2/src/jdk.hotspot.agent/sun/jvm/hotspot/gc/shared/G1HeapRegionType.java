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

package sun.jvm.hotspot.gc.shared;

//These definitions should be kept in sync with the definitions in the HotSpot code.

public enum G1HeapRegionType {
  Free ("Free"),
  Eden ("Eden"),
  Survivor ("Survivor"),
  StartsHumongous ("Starts Humongous"),
  ContinuesHumongous ("Continues Humongous"),
  Old ("Old"),
  Archive ("Archive"),
  G1HeapRegionTypeEndSentinel ("G1HeapRegionTypeEndSentinel");

  private final String value;

  G1HeapRegionType(String val) {
    this.value = val;
  }
  public String value() {
    return value;
  }
}
