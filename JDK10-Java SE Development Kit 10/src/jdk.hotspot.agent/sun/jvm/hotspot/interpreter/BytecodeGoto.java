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

public class BytecodeGoto extends BytecodeJmp {
  BytecodeGoto(Method method, int bci) {
    super(method, bci);
  }

  public int getTargetBCI() {
    return bci() + javaShortAt(1);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check goto");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._goto;
  }

  public static BytecodeGoto at(Method method, int bci) {
    BytecodeGoto b = new BytecodeGoto(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at goto  */
  public static BytecodeGoto atCheck(Method method, int bci) {
    BytecodeGoto b = new BytecodeGoto(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeGoto at(BytecodeStream bcs) {
    return new BytecodeGoto(bcs.method(), bcs.bci());
  }
}
