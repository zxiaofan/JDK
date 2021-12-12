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

public class BytecodeStore extends BytecodeLoadStore {
  BytecodeStore(Method method, int bci) {
    super(method, bci);
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check store");
    }
  }

  public boolean isValid() {
    int jcode = javaCode();
    switch (jcode) {
       case Bytecodes._istore:
       case Bytecodes._lstore:
       case Bytecodes._fstore:
       case Bytecodes._dstore:
       case Bytecodes._astore:
          return true;
       default:
          return false;
    }
  }

  public static BytecodeStore at(Method method, int bci) {
    BytecodeStore b = new BytecodeStore(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at store  */
  public static BytecodeStore atCheck(Method method, int bci) {
    BytecodeStore b = new BytecodeStore(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeStore at(BytecodeStream bcs) {
    return new BytecodeStore(bcs.method(), bcs.bci());
  }
}
