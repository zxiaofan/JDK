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

public class BytecodeRet extends BytecodeWideable {
  BytecodeRet(Method method, int bci) {
    super(method, bci);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check ret");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._ret;
  }

  public static BytecodeRet at(Method method, int bci) {
    BytecodeRet b = new BytecodeRet(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at ret  */
  public static BytecodeRet atCheck(Method method, int bci) {
    BytecodeRet b = new BytecodeRet(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeRet at(BytecodeStream bcs) {
    return new BytecodeRet(bcs.method(), bcs.bci());
  }

  public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append("ret");
    buf.append(spaces);
    buf.append('#');
    buf.append(getLocalVarIndex());
    return buf.toString();
  }
}
