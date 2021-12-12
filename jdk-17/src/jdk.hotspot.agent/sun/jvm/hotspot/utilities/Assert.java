/*
 * Copyright (c) 2000, 2010, Oracle and/or its affiliates. All rights reserved.
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

public class Assert {
  public static boolean ASSERTS_ENABLED = true;

  public static void that(boolean test, String message) {
    if (ASSERTS_ENABLED && !test) {
      throw new AssertionFailure(message);
    }
  }
}
