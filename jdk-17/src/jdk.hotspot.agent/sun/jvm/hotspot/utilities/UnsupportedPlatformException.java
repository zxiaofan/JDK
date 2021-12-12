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

package sun.jvm.hotspot.utilities;

public class UnsupportedPlatformException extends RuntimeException {
  public UnsupportedPlatformException() {
    super();
  }

  public UnsupportedPlatformException(String message) {
    super(message);
  }
}
