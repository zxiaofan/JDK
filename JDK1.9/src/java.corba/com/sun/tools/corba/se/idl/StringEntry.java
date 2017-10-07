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

import com.sun.tools.corba.se.idl.constExpr.Expression;

public class StringEntry extends SymtabEntry
{
  protected StringEntry ()
  {
    super ();
    String override = (String)Parser.overrideNames.get ("string");
    if (override == null)
      name ("string");
    else
      name (override);
    repositoryID (Util.emptyID);
  } // ctor

  protected StringEntry (StringEntry that)
  {
    super (that);
    _maxSize = that._maxSize;
  } // ctor

  protected StringEntry (SymtabEntry that, IDLID clone)
  {
    super (that, clone);
    module ("");

    String override = (String)Parser.overrideNames.get ("string");
    if (override == null)
      name ("string");
    else
      name (override);
    repositoryID (Util.emptyID);
  } // ctor

  public Object clone ()
  {
    return new StringEntry (this);
  } // clone

  /** Invoke the string type generator.
      @param symbolTable the symbol table is a hash table whose key is
       a fully qualified type name and whose value is a SymtabEntry or
       a subclass of SymtabEntry.
      @param stream the stream to which the generator should sent its output.
      @see SymtabEntry */
  public void generate (Hashtable symbolTable, PrintWriter stream)
  {
    stringGen.generate (symbolTable, this, stream);
  } // generate

  /** Access the primitive type generator.
      @return an object which implements the PrimitiveGen interface.
      @see PrimitiveGen */
  public Generator generator ()
  {
    return stringGen;
  } // generator

  /** The constant expression defining the maximum size of the string.
      If it is null, then the string is unbounded. */
  public void maxSize (Expression expr)
  {
    _maxSize = expr;
  } // maxSize

  /** The constant expression defining the maximum size of the string.
      If it is null, then the string is unbounded. */
  public Expression maxSize ()
  {
    return _maxSize;
  } // maxSize

  static StringGen  stringGen;

  private Expression _maxSize = null;
} // class StringEntry
