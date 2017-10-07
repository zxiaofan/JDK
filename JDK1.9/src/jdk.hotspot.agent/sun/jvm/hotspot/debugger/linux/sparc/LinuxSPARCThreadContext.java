/*
 * Copyright (c) 2006, 2007, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.linux.sparc;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.sparc.*;
import sun.jvm.hotspot.debugger.linux.*;

public class LinuxSPARCThreadContext extends SPARCThreadContext {
  private LinuxDebugger debugger;

  public LinuxSPARCThreadContext(LinuxDebugger debugger) {
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
