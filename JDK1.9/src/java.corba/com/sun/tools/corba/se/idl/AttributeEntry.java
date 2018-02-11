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
 * This is the symbol table entry for attributes.  An attribute is simply
 * two methods with no exceptions or contexts:  a get method and, if not
 * readOnly, a set method.
 **/
public class AttributeEntry extends MethodEntry
{
  protected AttributeEntry ()
  {
    super ();
  } // ctor

  protected AttributeEntry (AttributeEntry that)
  {
    super (that);
    _readOnly  = that._readOnly;
  } // ctor

  protected AttributeEntry (InterfaceEntry that, IDLID clone)
  {
    super (that, clone);
  } // ctor

  public Object clone ()
  {
    return new AttributeEntry (this);
  } // clone

  /** Invoke the attribute generator.
      @param symbolTable the symbol table is a hash table whose key is
       a fully qualified type name and whose value is a SymtabEntry or
       a subclass of SymtabEntry.
      @param stream the stream to which the generator should sent its output.
      @see SymtabEntry */
  public void generate (Hashtable symbolTable, PrintWriter stream)
  {
    attributeGen.generate (symbolTable, this, stream);
  } // generate

  /** Access the attribute generator.
      @return an object which implements the AttributeGen interface.
      @see AttributeGen */
  public Generator generator ()
  {
    return attributeGen;
  } // generator

  /** if true, only a get method will be generated. */
  public boolean readOnly ()
  {
    return _readOnly;
  } // readOnly

  /** if true, only a get method will be generated. */
  public void readOnly (boolean readOnly)
  {
    _readOnly = readOnly;
  } // readOnly

  static AttributeGen attributeGen;

  public boolean      _readOnly = false;
} // class AttributeEntry
