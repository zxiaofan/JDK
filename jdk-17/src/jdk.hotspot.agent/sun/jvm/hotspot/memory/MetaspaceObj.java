/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.memory;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class MetaspaceObj {
  private static Address sharedMetaspaceBaseAddr;
  private static Address sharedMetaspaceTopAddr;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("MetaspaceObj");
    sharedMetaspaceBaseAddr = type.getAddressField("_shared_metaspace_base").getStaticFieldAddress();
    sharedMetaspaceTopAddr  = type.getAddressField("_shared_metaspace_top").getStaticFieldAddress();
  }

  public static boolean isShared(Address addr) {
    Address base = sharedMetaspaceBaseAddr.getAddressAt(0);
    Address top  = sharedMetaspaceTopAddr. getAddressAt(0);

    return base.lessThanOrEqual(addr) && addr.lessThan(top);
  }
}
