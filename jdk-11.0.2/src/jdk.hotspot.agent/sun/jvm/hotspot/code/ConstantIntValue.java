/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

/** A ConstantIntValue describes a constant int; i.e., the
    corresponding logical entity is either a source constant or its
    computation has been constant-folded. */

public class ConstantIntValue extends ScopeValue {
  private int value;

  public ConstantIntValue(int value) {
    this.value = value;
  }

  public boolean isConstantInt() {
    return true;
  }

  public int getValue() {
    return value;
  }

  /** Serialization of debugging information */
  ConstantIntValue(DebugInfoReadStream stream) {
    value = stream.readSignedInt();
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
