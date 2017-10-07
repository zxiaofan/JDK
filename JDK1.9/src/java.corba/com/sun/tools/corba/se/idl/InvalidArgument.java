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

/**
 * An invalid argument for the compiler has been encountered.
 **/
public class InvalidArgument extends Exception
{
  /** @param arg the invalid argument. */
  public InvalidArgument (String arg)
  {
    message = Util.getMessage ("InvalidArgument.1", arg) + "\n\n" + Util.getMessage ("usage");
  } // ctor

  public InvalidArgument ()
  {
    message = Util.getMessage ("InvalidArgument.2") + "\n\n" + Util.getMessage ("usage");
  } // ctor

  public String getMessage ()
  {
    return message;
  } // getMessage

  private String message = null;
} // class InvalidArgument
