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
 * This is the symbol table entry for valuesBoxes.
 **/
public class ValueBoxEntry extends ValueEntry
{
  protected ValueBoxEntry ()
  {
    super ();
  } // ctor

  protected ValueBoxEntry (ValueBoxEntry that)
  {
    super (that);
  } // ctor

  protected ValueBoxEntry (SymtabEntry that, IDLID clone)
  {
    super (that, clone);
  } // ctor

  public Object clone ()
  {
    return new ValueBoxEntry (this);
  } // clone

  /** Invoke the interface generator.
      @param symbolTable the symbol table is a hash table whose key is a fully
       qualified type name and whose value is a SymtabEntry or a subclass of
       SymtabEntry.
      @param stream the stream to which the generator should sent its output.
      @see SymtabEntry */
  public void generate (Hashtable symbolTable, PrintWriter stream)
  {
     valueBoxGen.generate (symbolTable, this, stream);
  } // generate

  /** Access the value generator.
      @return an object which implements the ValueGen interface.
      @see ValueGen */
  public Generator generator ()
  {
    return valueBoxGen;
  } // generator

  static ValueBoxGen valueBoxGen;
} // class ValueEntry
