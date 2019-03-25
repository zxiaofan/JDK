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

/** Describes an Auxiliary File record, which follows a symbol with
    storage class FILE. The symbol name itself should be <B>.file</B>.
    (Some of the descriptions are taken directly from Microsoft's
    documentation and are copyrighted by Microsoft.)  */

public interface AuxFileRecord extends AuxSymbolRecord {
  public String getName();
}
