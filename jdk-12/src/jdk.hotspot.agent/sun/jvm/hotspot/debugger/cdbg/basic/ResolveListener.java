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

package sun.jvm.hotspot.debugger.cdbg.basic;

import sun.jvm.hotspot.debugger.cdbg.*;

/** Provides notification about failed resolutions in the debug info
    database without causing the entire resolve operation to fail */
public interface ResolveListener {
  /** Indicates failure to resolve a type within another type */
  public void resolveFailed(Type containingType, LazyType failedResolve, String detail);

  /** Indicates failure to resolve the address of a static field in a
      type */
  public void resolveFailed(Type containingType, String staticFieldName);

  /** Indicates failure to resolve reference to a type from a symbol */
  public void resolveFailed(Sym containingSymbol, LazyType failedResolve, String detail);

  /** Indicates failure to resolve reference from one symbol to
      another (currently occurs only from BlockSyms to other BlockSyms) */
  public void resolveFailed(Sym containingSymbol, LazyBlockSym failedResolve, String detail);
}
