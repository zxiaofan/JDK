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
import sun.jvm.hotspot.runtime.*;

// getfield, getstatic, putfield or putstatic

public abstract class BytecodeGetPut extends BytecodeWithCPIndex {
  BytecodeGetPut(Method method, int bci) {
    super(method, bci);
  }

  // returns the name of the accessed field
  public Symbol name() {
    ConstantPool cp = method().getConstants();
    return cp.getNameRefAt(index());
  }

  // returns the signature of the accessed field
  public Symbol signature() {
    ConstantPool cp = method().getConstants();
    return cp.getSignatureRefAt(index());
  }

  public Field getField() {
    return method().getConstants().getFieldRefAt(index());
  }

  public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append(getJavaBytecodeName());
    buf.append(spaces);
    buf.append('#');
    buf.append(indexForFieldOrMethod());
    buf.append(" [Field ");
    StringBuffer sigBuf = new StringBuffer();
    new SignatureConverter(signature(), sigBuf).dispatchField();
    buf.append(sigBuf.toString().replace('/', '.'));
    buf.append(spaces);
    buf.append(name().asString());
    buf.append("]");
    if (code() != javaCode()) {
       buf.append(spaces);
       buf.append('[');
       buf.append(getBytecodeName());
       buf.append(']');
    }
    return buf.toString();
  }

  public abstract boolean isStatic();
}
