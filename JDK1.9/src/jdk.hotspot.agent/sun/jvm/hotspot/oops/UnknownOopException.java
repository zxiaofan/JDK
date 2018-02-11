/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

public class UnknownOopException extends RuntimeException {
  public UnknownOopException() {
    super();
  }

  public UnknownOopException(String detail) {
    super(detail);
  }
}
