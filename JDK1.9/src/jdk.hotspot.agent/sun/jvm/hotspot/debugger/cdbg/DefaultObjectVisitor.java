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

/** Implementation of the ObjectVisitor interface with all methods
    empty */

public class DefaultObjectVisitor implements ObjectVisitor {
  public void enterType(Type type, Address objectAddress) {}
  public void exitType() {}
  public void doBit(FieldIdentifier f, long val) {}
  public void doInt(FieldIdentifier f, long val) {}
  public void doEnum(FieldIdentifier f, long val, String enumName) {}
  public void doFloat(FieldIdentifier f, float val) {}
  public void doDouble(FieldIdentifier f, double val) {}
  public void doPointer(FieldIdentifier f, Address val) {}
  public void doArray(FieldIdentifier f, Address val) {}
  public void doRef(FieldIdentifier f, Address val) {}
  public void doCompound(FieldIdentifier f, Address addressOfEmbeddedCompoundObject) {}
}
