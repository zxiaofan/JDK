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

/** A ConstantLongValue describes a constant long; i.e., the
    corresponding logical entity is either a source constant or its
    computation has been constant-folded. */

public class ConstantLongValue extends ScopeValue {
  private long value;

  public ConstantLongValue(long value) {
    this.value = value;
  }

  public boolean isConstantLong() {
    return true;
  }

  public long getValue() {
    return value;
  }

  /** Serialization of debugging information */
  ConstantLongValue(DebugInfoReadStream stream) {
    value = stream.readLong();
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
