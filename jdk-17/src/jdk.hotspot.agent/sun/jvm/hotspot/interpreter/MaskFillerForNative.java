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
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.*;

/** Helper class for computing oop maps for native methods */

class MaskFillerForNative extends NativeSignatureIterator {
  MaskFillerForNative(Method method, BitMap mask, int maskSize) {
    super(method);
    this.mask = mask;
    this.size = maskSize;
  }

  public void passInt()    { /* ignore */ }
  public void passLong()   { /* ignore */ }
  public void passFloat()  { /* ignore */ }
  public void passDouble() { /* ignore */ }
  public void passObject() { mask.atPut(offset(), true); }

  public void generate() {
    super.iterate();
  }

  //----------------------------------------------------------------------
  // Internals only below this point
  //
  private BitMap mask;
  private int    size;
}
