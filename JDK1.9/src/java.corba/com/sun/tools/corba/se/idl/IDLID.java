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

public class IDLID extends RepositoryID
{
  public IDLID ()
  {
    _prefix  = "";
    _name    = "";
    _version = "1.0";
  } // ctor

  public IDLID (String prefix, String name, String version)
  {
    _prefix  = prefix;
    _name    = name;
    _version = version;
  } // ctor

  public String ID ()
  {
    if (_prefix.equals (""))
      return "IDL:" + _name + ':' + _version;
    else
      return "IDL:" + _prefix + '/' + _name + ':' + _version;
  } // ID

  public String prefix ()
  {
    return _prefix;
  } // prefix

  void prefix (String prefix)
  {
    if (prefix == null)
      _prefix = "";
    else
      _prefix = prefix;
  } // prefix

  public String name ()
  {
    return _name;
  } // name

  void name (String name)
  {
    if (name == null)
      _name = "";
    else
      _name = name;
  } // name

  public String version ()
  {
    return _version;
  } // version

  void version (String version)
  {
    if (version == null)
      _version = "";
    else
      _version = version;
  } // version

  void appendToName (String name)
  {
    if (name != null)
      if (_name.equals (""))
        _name = name;
      else
        _name = _name + '/' + name;
  } // appendToName

  void replaceName (String name)
  {
    if (name == null)
      _name = "";
    else
    {
      int index = _name.lastIndexOf ('/');
      if (index < 0)
        _name = name;
      else
        _name = _name.substring (0, index + 1) + name;
    }
  } // replaceName

  public Object clone ()
  {
    return new IDLID (_prefix, _name, _version);
  } // clone

  private String _prefix;
  private String _name;
  private String _version;
} // class IDLID
