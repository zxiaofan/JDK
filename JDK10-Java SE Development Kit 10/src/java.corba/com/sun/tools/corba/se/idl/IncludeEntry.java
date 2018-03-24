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
import java.util.Vector;

/**
 * This is the symbol table entry for the #include statement.
 **/
public class IncludeEntry extends SymtabEntry
{
  protected IncludeEntry ()
  {
    super ();
    repositoryID (Util.emptyID);
  } // ctor

  protected IncludeEntry (SymtabEntry that)
  {
    super (that, new IDLID ());
    module (that.name ());
    name ("");
  } // ctor

  protected IncludeEntry (IncludeEntry that)
  {
    super (that);
  } // ctor

  public Object clone ()
  {
    return new IncludeEntry (this);
  } // clone

  /** Invoke the Include type generator.
      @param symbolTable the symbol table is a hash table whose key is
       a fully qualified type name and whose value is a SymtabEntry or
       a subclass of SymtabEntry.
      @param stream the stream to which the generator should sent its output.
      @see SymtabEntry */
  public void generate (Hashtable symbolTable, PrintWriter stream)
  {
    includeGen.generate (symbolTable, this, stream);
  } // generate

  /** Access the Include type generator.
      @return an object which implements the IncludeGen interface.
      @see IncludeGen */
  public Generator generator ()
  {
    return includeGen;
  } // generator

  //d44810
  /** Set the fully-qualified file specification of this include file. */
  public void absFilename (String afn)
  {
    _absFilename = afn;
  }

  //d44810
  /** Access the fully-qualified file specification of this include.
      @return a string containing the path of the include file. */
  public String absFilename ()
  {
    return _absFilename;
  }

  /** Add an IncludeEntry to the list of files which this included
      file includes. */
  public void addInclude (IncludeEntry entry)
  {
    includeList.addElement (entry);
  } // addInclude

  /** Get the list of files which this file includes. */
  public Vector includes ()
  {
    return includeList;
  } // includes

  static  IncludeGen includeGen;
  /** List of files this file includes */
  private Vector     includeList = new Vector ();
  //d44810
  /** Absolute file name for .u file generation. */
  private String     _absFilename       = null;
} // class IncludeEntry
