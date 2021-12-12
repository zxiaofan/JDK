/*
 * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.interpreter;

import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.utilities.*;

public class BytecodeBipush extends Bytecode {
  BytecodeBipush(Method method, int bci) {
    super(method, bci);
  }

  public byte getValue() {
    return javaByteAt(1);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check bipush");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._bipush;
  }

  public static BytecodeBipush at(Method method, int bci) {
    BytecodeBipush b = new BytecodeBipush(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at bipush  */
  public static BytecodeBipush atCheck(Method method, int bci) {
    BytecodeBipush b = new BytecodeBipush(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeBipush at(BytecodeStream bcs) {
    return new BytecodeBipush(bcs.method(), bcs.bci());
  }

  public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append("bipush");
    buf.append(spaces);
    buf.append(getValue());
    return buf.toString();
  }
}
