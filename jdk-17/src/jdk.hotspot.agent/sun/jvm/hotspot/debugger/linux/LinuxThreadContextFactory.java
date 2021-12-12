/*
 * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.linux;

import java.lang.reflect.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.linux.amd64.*;
import sun.jvm.hotspot.debugger.linux.x86.*;
import sun.jvm.hotspot.debugger.linux.ppc64.*;

class LinuxThreadContextFactory {
   static ThreadContext createThreadContext(LinuxDebugger dbg) {
      String cpu = dbg.getCPU();
      if (cpu.equals("x86")) {
         return new LinuxX86ThreadContext(dbg);
      } else if (cpu.equals("amd64")) {
         return new LinuxAMD64ThreadContext(dbg);
      }  else if (cpu.equals("ppc64")) {
          return new LinuxPPC64ThreadContext(dbg);
      } else  {
        try {
          Class tcc = Class.forName("sun.jvm.hotspot.debugger.linux." +
             cpu.toLowerCase() + ".Linux" + cpu.toUpperCase() +
             "ThreadContext");
          Constructor[] ctcc = tcc.getConstructors();
          return (ThreadContext)ctcc[0].newInstance(dbg);
        } catch (Exception e) {
          throw new RuntimeException("cpu " + cpu + " is not yet supported");
        }
      }
   }
}
