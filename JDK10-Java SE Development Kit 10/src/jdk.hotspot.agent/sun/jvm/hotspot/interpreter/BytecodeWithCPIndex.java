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

// any bytecode with constant pool index

public abstract class BytecodeWithCPIndex extends Bytecode {
  BytecodeWithCPIndex(Method method, int bci) {
    super(method, bci);
  }

  // the constant pool index for this bytecode
  public int index() {
    if (code() == Bytecodes._invokedynamic) {
      int index = getIndexU4();
      if (ConstantPool.isInvokedynamicIndex(index)) {
        return ConstantPool.decodeInvokedynamicIndex(index);
      } else {
        return index;
      }
    } else {
      return getIndexU2(code(), false);
    }
  }

  protected int indexForFieldOrMethod() {
     ConstantPoolCache cpCache = method().getConstants().getCache();
     // get ConstantPool index from ConstantPoolCacheIndex at given bci
     int cpCacheIndex = index();
     if (cpCache == null) {
        return cpCacheIndex;
     } else {
      return cpCache.getEntryAt((int) (0xFFFF & cpCacheIndex)).getConstantPoolIndex();
     }
  }
}
