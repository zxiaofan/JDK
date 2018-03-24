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

/** Abstraction over named fields and indices of arrays. Call
    toString() on a FieldIdentifier to get a printable name for the
    field. */

public interface FieldIdentifier {
  public Type getType();
  public String toString();
}
