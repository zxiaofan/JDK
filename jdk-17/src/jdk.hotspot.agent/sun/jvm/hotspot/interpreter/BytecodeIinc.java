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

public class BytecodeIinc extends BytecodeWideable {
  BytecodeIinc(Method method, int bci) {
    super(method, bci);
  }

  public int getIncrement() {
    // increment is signed
    return (isWide()) ? (int) javaShortAt(3) : (int) javaByteAt(2);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check iinc");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._iinc;
  }

  public static BytecodeIinc at(Method method, int bci) {
    BytecodeIinc b = new BytecodeIinc(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at iinc  */
  public static BytecodeIinc atCheck(Method method, int bci) {
    BytecodeIinc b = new BytecodeIinc(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeIinc at(BytecodeStream bcs) {
    return new BytecodeIinc(bcs.method(), bcs.bci());
  }

  public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append("iinc");
    buf.append(spaces);
    buf.append('#');
    buf.append(getLocalVarIndex());
    buf.append(" by ");
    buf.append(getIncrement());
    return buf.toString();
  }
}
