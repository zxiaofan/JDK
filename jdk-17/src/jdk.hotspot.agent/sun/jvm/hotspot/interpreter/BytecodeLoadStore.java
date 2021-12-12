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

public abstract class BytecodeLoadStore extends BytecodeWideable {
  BytecodeLoadStore(Method method, int bci) {
    super(method, bci);
  }

  public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append(getJavaBytecodeName());
    buf.append(spaces);
    buf.append('#');
    buf.append(getLocalVarIndex());
    return buf.toString();
  }
}
