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

public class BytecodeNew extends BytecodeWithKlass {
  BytecodeNew(Method method, int bci) {
    super(method, bci);
  }

  public InstanceKlass getNewKlass() {
    return (InstanceKlass) getKlass();
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check new");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._new;
  }

  public static BytecodeNew at(Method method, int bci) {
    BytecodeNew b = new BytecodeNew(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at new  */
  public static BytecodeNew atCheck(Method method, int bci) {
    BytecodeNew b = new BytecodeNew(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeNew at(BytecodeStream bcs) {
    return new BytecodeNew(bcs.method(), bcs.bci());
  }
}
