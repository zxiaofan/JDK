/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.win32.coff;

/** Models debug information in Visual C++ 5.0 format. */

public interface DebugVC50 {
  public int getSubsectionDirectoryOffset();

  public DebugVC50SubsectionDirectory getSubsectionDirectory();
}
