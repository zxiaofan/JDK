/*
 * Copyright (c) 2000, 2008, Oracle and/or its affiliates. All rights reserved.
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

public class MachineDescriptionIntelX86 extends MachineDescriptionTwosComplement implements MachineDescription {
  public long getAddressSize() {
    return 4;
  }

  public boolean isBigEndian() {
    return false;
  }
}
