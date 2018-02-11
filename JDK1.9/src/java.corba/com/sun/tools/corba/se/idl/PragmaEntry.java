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
 * This is the symbol table entry for the #pragma statement.
 **/
public class PragmaEntry extends SymtabEntry
{
  protected PragmaEntry ()
  {
    super ();
    repositoryID (Util.emptyID);
  } // ctor

  protected PragmaEntry (SymtabEntry that)
  {
    super (that, new IDLID ());
    module (that.name ());
    name ("");
  } // ctor

  protected PragmaEntry (PragmaEntry that)
  {
    super (that);
  } // ctor

  public Object clone ()
  {
    return new PragmaEntry (this);
  } // clone

  /** Invoke the Include type generator.
      @param symbolTable the symbol table is a hash table whose key is
       a fully qualified type name and whose value is a SymtabEntry or
       a subclass of SymtabEntry.
      @param stream the stream to which the generator should sent its output.
      @see SymtabEntry */
  public void generate (Hashtable symbolTable, PrintWriter stream)
  {
    pragmaGen.generate (symbolTable, this, stream);
  } // generate

  /** Access the Include type generator.
      @return an object which implements the IncludeGen interface.
      @see IncludeGen */
  public Generator generator ()
  {
    return pragmaGen;
  } // generator

  public String data ()
  {
    return _data;
  } // data

  public void data (String newData)
  {
    _data = newData;
  } // data

  static PragmaGen pragmaGen;

  private String _data = null;
} // class PragmaEntry
