/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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
// -D52042<daz> Added protypical code for computing mixed-operand binary
//  expressions, which promotes result to Double only when the target type
//  is floating-point. Code violates spec, but may be usable at some future
//  time.

import com.sun.tools.corba.se.idl.Util;
import java.math.BigInteger;

/**
 *
 **/
public class Divide extends BinaryExpr
{
  /**
   * Constructor: set operation and operands.
   **/
  protected Divide (Expression leftOperand, Expression rightOperand)
  {
    super ("/", leftOperand, rightOperand);
  } // ctor

  /**
   *
   **/
  public Object evaluate () throws EvaluationException
  {
    try
    {
      Number l = (Number)left ().evaluate ();
      Number r = (Number)right ().evaluate ();

      boolean lIsNonInteger = l instanceof Float || l instanceof Double;
      boolean rIsNonInteger = r instanceof Float || r instanceof Double;

      if (lIsNonInteger && rIsNonInteger)
        value (new Double (l.doubleValue () / r.doubleValue ()));
      else if (lIsNonInteger || rIsNonInteger)
      {
        String[] parameters = {Util.getMessage ("EvaluationException.divide"),
            left ().value ().getClass ().getName (),
            right ().value ().getClass ().getName ()};
        throw new EvaluationException (Util.getMessage ("EvaluationException.1", parameters));
      }
      else
      {
        BigInteger tmpL = (BigInteger)l,  tmpR = (BigInteger)r;
        value (tmpL.divide (tmpR));
      }
      // <d52042> Allow evaluation over mixed operands.  Supplant code above.
      /*
      Number l = (Number)left ().evaluate ();
      Number r = (Number)right ().evaluate ();

      boolean lIsNonInteger = l instanceof Float || l instanceof Double;
      boolean rIsNonInteger = r instanceof Float || r instanceof Double;

      // Floating-point operands.
      if (lIsNonInteger && rIsNonInteger)
      {
        value (new Double (l.doubleValue () / r.doubleValue ()));
      }
      // Integral operands.
      else if (!(lIsNonInteger || rIsNonInteger))
      {
        BigInteger tmpL = (BigInteger)l,  tmpR = (BigInteger)r;
        value (tmpL.divide (tmpR));
      }
      // Mixed operands: one operand is floating-point, the other is integral.
      else
      {
        // Legal over floating-point types only.
        if (type ().equals ("float") ||
            type ().equals ("double"))
        {
          value (new Double (l.doubleValue () / r.doubleValue ()));
        }
        else
        {
          String[] parameters = {Util.getMessage ("EvaluationException.divide"),
              left ().value ().getClass ().getName (),
              right ().value ().getClass ().getName ()};
        throw new EvaluationException (Util.getMessage ("EvaluationException.1", parameters));
        }
      }
      */
    }
    catch (ClassCastException e)
    {
      String[] parameters = {Util.getMessage ("EvaluationException.divide"), left ().value ().getClass ().getName (), right ().value ().getClass ().getName ()};
      throw new EvaluationException (Util.getMessage ("EvaluationException.1", parameters));
    }
    return value ();
  } // evaluate
} // class Divide
