/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.debugger.win32.coff;

/** Generic exception class for all exceptions which occur in this
    package. Since there is no mechanism built into this library for
    recovering from errors, the best clients can do is display the
    error string. */

public class COFFException extends RuntimeException {
  public COFFException() {
    super();
  }

  public COFFException(Throwable cause) {
    super(cause);
  }

  public COFFException(String message) {
    super(message);
  }

  public COFFException(String message, Throwable cause) {
    super(message, cause);
  }
}
