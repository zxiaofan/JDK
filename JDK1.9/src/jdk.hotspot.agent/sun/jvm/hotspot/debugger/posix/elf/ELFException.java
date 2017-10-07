/*
 * Copyright (c) 2001, 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.posix.elf;

/** Generic exception class for all exceptions which occur in this
    package. Since there is no mechanism built into this library for
    recovering from errors, the best clients can do is display the
    error string. */

public class ELFException extends RuntimeException {
  public ELFException() {
    super();
  }

  public ELFException(String message) {
    super(message);
  }

  public ELFException(Throwable cause) {
    super(cause);
  }

  public ELFException(String message, Throwable cause) {
    super(message, cause);
  }
}
