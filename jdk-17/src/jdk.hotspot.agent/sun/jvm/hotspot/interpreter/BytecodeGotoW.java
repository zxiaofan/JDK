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

public class BytecodeGotoW extends BytecodeJmp {
  BytecodeGotoW(Method method, int bci) {
    super(method, bci);
  }

  public int getTargetBCI() {
    return bci() + javaSignedWordAt(1);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check goto_w");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._goto_w;
  }

  public static BytecodeGotoW at(Method method, int bci) {
    BytecodeGotoW b = new BytecodeGotoW(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at goto_w  */
  public static BytecodeGotoW atCheck(Method method, int bci) {
    BytecodeGotoW b = new BytecodeGotoW(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeGotoW at(BytecodeStream bcs) {
    return new BytecodeGotoW(bcs.method(), bcs.bci());
  }
}
