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

public interface TypeVisitor {
  public void doBitType(BitType t);
  public void doIntType(IntType t);
  public void doEnumType(EnumType t);
  public void doFloatType(FloatType t);
  public void doDoubleType(DoubleType t);
  public void doPointerType(PointerType t);
  public void doArrayType(ArrayType t);
  public void doRefType(RefType t);
  public void doCompoundType(CompoundType t);
  public void doFunctionType(FunctionType t);
  public void doMemberFunctionType(MemberFunctionType t);
  public void doVoidType(VoidType t);
}
