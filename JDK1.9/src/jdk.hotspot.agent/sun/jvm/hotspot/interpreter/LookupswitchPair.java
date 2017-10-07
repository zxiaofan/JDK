/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

public class LookupswitchPair extends Bytecode {
  LookupswitchPair(Method method, int bci) {
    super(method, bci);
  }

  public int match() {
    return javaSignedWordAt(0 * jintSize);
  }

  public int offset() {
    return javaSignedWordAt(1 * jintSize);
  }
}
