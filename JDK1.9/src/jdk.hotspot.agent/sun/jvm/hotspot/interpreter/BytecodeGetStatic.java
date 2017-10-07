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

public class BytecodeGetStatic extends BytecodeGetPut {
  BytecodeGetStatic(Method method, int bci) {
    super(method, bci);
  }

  public boolean isStatic() {
    return true;
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check getstatic");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._getstatic;
  }

  public static BytecodeGetStatic at(Method method, int bci) {
    BytecodeGetStatic b = new BytecodeGetStatic(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at getstatic  */
  public static BytecodeGetStatic atCheck(Method method, int bci) {
    BytecodeGetStatic b = new BytecodeGetStatic(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeGetStatic at(BytecodeStream bcs) {
    return new BytecodeGetStatic(bcs.method(), bcs.bci());
  }
}
