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

/** Models all compound types, i.e., those containing fields: classes,
    structs, and unions. The boolean type accessors indicate how the
    type is really defined in the debug information. */

public interface CompoundType {
  public int       getNumBaseClasses();
  public BaseClass getBaseClass(int i);

  public int   getNumFields();
  public Field getField(int i);

  /** Defined as a class in the debug information? */
  public boolean isClass();

  /** Defined as a struct in the debug information? */
  public boolean isStruct();

  /** Defined as a union in the debug information? */
  public boolean isUnion();
}
