/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020, Microsoft Corporation. All rights reserved.
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

package sun.jvm.hotspot.debugger.windbg.aarch64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.aarch64.*;
import sun.jvm.hotspot.debugger.windbg.*;

class WindbgAARCH64ThreadContext extends AARCH64ThreadContext {
  private WindbgDebugger debugger;

  public WindbgAARCH64ThreadContext(WindbgDebugger debugger) {
    super();
    this.debugger = debugger;
  }

  public void setRegisterAsAddress(int index, Address value) {
    setRegister(index, debugger.getAddressValue(value));
  }

  public Address getRegisterAsAddress(int index) {
    return debugger.newAddress(getRegister(index));
  }
}
