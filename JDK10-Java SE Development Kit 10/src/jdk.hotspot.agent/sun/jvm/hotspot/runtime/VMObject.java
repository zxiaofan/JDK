/*
 * Copyright (c) 2000, 2002, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;

/** This is a base class for all VM runtime objects which wrap
    Addresses. The rationale is that without this in place, every
    class would have to implement equals() and hashCode() with
    boilerplate code, a practice which is inherently error-prone. */

public class VMObject {
  protected Address addr;

  /** All of the objects have this as their constructor's signature
      anyway */
  public VMObject(Address addr) {
    this.addr = addr;
  }

  public String toString() {
    return getClass().getName() + "@" + addr;
  }

  public boolean equals(Object arg) {
    if (arg == null) {
      return false;
    }

    if (!getClass().equals(arg.getClass())) {
      return false;
    }

    VMObject obj = (VMObject) arg;
    if (!addr.equals(obj.addr)) {
      return false;
    }

    return true;
  }

  public int hashCode() {
    return addr.hashCode();
  }

  public Address getAddress() {
    return addr;
  }
}
