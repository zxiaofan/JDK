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

package sun.jvm.hotspot.debugger.cdbg;

import sun.jvm.hotspot.debugger.*;

public interface Field {
  /** See {@link sun.jvm.hotspot.debugger.cdbg.AccessControl} */
  public int     getAccessControl();
  public String  getName();
  public Type    getType();
  /** Indicates whether this field is static */
  public boolean isStatic();
  /** Nonstatic fields only: offset of field in data structure, in bytes */
  public long    getOffset();
  /** Static fields only: address of the field */
  public Address getAddress();
}
