/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger;

public class DebuggerException extends RuntimeException {
  public DebuggerException() {
    super();
  }

  public DebuggerException(String message) {
    super(message);
  }

  public DebuggerException(String message, Throwable cause) {
    super(message, cause);
  }

  public DebuggerException(Throwable cause) {
    super(cause);
  }
}
