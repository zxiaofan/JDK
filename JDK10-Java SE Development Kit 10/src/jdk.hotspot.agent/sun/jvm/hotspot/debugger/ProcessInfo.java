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

package sun.jvm.hotspot.debugger;

/** Simple wrapper class for name and process ID information.
    Hopefully this will be generic enough to be portable. */

public class ProcessInfo {
  public ProcessInfo(String name, int pid) {
    this.name = name;
    this.pid = pid;
  }

  public String getName() {
    return name;
  }

  public int getPid() {
    return pid;
  }

  private String name;
  private int pid;
}
