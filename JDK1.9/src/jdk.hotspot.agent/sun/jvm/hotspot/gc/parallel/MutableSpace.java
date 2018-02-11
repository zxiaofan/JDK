/*
 * Copyright (c) 2003, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.parallel;

import java.io.*;
import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;

public class MutableSpace extends ImmutableSpace {
   static {
      VM.registerVMInitializedObserver(new Observer() {
         public void update(Observable o, Object data) {
            initialize(VM.getVM().getTypeDataBase());
         }
      });
   }

   private static synchronized void initialize(TypeDataBase db) {
      Type type = db.lookupType("MutableSpace");
      topField    = type.getAddressField("_top");
   }

   public MutableSpace(Address addr) {
      super(addr);
   }

   // Fields
   private static AddressField topField;

   // Accessors
   public Address   top()          { return topField.getValue(addr);    }

   /** In bytes */
   public long used() {
      return top().minus(bottom());
   }

   /** returns all MemRegions where live objects are */
   public List/*<MemRegion>*/ getLiveRegions() {
      List res = new ArrayList();
      res.add(new MemRegion(bottom(), top()));
      return res;
   }

   public void printOn(PrintStream tty) {
      tty.print(" [" + bottom() + "," +
                top() + "," + end() + "] ");
   }
}
