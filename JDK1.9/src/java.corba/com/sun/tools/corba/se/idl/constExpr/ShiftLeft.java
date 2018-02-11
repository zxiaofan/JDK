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

import com.sun.tools.corba.se.idl.Util;
import java.math.BigInteger;

public class ShiftLeft extends BinaryExpr
{
  protected ShiftLeft (Expression leftOperand, Expression rightOperand)
  {
    super ("<<", leftOperand, rightOperand);
  } // ctor

  public Object evaluate () throws EvaluationException
  {
    try
    {
      Number l = (Number)left ().evaluate ();
      Number r = (Number)right ().evaluate ();

      if (l instanceof Float || l instanceof Double || r instanceof Float || r instanceof Double)
      {
        String[] parameters = {Util.getMessage ("EvaluationException.left"), left ().value ().getClass ().getName (), right ().value ().getClass ().getName ()};
        throw new EvaluationException (Util.getMessage ("EvaluationException.1", parameters));
      }
      else
      {
        // Shift left (<<)
        //daz        value (new Long (l.longValue () << r.longValue ()));
        BigInteger bL = (BigInteger)coerceToTarget (l);
        BigInteger bR = (BigInteger)r;

        BigInteger ls  = bL.shiftLeft (bR.intValue ());

        if (type ().indexOf ("short") >= 0)
          ls = ls.mod (twoPow16);
        else if (type ().indexOf ("long") >= 0)
          ls = ls.mod (twoPow32);
        else if (type ().indexOf ("long long") >= 0)
          ls = ls.mod (twoPow64);

        value (coerceToTarget (ls));
      }
    }
    catch (ClassCastException e)
    {
      String[] parameters = {Util.getMessage ("EvaluationException.left"), left ().value ().getClass ().getName (), right ().value ().getClass ().getName ()};
      throw new EvaluationException (Util.getMessage ("EvaluationException.1", parameters));
    }
    return value ();
  } // evaluate
} // class ShiftLeft
