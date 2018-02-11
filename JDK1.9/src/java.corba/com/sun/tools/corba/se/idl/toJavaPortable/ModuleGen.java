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

import java.io.File;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import com.sun.tools.corba.se.idl.ModuleEntry;
import com.sun.tools.corba.se.idl.SymtabEntry;

/**
 *
 **/
public class ModuleGen implements com.sun.tools.corba.se.idl.ModuleGen
{
  /**
   * Public zero-argument constructor.
   **/
  public ModuleGen ()
  {
  } // ctor

  /**
   * Generate Java code for all members of an IDL module.
   **/
  public void generate (Hashtable symbolTable, ModuleEntry entry, PrintWriter stream)
  {
    // Generate the package directory
    String name = Util.containerFullName( entry ) ;
    Util.mkdir (name);

    // Generate all of the contained types
    Enumeration e = entry.contained ().elements ();
    while (e.hasMoreElements ())
    {
      SymtabEntry element = (SymtabEntry)e.nextElement ();
      if (element.emit ())
        element.generate (symbolTable, stream);
    }
  } // generate
} // class ModuleGen
