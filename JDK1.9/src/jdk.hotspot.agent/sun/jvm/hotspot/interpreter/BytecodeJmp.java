/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

public abstract class BytecodeJmp extends Bytecode {
  BytecodeJmp(Method method, int bci) {
    super(method, bci);
  }

  public abstract int getTargetBCI();

  public String toString() {
    StringBuffer buf = new StringBuffer();
    buf.append(getJavaBytecodeName());
    buf.append(spaces);
    buf.append(Integer.toString(getTargetBCI()));
    return buf.toString();
  }
}
