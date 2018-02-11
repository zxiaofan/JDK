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

package com.sun.tools.corba.se.idl;

// NOTES:

import java.io.PrintWriter;
import java.util.Hashtable;

/**
 * This is the symbol table entry for primitive types:  octet, char,
 * short, long, long long (and unsigned versions), float, double, string.
 **/
public class PrimitiveEntry extends SymtabEntry
{
  protected PrimitiveEntry ()
  {
    super ();
    repositoryID (Util.emptyID);
  } // ctor

  protected PrimitiveEntry (String name)
  {
    name (name);
    module ("");
    repositoryID (Util.emptyID);
  } // ctor

  protected PrimitiveEntry (PrimitiveEntry that)
  {
    super (that);
  } // ctor

  public Object clone ()
  {
    return new PrimitiveEntry (this);
  } // clone

  /** Invoke the primitive type generator.
      @param symbolTable the symbol table is a hash table whose key is
       a fully qualified type name and whose value is a SymtabEntry or
       a subclass of SymtabEntry.
      @param stream the stream to which the generator should sent its output.
      @see SymtabEntry */
  public void generate (Hashtable symbolTable, PrintWriter stream)
  {
    primitiveGen.generate (symbolTable, this, stream);
  } // generate

  /** Access the primitive type generator.
      @return an object which implements the PrimitiveGen interface.
      @see PrimitiveGen */
  public Generator generator ()
  {
    return primitiveGen;
  } // generator

  static PrimitiveGen primitiveGen;
} // class PrimitiveEntry
