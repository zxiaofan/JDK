/*
 * Copyright (c) 2002, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.bsd;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.bsd.amd64.*;
import sun.jvm.hotspot.debugger.bsd.x86.*;

class BsdThreadContextFactory {
   static ThreadContext createThreadContext(BsdDebugger dbg) {
      String cpu = dbg.getCPU();
      if (cpu.equals("x86")) {
         return new BsdX86ThreadContext(dbg);
      } else if (cpu.equals("amd64") || cpu.equals("x86_64")) {
         return new BsdAMD64ThreadContext(dbg);
      } else {
         throw new RuntimeException("cpu " + cpu + " is not yet supported");
      }
   }
}
