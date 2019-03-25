/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime.ppc64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;

public class PPC64RegisterMap extends RegisterMap {

  /** This is the only public constructor */
  public PPC64RegisterMap(JavaThread thread, boolean updateMap) {
    super(thread, updateMap);
  }

  protected PPC64RegisterMap(RegisterMap map) {
    super(map);
  }

  public Object clone() {
    PPC64RegisterMap retval = new PPC64RegisterMap(this);
    return retval;
  }

  // no PD state to clear or copy:
  protected void clearPD() {}
  protected void initializePD() {}
  protected void initializeFromPD(RegisterMap map) {}
  protected Address getLocationPD(VMReg reg) { return null; }
}
