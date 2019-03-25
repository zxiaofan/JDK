/*
 * Copyright (c) 2000, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.compiler;

import sun.jvm.hotspot.debugger.*;

/** Adaptation of the oop visitation mechanism to Java. */

public interface OopMapVisitor {
  public void visitOopLocation(Address oopAddr);
  public void visitDerivedOopLocation(Address baseOopAddr, Address derivedOopAddr);
  public void visitNarrowOopLocation(Address narrowOopAddr);
}
