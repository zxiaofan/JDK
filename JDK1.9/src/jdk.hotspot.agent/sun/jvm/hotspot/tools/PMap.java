/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;

public class PMap extends Tool {

   public PMap() {
       super();
   }

   public PMap(JVMDebugger d) {
       super(d);
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
         List l = cdbg.getLoadObjectList();
         for (Iterator itr = l.iterator() ; itr.hasNext();) {
            LoadObject lo = (LoadObject) itr.next();
            out.print(lo.getBase() + "\t");
            out.print(lo.getSize()/1024 + "K\t");
            out.println(lo.getName());
         }
      } else {
          if (getDebugeeType() == DEBUGEE_REMOTE) {
              out.println("remote configuration is not yet implemented");
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
