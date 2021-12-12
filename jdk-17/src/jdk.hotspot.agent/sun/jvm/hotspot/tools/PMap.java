/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.tools;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.debugger.remote.*;
import sun.jvm.hotspot.utilities.PlatformInfo;

public class PMap extends Tool {

   public PMap() {
       super();
   }

   public PMap(JVMDebugger d) {
       super(d);
   }

   public PMap(HotSpotAgent agent) {
       super(agent);
   }

   @Override
   public String getName() {
       return "pmap";
   }

   public void run() {
      run(System.out);
   }

   public void run(PrintStream out) {
      run(out, getAgent().getDebugger());
   }

   public void run(PrintStream out, Debugger dbg) {
      CDebugger cdbg = dbg.getCDebugger();
      if (cdbg != null) {
         List<LoadObject> l = cdbg.getLoadObjectList();
         Iterator<LoadObject> itr = l.iterator();
         if (!itr.hasNext() && PlatformInfo.getOS().equals("darwin")) {
             // If the list is empty, we assume we attached to a process, and on OSX we can only
             // get LoadObjects for a core file.
             out.println("Not available for Mac OS X processes");
             return;
         }
         while (itr.hasNext()) {
            LoadObject lo = itr.next();
            out.print(lo.getBase() + "\t");
            out.print(lo.getSize()/1024 + "K\t");
            out.println(lo.getName());
         }
      } else {
          if (getDebugeeType() == DEBUGEE_REMOTE) {
              out.print(((RemoteDebuggerClient)dbg).execCommandOnServer("pmap", null));
          } else {
              out.println("not yet implemented (debugger does not support CDebugger)!");
          }
      }
   }

   public static void main(String[] args) throws Exception {
      PMap t = new PMap();
      t.execute(args);
   }
}
