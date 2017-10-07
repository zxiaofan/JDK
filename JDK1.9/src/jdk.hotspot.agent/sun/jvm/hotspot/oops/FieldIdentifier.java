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

import java.io.*;

// A FieldIdentifier describes a field in an Oop with a name
public class FieldIdentifier {

  public String getName() { return ""; }

  public void printOn(PrintStream tty) {
    tty.print(" - " + getName() + ":\t");
  }

};
