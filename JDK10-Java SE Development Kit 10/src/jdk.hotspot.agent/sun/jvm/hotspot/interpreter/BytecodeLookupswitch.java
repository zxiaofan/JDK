/*
 * Copyright (c) 2001, 2003, Oracle and/or its affiliates. All rights reserved.
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

public class BytecodeLookupswitch extends Bytecode {
  BytecodeLookupswitch(Method method, int bci) {
    super(method, bci);
  }

  // Attributes
  public int defaultOffset() { return javaSignedWordAt(alignedOffset(1 + 0*jintSize)); }
  public int numberOfPairs() { return javaSignedWordAt(alignedOffset(1 + 1*jintSize)); }
  public LookupswitchPair pairAt(int i) {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(0 <= i && i < numberOfPairs(), "pair index out of bounds");
    }
    return new LookupswitchPair(method, bci + alignedOffset(1 + (1 + i)*2*jintSize));
  }

  public void verify() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isValid(), "check lookupswitch");
    }
  }

  public boolean isValid() {
    boolean result = javaCode() == Bytecodes._lookupswitch;
    if (result == false) return false;
    int i = numberOfPairs() - 1;
    while (i-- > 0) {
      if(pairAt(i).match() > pairAt(i+1).match())
         return false; // unsorted lookup table
    }
    return true;
  }

  public static BytecodeLookupswitch at(Method method, int bci) {
    BytecodeLookupswitch b = new BytecodeLookupswitch(method, bci);
    if (Assert.ASSERTS_ENABLED) {
      b.verify();
    }
    return b;
  }

  /** Like at, but returns null if the BCI is not at lookupswitch  */
  public static BytecodeLookupswitch atCheck(Method method, int bci) {
    BytecodeLookupswitch b = new BytecodeLookupswitch(method, bci);
    return (b.isValid() ? b : null);
  }

  public static BytecodeLookupswitch at(BytecodeStream bcs) {
    return new BytecodeLookupswitch(bcs.method(), bcs.bci());
  }

  public String toString() {
    StringBuffer buf = new StringBuffer();
    buf.append("lookupswitch");
    buf.append(spaces);
    buf.append("default: ");
    buf.append(Integer.toString(bci() + defaultOffset()));
    buf.append(comma);
    int i = numberOfPairs() - 1;
    while (i-- > 0) {
      LookupswitchPair pair = pairAt(i);
      buf.append("case ");
      buf.append(Integer.toString(pair.match()));
      buf.append(':');
      buf.append(Integer.toString(bci() + pair.offset()));
      buf.append(comma);
    }

    return buf.toString();
  }
}
