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
// -D61056   <klr> Use Util.helperName

import java.io.File;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Vector;

import com.sun.tools.corba.se.idl.GenFileStream;
import com.sun.tools.corba.se.idl.InterfaceEntry;
import com.sun.tools.corba.se.idl.SymtabEntry;
import com.sun.tools.corba.se.idl.TypedefEntry;
import com.sun.tools.corba.se.idl.ForwardValueEntry;
import com.sun.tools.corba.se.idl.InterfaceState;
import com.sun.tools.corba.se.idl.MethodEntry;

/**
 *
 **/
public class ForwardValueGen implements com.sun.tools.corba.se.idl.ForwardValueGen, JavaGenerator
{
  /**
   * Public zero-argument constructor.
   **/
  public ForwardValueGen ()
  {
  } // ctor

  /**
   *
   **/
  public void generate (Hashtable symbolTable, ForwardValueEntry v, PrintWriter str)
  {
    this.symbolTable = symbolTable;
    this.v = v;

    openStream ();
    if (stream == null)
      return;
    generateHelper ();
    generateHolder ();
    generateStub ();
    writeHeading ();
    writeBody ();
    writeClosing ();
    closeStream ();
  } // generate

  /**
   *
   **/
  protected void openStream ()
  {
    stream = Util.stream (v, ".java");
  } // openStream

  /**
   *
   **/
  protected void generateHelper ()
  {
    ((Factories)Compile.compiler.factories ()).helper ().generate (symbolTable, v);
  } // generateHelper

  /**
   *
   **/
  protected void generateHolder ()
  {
    ((Factories)Compile.compiler.factories ()).holder ().generate (symbolTable, v);
  } // generateHolder

  /**
   *
   **/
  protected void generateStub ()
  {
  } // generateStub

  /**
   *
   **/
  protected void writeHeading ()
  {
    Util.writePackage (stream, v);
    Util.writeProlog (stream, ((GenFileStream)stream).name ());

    if (v.comment () != null)
      v.comment ().generate ("", stream);

    stream.print ("public class " + v.name () + " implements org.omg.CORBA.portable.IDLEntity");
      // There should ALWAYS be at least one:  ValueBase

    stream.println ("{");
  } // writeHeading

  /**
   *
   **/
  protected void writeBody ()
  {
  } // writeBody

  /**
   *
   **/
  protected void writeClosing ()
  {
   stream.println ("} // class " + v.name ());
  } // writeClosing

  /**
   *
   **/
  protected void closeStream ()
  {
    stream.close ();
  } // closeStream

  ///////////////
  // From JavaGenerator

  public int helperType (int index, String indent, TCOffsets tcoffsets, String name, SymtabEntry entry, PrintWriter stream)
  {
    return index;
  } // helperType

  public int type (int index, String indent, TCOffsets tcoffsets, String name, SymtabEntry entry, PrintWriter stream) {
    stream.println (indent + name + " = " + Util.helperName (entry, true) + ".type ();"); // <d61056>
    return index;
  } // type

  public void helperRead (String entryName, SymtabEntry entry, PrintWriter stream)
  {
    stream.println ("    " + entryName + " value = new " + entryName + " ();");
    read (0, "    ", "value", entry, stream);
    stream.println ("    return value;");
  } // helperRead

  public int read (int index, String indent, String name, SymtabEntry entry, PrintWriter stream)
  {
    return index;
  } // read

  public void helperWrite (SymtabEntry entry, PrintWriter stream)
  {
    write (0, "    ", "value", entry, stream);
  } // helperWrite

  public int write (int index, String indent, String name, SymtabEntry entry, PrintWriter stream)
  {
    return index;
  } // write

  // From JavaGenerator
  ///////////////

  /**
   *
   **/
  protected void writeAbstract ()
  {
  } // writeAbstract

  protected Hashtable  symbolTable = null;
  protected ForwardValueEntry v = null;
  protected PrintWriter stream = null;
} // class ForwardValueGen
