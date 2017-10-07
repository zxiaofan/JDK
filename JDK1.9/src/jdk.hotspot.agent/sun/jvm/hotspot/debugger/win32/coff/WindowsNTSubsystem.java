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

/** Constants enumerating which Windows NT subsystem a given Portable
    Executable runs in; see {@link
    sun.jvm.hotspot.debugger.win32.coff.OptionalHeaderWindowsSpecificFields#getSubsystem}.
    (Some of the descriptions are taken directly from Microsoft's
    documentation and are copyrighted by Microsoft.) */

public interface WindowsNTSubsystem {
  /** Unknown subsystem. */
  public short IMAGE_SUBSYSTEM_UNKNOWN = (short) 0;

  /** Used for device drivers and native Windows NT processes. */
  public short IMAGE_SUBSYSTEM_NATIVE = (short) 1;

  /** Image runs in the Windows graphical user interface (GUI) subsystem. */
  public short IMAGE_SUBSYSTEM_WINDOWS_GUI = (short) 2;

  /** Image runs in the Windows character subsystem. */
  public short IMAGE_SUBSYSTEM_WINDOWS_CUI = (short) 3;

  /** Image runs in the Posix character subsystem. */
  public short IMAGE_SUBSYSTEM_POSIX_CUI = (short) 7;

  /** Image runs on Windows CE. */
  public short IMAGE_SUBSYSTEM_WINDOWS_CE_GUI = (short) 9;

  /** Image is an EFI application. */
  public short IMAGE_SUBSYSTEM_EFI_APPLICATION = (short) 10;

  /** Image is an EFI driver that provides boot services. */
  public short IMAGE_SUBSYSTEM_EFI_BOOT_SERVICE_DRIVER = (short) 11;

  /** Image is an EFI driver that provides runtime services. */
  public short IMAGE_SUBSYSTEM_EFI_RUNTIME_DRIVER = (short) 12;
}
