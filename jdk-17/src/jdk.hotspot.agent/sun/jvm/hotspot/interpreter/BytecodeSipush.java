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

public class BytecodeSipush extends Bytecode {
  BytecodeSipush(Method method, int bci) {
    super(method, bci);
  }

  public short getValue() {
    return javaShortAt(1);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check sipush");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._sipush;
  }

  public static BytecodeSipush at(Method method, int bci) {
    BytecodeSipush b = new BytecodeSipush(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at sipush  */
  public static BytecodeSipush atCheck(Method method, int bci) {
    BytecodeSipush b = new BytecodeSipush(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeSipush at(BytecodeStream bcs) {
    return new BytecodeSipush(bcs.method(), bcs.bci());
  }

  public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append("sipush");
    buf.append(spaces);
    buf.append(getValue());
    return buf.toString();
  }
}
