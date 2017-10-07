/*
 * Copyright (c) 2001, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime.x86;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;

public class X86RegisterMap extends RegisterMap {

  /** This is the only public constructor */
  public X86RegisterMap(JavaThread thread, boolean updateMap) {
    super(thread, updateMap);
  }

  protected X86RegisterMap(RegisterMap map) {
    super(map);
  }

  public Object clone() {
    X86RegisterMap retval = new X86RegisterMap(this);
    return retval;
  }

  // no PD state to clear or copy:
  protected void clearPD() {}
  protected void initializePD() {}
  protected void initializeFromPD(RegisterMap map) {}
  protected Address getLocationPD(VMReg reg) { return null; }
}
