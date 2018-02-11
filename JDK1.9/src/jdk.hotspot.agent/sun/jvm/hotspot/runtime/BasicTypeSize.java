/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

/** Encapsulates the BasicTypeSize enum in globalDefinitions.hpp in
    the VM. */

public class BasicTypeSize {
  private static boolean initialized = false;
  private static int tBooleanSize = 1;
  private static int tCharSize    = 1;
  private static int tFloatSize   = 1;
  private static int tDoubleSize  = 2;
  private static int tByteSize    = 1;
  private static int tShortSize   = 1;
  private static int tIntSize     = 1;
  private static int tLongSize    = 2;
  private static int tObjectSize  = 1;
  private static int tArraySize   = 1;
  private static int tVoidSize    = 0;

  public static int getTBooleanSize() {
    return tBooleanSize;
  }

  public static int getTCharSize() {
    return tCharSize;
  }

  public static int getTFloatSize() {
    return tFloatSize;
  }

  public static int getTDoubleSize() {
    return tDoubleSize;
  }

  public static int getTByteSize() {
    return tByteSize;
  }

  public static int getTShortSize() {
    return tShortSize;
  }

  public static int getTIntSize() {
    return tIntSize;
  }

  public static int getTLongSize() {
    return tLongSize;
  }

  public static int getTObjectSize() {
    return tObjectSize;
  }

  public static int getTArraySize() {
    return tArraySize;
  }

  public static int getTVoidSize() {
    return tVoidSize;
  }
}
