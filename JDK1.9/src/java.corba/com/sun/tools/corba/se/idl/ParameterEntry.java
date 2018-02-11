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
 * This is the symbol table entry for parameters.
 **/
public class ParameterEntry extends SymtabEntry
{
  /** This is a set of class constants.  A parameter can be passed
      as one of In, Out, or Inout. */
  public static final int In    = 0,
                          Inout = 1,
                          Out   = 2;

  protected ParameterEntry ()
  {
    super ();
  } // ctor

  protected ParameterEntry (ParameterEntry that)
  {
    super (that);
    _passType = that._passType;
  } // ctor

  protected ParameterEntry (SymtabEntry that, IDLID clone)
  {
    super (that, clone);
    if (module ().equals (""))
      module (name ());
    else if (!name ().equals (""))
      module (module () + "/" + name ());
  } // ctor

  public Object clone ()
  {
    return new ParameterEntry (this);
  } // clone

  /** Invoke the paramter generator.
      @param symbolTable the symbol table is a hash table whose key is
       a fully qualified type name and whose value is a SymtabEntry or
       a subclass of SymtabEntry.
      @param stream the stream to which the generator should sent its output.
      @see SymtabEntry */
  public void generate (Hashtable symbolTable, PrintWriter stream)
  {
    parameterGen.generate (symbolTable, this, stream);
  } // generate

  /** Access the parameter generator.
      @return an object which implements the ParameterGen interface.
      @see ParameterGen */
  public Generator generator ()
  {
    return parameterGen;
  } // generator

  /** This indicates the pass type of this parameter. */
  public void passType (int passType)
  {
    if (passType >= In && passType <= Out)
      _passType = passType;
  } // passType

  /** This indicates the pass type of this parameter. */
  public int passType ()
  {
    return _passType;
  } // passType

  private int _passType = In;

  static ParameterGen parameterGen;
} // class ParameterEntry
