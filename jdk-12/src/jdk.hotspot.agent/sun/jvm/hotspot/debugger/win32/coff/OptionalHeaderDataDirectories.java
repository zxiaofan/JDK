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

package sun.jvm.hotspot.debugger.win32.coff;

// FIXME: NOT FINISHED

/** Models the information stored in the data directories portion of
    the optional header of a Portable Executable file. FIXME: the
    DataDirectory objects are less than useful; need to bring up more
    of the data structures defined in the documentation. (Some of the
    descriptions are taken directly from Microsoft's documentation and
    are copyrighted by Microsoft.) */

public interface OptionalHeaderDataDirectories {
  /** Export Table address and size. */
  public DataDirectory getExportTable() throws COFFException;

  /** Returns the Export Table, or null if none was present. */
  public ExportDirectoryTable getExportDirectoryTable() throws COFFException;

  /** Import Table address and size */
  public DataDirectory getImportTable() throws COFFException;

  /** Resource Table address and size. */
  public DataDirectory getResourceTable() throws COFFException;

  /** Exception Table address and size. */
  public DataDirectory getExceptionTable() throws COFFException;

  /** Attribute Certificate Table address and size. */
  public DataDirectory getCertificateTable() throws COFFException;

  /** Base Relocation Table address and size. */
  public DataDirectory getBaseRelocationTable() throws COFFException;

  /** Debug data starting address and size. */
  public DataDirectory getDebug() throws COFFException;

  /** Returns the Debug Directory, or null if none was present. */
  public DebugDirectory getDebugDirectory() throws COFFException;

  /** Architecture-specific data address and size. */
  public DataDirectory getArchitecture() throws COFFException;

  /** Relative virtual address of the value to be stored in the global
      pointer register. Size member of this structure must be set to
      0. */
  public DataDirectory getGlobalPtr() throws COFFException;

  /** Thread Local Storage (TLS) Table address and size. */
  public DataDirectory getTLSTable() throws COFFException;

  /** Load Configuration Table address and size. */
  public DataDirectory getLoadConfigTable() throws COFFException;

  /** Bound Import Table address and size. */
  public DataDirectory getBoundImportTable() throws COFFException;

  /** Import Address Table address and size. */
  public DataDirectory getImportAddressTable() throws COFFException;

  /** Address and size of the Delay Import Descriptor. */
  public DataDirectory getDelayImportDescriptor() throws COFFException;

  /** COM+ Runtime Header address and size */
  public DataDirectory getCOMPlusRuntimeHeader() throws COFFException;
}
