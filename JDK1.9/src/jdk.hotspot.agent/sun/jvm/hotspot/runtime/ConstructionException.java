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

package sun.jvm.hotspot.runtime;

public class ConstructionException extends RuntimeException {
  public ConstructionException() {
    super();
  }

  public ConstructionException(String message) {
    super(message);
  }

  public ConstructionException(Throwable e) {
    super(e);
  }

  public ConstructionException(String message, Throwable e) {
    super(message, e);
  }
}
