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

/** Models the information stored in one of the {@link
    sun.jvm.hotspot.debugger.win32.coff.OptionalHeaderDataDirectories}. (Some
    of the descriptions are taken directly from Microsoft's
    documentation and are copyrighted by Microsoft.) */

public interface DataDirectory {
  /** The relative virtual address of the table. The RVA is the
      address of the table, when loaded, relative to the base address
      of the image. */
  public int getRVA();

  /** The size in bytes of this directory. */
  public int getSize();
}
