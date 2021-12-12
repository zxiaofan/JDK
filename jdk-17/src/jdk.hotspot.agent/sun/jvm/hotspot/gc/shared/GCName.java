/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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

public enum GCName {
  ParallelOld ("ParallelOld"),
  SerialOld ("SerialOld"),
  PSMarkSweep ("PSMarkSweep"),
  ParallelScavenge ("ParallelScavenge"),
  DefNew ("DefNew"),
  G1New ("G1New"),
  G1Old ("G1Old"),
  G1Full ("G1Full"),
  Z ("Z"),
  Shenandoah ("Shenandoah"),
  NA ("N/A"),
  GCNameEndSentinel ("GCNameEndSentinel");

  private final String value;

  GCName(String val) {
    this.value = val;
  }
  public String value() {
    return value;
  }
}
