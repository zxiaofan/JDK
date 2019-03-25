/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

public class BytecodeJsr extends BytecodeJmp {
  BytecodeJsr(Method method, int bci) {
    super(method, bci);
  }

  public int getTargetBCI() {
    return bci() + javaShortAt(1);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check jsr");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._jsr;
  }

  public static BytecodeJsr at(Method method, int bci) {
    BytecodeJsr b = new BytecodeJsr(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at jsr  */
  public static BytecodeJsr atCheck(Method method, int bci) {
    BytecodeJsr b = new BytecodeJsr(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeJsr at(BytecodeStream bcs) {
    return new BytecodeJsr(bcs.method(), bcs.bci());
  }
}
