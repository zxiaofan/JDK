/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.remote.x86;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.x86.*;
import sun.jvm.hotspot.debugger.remote.*;

public class RemoteX86ThreadContext extends X86ThreadContext {
  private RemoteDebuggerClient debugger;

  public RemoteX86ThreadContext(RemoteDebuggerClient debugger) {
    super();
    this.debugger = debugger;
  }

  /** This can't be implemented in this class since we would have to
      tie the implementation to, for example, the debugging system */
  public void setRegisterAsAddress(int index, Address value) {
    setRegister(index, debugger.getAddressValue(value));
  }

  /** This can't be implemented in this class since we would have to
      tie the implementation to, for example, the debugging system */
  public Address getRegisterAsAddress(int index) {
    return debugger.newAddress(getRegister(index));
  }
}
