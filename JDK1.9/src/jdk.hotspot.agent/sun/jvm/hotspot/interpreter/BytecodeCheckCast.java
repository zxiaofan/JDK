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

public class BytecodeCheckCast extends BytecodeWithKlass {
  BytecodeCheckCast(Method method, int bci) {
    super(method, bci);
  }

  public InstanceKlass getCheckCastKlass() {
    return (InstanceKlass) getKlass();
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check checkcast");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._checkcast;
  }

  public static BytecodeCheckCast at(Method method, int bci) {
    BytecodeCheckCast b = new BytecodeCheckCast(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at checkcast  */
  public static BytecodeCheckCast atCheck(Method method, int bci) {
    BytecodeCheckCast b = new BytecodeCheckCast(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeCheckCast at(BytecodeStream bcs) {
    return new BytecodeCheckCast(bcs.method(), bcs.bci());
  }
}
