/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

import sun.jvm.hotspot.debugger.Address;

/** A DefaultMetadataVisitor implements basic no-op MetadataVisitor
    functionality except that the setObj() and getObj() methods are
    implemented properly. */
abstract public class DefaultMetadataVisitor implements MetadataVisitor {
  private Metadata obj;

  public void prologue()                        {}

  // Called after visiting an object
  public void epilogue()                        {}

  public void setObj(Metadata obj) {
    this.obj = obj;
  }

  public Metadata getObj() {
    return obj;
  }

  // Callback methods for each field type in an object
  abstract public void doMetadata(MetadataField field, boolean isVMField);
  public void doOop(OopField field, boolean isVMField)         {}
  public void doOop(NarrowOopField field, boolean isVMField)   {}
  public void doByte(ByteField field, boolean isVMField)       {}
  public void doChar(CharField field, boolean isVMField)       {}
  public void doBoolean(BooleanField field, boolean isVMField) {}
  public void doShort(ShortField field, boolean isVMField)     {}
  public void doInt(IntField field, boolean isVMField)         {}
  public void doLong(LongField field, boolean isVMField)       {}
  public void doFloat(FloatField field, boolean isVMField)     {}
  public void doDouble(DoubleField field, boolean isVMField)   {}
  public void doCInt(CIntField field, boolean isVMField)       {}
}
