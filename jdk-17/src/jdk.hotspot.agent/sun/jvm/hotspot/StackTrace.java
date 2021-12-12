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

package sun.jvm.hotspot;

/** Traverses and prints the stack traces for all Java threads in the
    remote VM */
public class StackTrace {
  public static void main(String[] args) {
    // moved to sun.jvm.hotspot.tools package..
    sun.jvm.hotspot.tools.StackTrace.main(args);
  }
}
