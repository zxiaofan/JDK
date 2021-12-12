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

package sun.jvm.hotspot.debugger;

public class MachineDescriptionPPC64 extends MachineDescriptionTwosComplement implements MachineDescription {
  public long getAddressSize() {
    return 8;
  }

  public boolean isLP64() {
    return true;
  }

  public boolean isBigEndian() {
    return "big".equals(System.getProperty("sun.cpu.endian"));
  }
}
