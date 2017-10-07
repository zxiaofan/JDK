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

public class BytecodeJsrW extends BytecodeJmp {
  BytecodeJsrW(Method method, int bci) {
    super(method, bci);
  }

  public int getTargetBCI() {
    return bci() + javaSignedWordAt(1);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check jsr_w");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._jsr_w;
  }

  public static BytecodeJsrW at(Method method, int bci) {
    BytecodeJsrW b = new BytecodeJsrW(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at jsr_w  */
  public static BytecodeJsrW atCheck(Method method, int bci) {
    BytecodeJsrW b = new BytecodeJsrW(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeJsrW at(BytecodeStream bcs) {
    return new BytecodeJsrW(bcs.method(), bcs.bci());
  }
}
