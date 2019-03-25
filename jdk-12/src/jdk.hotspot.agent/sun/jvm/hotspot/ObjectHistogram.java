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

/** A sample tool which uses the Serviceability Agent's APIs to obtain
    an object histogram from a remote or crashed VM. */
public class ObjectHistogram {
  public static void main(String[] args) {
     // moved to sun.jvm.hotspot.tools package..
     sun.jvm.hotspot.tools.ObjectHistogram.main(args);
  }
}
