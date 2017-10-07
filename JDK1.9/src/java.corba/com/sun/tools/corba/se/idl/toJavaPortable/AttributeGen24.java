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
 * COMPONENT_NAME: idl.toJava
 *
 * ORIGINS: 27
 *
 * Licensed Materials - Property of IBM
 * 5639-D57 (C) COPYRIGHT International Business Machines Corp. 1997, 1999
 * RMI-IIOP v1.0
 *
 */

package com.sun.tools.corba.se.idl.toJavaPortable;

// NOTES:
// -D62023   <klr> New file to implement CORBA 2.4 RTF
//      REVISIT: These changes should be folded into AttributeGen.

import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Vector;
import java.util.Hashtable;

import com.sun.tools.corba.se.idl.InterfaceEntry;
import com.sun.tools.corba.se.idl.MethodEntry;
import com.sun.tools.corba.se.idl.ParameterEntry;
import com.sun.tools.corba.se.idl.SymtabEntry;
import com.sun.tools.corba.se.idl.AttributeEntry;

/**
 *
 **/
public class AttributeGen24 extends MethodGenClone24
{
  /**
   * Public zero-argument constructor.
   **/
  public AttributeGen24 ()
  {
  } // ctor

  /**
   * (d62023-klr) Added for 2.4 RTF
   **/
  protected void abstractMethod (Hashtable symbolTable, MethodEntry m, PrintWriter stream)
  {
    AttributeEntry a = (AttributeEntry)m;

    // Generate for the get method
    super.abstractMethod (symbolTable, a, stream);

    // Generate for the set method if the attribute is not readonly
    if (!a.readOnly ())
    {
      setupForSetMethod ();
      super.abstractMethod (symbolTable, a, stream);
      clear ();
    }
  } // abstractMethod

  /**
   * (d62023-klr) Added for 2.4 RTF
   **/
  protected void interfaceMethod (Hashtable symbolTable, MethodEntry m, PrintWriter stream)
  {
    AttributeEntry a = (AttributeEntry)m;

    // Generate for the get method
    super.interfaceMethod (symbolTable, a, stream);

    // Generate for the set method if the attribute is not readonly
    if (!a.readOnly ())
    {
      setupForSetMethod ();
      super.interfaceMethod (symbolTable, a, stream);
      clear ();
    }
  } // interfaceMethod

} // class AttributeGen24
