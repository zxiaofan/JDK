/*
 * Copyright (c) 2002, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.PrintStream;
import java.util.*;

import sun.jvm.hotspot.debugger.JVMDebugger;
import sun.jvm.hotspot.runtime.*;

public class SysPropsDumper extends Tool {

   public SysPropsDumper() {
      super();
   }

   public SysPropsDumper(JVMDebugger d) {
      super(d);
   }

   public void run() {
      Properties sysProps = VM.getVM().getSystemProperties();
      PrintStream out = System.out;
      if (sysProps != null) {
         Enumeration keys = sysProps.keys();
         while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            out.print(key);
            out.print(" = ");
            out.println(sysProps.get(key));
         }
      } else {
         out.println("System Properties info not available!");
      }
   }

   public static void main(String[] args) {
      SysPropsDumper pd = new SysPropsDumper();
      pd.execute(args);
   }
}
