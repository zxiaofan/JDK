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

package sun.jvm.hotspot.runtime;

import sun.jvm.hotspot.oops.*;

/** Specialized SignatureIterator: Used to compute the argument size. */

public class ArgumentSizeComputer extends SignatureInfo {
  protected void set(int size, int type)        { if (!isReturnType()) this.size += size; }
  public ArgumentSizeComputer(Symbol signature) { super(signature); }
}
