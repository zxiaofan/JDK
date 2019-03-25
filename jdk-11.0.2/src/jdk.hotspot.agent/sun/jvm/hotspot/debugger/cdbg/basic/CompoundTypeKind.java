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

package sun.jvm.hotspot.debugger.cdbg.basic;

/** Type-safe enum for discriminating between classes, structs and
    unions, which are all represented as compound types */

public class CompoundTypeKind {
  public static final CompoundTypeKind CLASS  = new CompoundTypeKind();
  public static final CompoundTypeKind STRUCT = new CompoundTypeKind();
  public static final CompoundTypeKind UNION  = new CompoundTypeKind();

  private CompoundTypeKind() {}
}
