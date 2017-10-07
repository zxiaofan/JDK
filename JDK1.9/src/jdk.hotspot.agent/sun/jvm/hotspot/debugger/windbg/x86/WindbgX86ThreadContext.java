/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.windbg.x86;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.x86.*;
import sun.jvm.hotspot.debugger.windbg.*;

class WindbgX86ThreadContext extends X86ThreadContext {
  private WindbgDebugger debugger;

  public WindbgX86ThreadContext(WindbgDebugger debugger) {
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
