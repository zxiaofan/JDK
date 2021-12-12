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

public class BytecodeGetField extends BytecodeGetPut {
  BytecodeGetField(Method method, int bci) {
    super(method, bci);
  }

  public boolean isStatic() {
    return false;
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check getfield");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._getfield;
  }

  public static BytecodeGetField at(Method method, int bci) {
    BytecodeGetField b = new BytecodeGetField(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at getfield  */
  public static BytecodeGetField atCheck(Method method, int bci) {
    BytecodeGetField b = new BytecodeGetField(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeGetField at(BytecodeStream bcs) {
    return new BytecodeGetField(bcs.method(), bcs.bci());
  }
}
