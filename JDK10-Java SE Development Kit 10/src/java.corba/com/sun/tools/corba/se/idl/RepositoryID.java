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
// -D57110<daz> Add method to verify format (CORBA 2.3).

public class RepositoryID
{
  public RepositoryID ()
  {
    _id = "";
  } // ctor

  public RepositoryID (String id)
  {
    _id = id;
  } // ctor

  public String ID ()
  {
    return _id;
  } // ID

  public Object clone ()
  {
    return new RepositoryID (_id);
  } // clone

  public String toString ()
  {
    return ID ();
  } // toString

  /**
   * Determine is a supplied string meets the minimal format requirement
   * for a Repository ID.
   * @return true if supplied string has form {@code '<format>:<string>'}, where
   * {@code <format>} is any non-empty string not containing ':'.
   **/
  public static boolean hasValidForm (String string)
  {
    return string != null && string.indexOf (':') > 0;
  } // hasValidForm

  private String _id;
} // class RepositoryID
