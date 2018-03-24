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

public class BytecodePutStatic extends BytecodeGetPut {
  BytecodePutStatic(Method method, int bci) {
    super(method, bci);
  }

  public boolean isStatic() {
    return true;
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check putstatic");
    }
  }

  public boolean isValid() {
    return javaCode() == Bytecodes._putstatic;
  }

  public static BytecodePutStatic at(Method method, int bci) {
    BytecodePutStatic b = new BytecodePutStatic(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at putstatic  */
  public static BytecodePutStatic atCheck(Method method, int bci) {
    BytecodePutStatic b = new BytecodePutStatic(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodePutStatic at(BytecodeStream bcs) {
    return new BytecodePutStatic(bcs.method(), bcs.bci());
  }
}
