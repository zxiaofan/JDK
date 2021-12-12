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

public class BytecodeInstanceOf extends BytecodeWithKlass {
  BytecodeInstanceOf(Method method, int bci) {
    super(method, bci);
  }

  public InstanceKlass getInstanceOfKlass() {
    return (InstanceKlass) getKlass();
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check instanceof");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._instanceof;
  }

  public static BytecodeInstanceOf at(Method method, int bci) {
    BytecodeInstanceOf b = new BytecodeInstanceOf(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at instanceof  */
  public static BytecodeInstanceOf atCheck(Method method, int bci) {
    BytecodeInstanceOf b = new BytecodeInstanceOf(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeInstanceOf at(BytecodeStream bcs) {
    return new BytecodeInstanceOf(bcs.method(), bcs.bci());
  }
}
