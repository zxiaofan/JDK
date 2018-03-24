/*
 * Copyright (c) 1999, 2001, Oracle and/or its affiliates. All rights reserved.
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
 *
 */
/*
 * COMPONENT_NAME: idl.parser
 *
 * ORIGINS: 27
 *
 * Licensed Materials - Property of IBM
 * 5639-D57 (C) COPYRIGHT International Business Machines Corp. 1997, 1999
 * RMI-IIOP v1.0
 *
 */

package com.sun.tools.corba.se.idl.constExpr;

// NOTES:

import com.sun.tools.corba.se.idl.ConstEntry;
import java.math.BigInteger;

public interface ExprFactory
{
  And          and (Expression left, Expression right);
  BooleanAnd   booleanAnd (Expression left, Expression right);
  BooleanNot   booleanNot (Expression operand);
  BooleanOr    booleanOr (Expression left, Expression right);
  Divide       divide (Expression left, Expression right);
  Equal        equal (Expression left, Expression right);
  GreaterEqual greaterEqual (Expression left, Expression right);
  GreaterThan  greaterThan (Expression left, Expression right);
  LessEqual    lessEqual (Expression left, Expression right);
  LessThan     lessThan (Expression left, Expression right);
  Minus        minus (Expression left, Expression right);
  Modulo       modulo (Expression left, Expression right);
  Negative     negative (Expression operand);
  Not          not (Expression operand);
  NotEqual     notEqual (Expression left, Expression right);
  Or           or (Expression left, Expression right);
  Plus         plus (Expression left, Expression right);
  Positive     positive (Expression operand);
  ShiftLeft    shiftLeft (Expression left, Expression right);
  ShiftRight   shiftRight (Expression left, Expression right);
  Terminal     terminal (String representation, Character charValue,
                         boolean isWide );
  Terminal     terminal (String representation, Boolean booleanValue);
  //daz  Terminal     terminal (String representation, Long longValue);
  Terminal     terminal (String representation, Double doubleValue);
  Terminal     terminal (String representation, BigInteger bigIntegerValue);
  Terminal     terminal (String stringValue, boolean isWide );
  Terminal     terminal (ConstEntry constReference);
  Times        times (Expression left, Expression right);
  Xor          xor (Expression left, Expression right);
} // interface ExprFactory
