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

public abstract class BytecodeWideable extends Bytecode {
  BytecodeWideable(Method method, int bci) {
    super(method, bci);
  }

  public boolean isWide() {
    int prevBci = bci() - 1;
    return (prevBci > -1 && method.getBytecodeOrBPAt(prevBci) == Bytecodes._wide);
  }

  // the local variable index
  public int getLocalVarIndex() {
    return (isWide()) ? getIndexU2(code(), true) : getIndexU1();
  }
}
