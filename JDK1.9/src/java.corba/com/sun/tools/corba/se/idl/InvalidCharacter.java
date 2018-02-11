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
// -D62023<daz> Cast char to byte for JDK 1.2 compatability.

import java.io.IOException;

public class InvalidCharacter extends IOException
{
  public InvalidCharacter (String filename, String line, int lineNumber, int pos, char ch)
  {
    String pointer = "^";
    if (pos > 1)
    {
      byte[] bytes = new byte [pos - 1];
      for (int i = 0; i < pos - 1; ++i)
        bytes[i] = (byte)' ';  // <d62023>
      pointer = new String (bytes) + pointer;
    }
    String[] parameters = {filename, Integer.toString (lineNumber), "" + ch, Integer.toString ((int)ch), line, pointer};
    message = Util.getMessage ("InvalidCharacter.1", parameters);
  }

  public String getMessage ()
  {
    return message;
  } // getMessage

  private String message = null;
} // class InvalidCharacter
