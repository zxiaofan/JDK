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

package sun.jvm.hotspot.gc.parallel;

import java.io.*;
import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class MutableSpace extends VMObject {
   static {
      VM.registerVMInitializedObserver(new Observer() {
         public void update(Observable o, Object data) {
            initialize(VM.getVM().getTypeDataBase());
         }
      });
   }

   private static synchronized void initialize(TypeDataBase db) {
      Type type = db.lookupType("MutableSpace");
      bottomField = type.getAddressField("_bottom");
      endField    = type.getAddressField("_end");
      topField    = type.getAddressField("_top");
   }

   public MutableSpace(Address addr) {
      super(addr);
   }

   // Fields
   private static AddressField bottomField;
   private static AddressField endField;
   private static AddressField topField;

   // Accessors
   public Address   bottom()       { return bottomField.getValue(addr); }
   public Address   end()          { return endField.getValue(addr);    }
   public Address   top()          { return topField.getValue(addr);    }

   /** In bytes */
   public long used() {
      return top().minus(bottom());
   }

   /** Returned value is in bytes */
   public long capacity() { return end().minus(bottom()); }

   /** Returns a subregion of the space containing all the objects in
      the space. */
   public MemRegion usedRegion() {
      return new MemRegion(bottom(), end());
   }

   /** Support for iteration over heap -- not sure how this will
      interact with GC in reflective system, but necessary for the
      debugging mechanism */
   public OopHandle bottomAsOopHandle() {
      return bottomField.getOopHandle(addr);
   }

   /** returns all MemRegions where live objects are */
   public List<MemRegion> getLiveRegions() {
      List<MemRegion> res = new ArrayList<>();
      res.add(new MemRegion(bottom(), top()));
      return res;
   }

   /** Testers */
   public boolean contains(Address p) {
      return (bottom().lessThanOrEqual(p) && end().greaterThan(p));
   }

   public void print() { printOn(System.out); }
   public void printOn(PrintStream tty) {
      tty.print(" [" + bottom() + "," +
                top() + "," + end() + "] ");
   }
}
