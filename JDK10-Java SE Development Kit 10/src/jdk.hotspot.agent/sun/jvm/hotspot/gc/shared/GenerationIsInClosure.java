/*
 * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.shared;

import sun.jvm.hotspot.debugger.*;

/** Should only be used once */

class GenerationIsInClosure implements SpaceClosure {
  private Address p;
  private Space sp;

  GenerationIsInClosure(Address p) {
    this.p = p;
  }

  public void doSpace(Space s) {
    if (s.contains(p)) {
      sp = s;
    }
  }

  Space space() {
    return sp;
  }
}
