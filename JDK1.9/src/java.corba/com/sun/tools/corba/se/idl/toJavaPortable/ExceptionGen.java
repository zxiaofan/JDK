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

import java.io.PrintWriter;
import java.util.Hashtable;

import com.sun.tools.corba.se.idl.ExceptionEntry;

/**
 *
 **/
public class ExceptionGen extends StructGen implements com.sun.tools.corba.se.idl.ExceptionGen
{
  /**
   * Public zero-argument constructor.
   **/
  public ExceptionGen ()
  {
    super (true);
  } // ctor

  /**
   *
   **/
  public void generate (Hashtable symbolTable, ExceptionEntry entry, PrintWriter stream)
  {
    super.generate (symbolTable, entry, stream);
  } // generate
} // class ExceptionGen
