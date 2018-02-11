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

package sun.jvm.hotspot.code;

import java.io.*;

import sun.jvm.hotspot.debugger.*;

/** A ConstantOopReadValue is created by the VM when reading debug
    information */

public class ConstantOopReadValue extends ScopeValue {
  private OopHandle value;

  /** Serialization of debugging information */
  public ConstantOopReadValue(DebugInfoReadStream stream) {
    value = stream.readOopHandle();
  }

  public boolean isConstantOop() {
    return true;
  }

  public OopHandle getValue() {
    return value;
  }

  // FIXME: not yet implementable
  // void write_on(DebugInfoWriteStream* stream);

  // Printing

  public void print() {
    printOn(System.out);
  }

  public void printOn(PrintStream tty) {
    tty.print(value);
  }
}
