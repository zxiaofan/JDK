/*
 * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
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

public interface AltPlatformInfo {

  // Additional cpu types can be tested via this interface
  public boolean knownCPU(String cpu);

  // Mangle a cpu name if necessary
  public String getCPU(String cpu);
}
