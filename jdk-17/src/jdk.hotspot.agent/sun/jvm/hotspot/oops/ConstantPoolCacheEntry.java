/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ConstantPoolCacheEntry {
  private static long          size;
  private static long          baseOffset;
  private static CIntegerField indices;
  private static AddressField  f1;
  private static CIntegerField f2;
  private static CIntegerField flags;

  private ConstantPoolCache cp;
  private long      offset;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("ConstantPoolCacheEntry");
    size = type.getSize();

    indices = type.getCIntegerField("_indices");
    f1      = type.getAddressField ("_f1");
    f2      = type.getCIntegerField("_f2");
    flags   = type.getCIntegerField("_flags");

    type = db.lookupType("ConstantPoolCache");
    baseOffset = type.getSize();
  }

  ConstantPoolCacheEntry(ConstantPoolCache cp, int index) {
    this.cp = cp;
    offset  = baseOffset + index * size;
  }

  public int getConstantPoolIndex() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that((getIndices() & 0xFFFF) != 0, "must be main entry");
    }
    return (int) (getIndices() & 0xFFFF);
  }

  private long getIndices() {
    return cp.getAddress().getCIntegerAt(indices.getOffset() + offset, indices.getSize(), indices.isUnsigned());
  }

  public Metadata getF1() {
    return Metadata.instantiateWrapperFor(cp.getAddress().getAddressAt(f1.getOffset() + offset));
  }

  public int getF2() {
    return cp.getAddress().getJIntAt(f1.getOffset() + offset);
  }

  public int getFlags() {
    return cp.getAddress().getJIntAt(flags.getOffset() + offset);
  }

  static NamedFieldIdentifier f1FieldName = new NamedFieldIdentifier("_f1");
  static NamedFieldIdentifier f2FieldName = new NamedFieldIdentifier("_f2");
  static NamedFieldIdentifier flagsFieldName = new NamedFieldIdentifier("_flags");

  public void iterateFields(MetadataVisitor visitor) {
    visitor.doOop(new OopField(f1FieldName, f1.getOffset() + offset, true), true);
    visitor.doInt(new IntField(f2FieldName, f2.getOffset() + offset, true), true);
    visitor.doInt(new IntField(flagsFieldName, flags.getOffset() + offset, true), true);
  }
}
