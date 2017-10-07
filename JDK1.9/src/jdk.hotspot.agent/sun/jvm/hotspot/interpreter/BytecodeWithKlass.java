/*
 * Copyright (c) 2002, 2012, Oracle and/or its affiliates. All rights reserved.
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

public class BytecodeWithKlass extends BytecodeWithCPIndex {
  BytecodeWithKlass(Method method, int bci) {
    super(method, bci);
  }

  protected Klass getKlass() {
    return method().getConstants().getKlassAt(index());
  }

  public Symbol getClassName() {
    ConstantPool.CPSlot obj = method().getConstants().getSlotAt(index());
    if (obj.isUnresolved()) {
      return obj.getSymbol();
    } else {
      return obj.getKlass().getName();
    }
  }

  public String toString() {
    StringBuffer buf = new StringBuffer();
    buf.append(getJavaBytecodeName());
    buf.append(spaces);
    buf.append('#');
    buf.append(Integer.toString(index()));
    buf.append(spaces);
    buf.append("[Class ");
    buf.append(getClassName().asString().replace('/', '.'));
    buf.append(']');
    if (code() != javaCode()) {
       buf.append(spaces);
       buf.append('[');
       buf.append(getBytecodeName());
       buf.append(']');
    }
    return buf.toString();
  }
}
