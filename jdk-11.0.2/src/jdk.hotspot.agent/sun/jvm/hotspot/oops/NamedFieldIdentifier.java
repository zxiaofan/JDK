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

package sun.jvm.hotspot.oops;

import java.io.*;

// A NamedFieldIdentifier describes a field in an Oop with a name
public class NamedFieldIdentifier extends FieldIdentifier {

  public NamedFieldIdentifier(String name) {
    this.name = name;
  }

  private String name;

  public String getName() { return name; }

  public void printOn(PrintStream tty) {
    tty.print(" - " + getName() + ":\t");
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (!(obj instanceof NamedFieldIdentifier)) {
      return false;
    }

    return ((NamedFieldIdentifier) obj).getName().equals(name);
  }

  public int hashCode() {
    return name.hashCode();
  }
};
