/*
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
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

// An OopVisitor can be used to inspect all fields within an object.
// Fields include vm fields, java fields, indexable fields.

public interface FieldVisitor {
  // Callback methods for each field type in an object
  public void doMetadata(MetadataField field, boolean isVMField);
  public void doOop(OopField field, boolean isVMField);
  public void doOop(NarrowOopField field, boolean isVMField);
  public void doByte(ByteField field, boolean isVMField);
  public void doChar(CharField field, boolean isVMField);
  public void doBoolean(BooleanField field, boolean isVMField);
  public void doShort(ShortField field, boolean isVMField);
  public void doInt(IntField field, boolean isVMField);
  public void doLong(LongField field, boolean isVMField);
  public void doFloat(FloatField field, boolean isVMField);
  public void doDouble(DoubleField field, boolean isVMField);
  public void doCInt(CIntField field, boolean isVMField);
};
