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

/** A ConstantDoubleValue describes a constant double; i.e., the
    corresponding logical entity is either a source constant or its
    computation has been constant-folded. */

public class ConstantDoubleValue extends ScopeValue {
  private double value;

  public ConstantDoubleValue(double value) {
    this.value = value;
  }

  public boolean isConstantDouble() {
    return true;
  }

  public double getValue() {
    return value;
  }

  /** Serialization of debugging information */
  ConstantDoubleValue(DebugInfoReadStream stream) {
    value = stream.readDouble();
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
