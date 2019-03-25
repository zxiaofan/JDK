/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

/** Constants enumerating characteristics of a DLL; see {@link
    sun.jvm.hotspot.debugger.win32.coff.OptionalHeaderWindowsSpecificFields#getDLLCharacteristics}.
    (Some of the descriptions are taken directly from Microsoft's
    documentation and are copyrighted by Microsoft.) */

public interface DLLCharacteristics {
  /** Do not bind image */
  public short IMAGE_DLLCHARACTERISTICS_NO_BIND = (short) 0x0800;
  /** Driver is a WDM Driver */
  public short IMAGE_DLLCHARACTERISTICS_WDM_DRIVER = (short) 0x2000;
  /** Image is Terminal Server aware */
  public short IMAGE_DLLCHARACTERISTICS_TERMINAL_SERVER_AWARE = (short) 0x8000;
}
