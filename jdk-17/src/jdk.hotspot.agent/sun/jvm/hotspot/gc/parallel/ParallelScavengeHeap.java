/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.gc.shared.*;
import sun.jvm.hotspot.memory.MemRegion;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ParallelScavengeHeap extends CollectedHeap {
   static {
      VM.registerVMInitializedObserver(new Observer() {
         public void update(Observable o, Object data) {
            initialize(VM.getVM().getTypeDataBase());
         }
      });
   }

   private static synchronized void initialize(TypeDataBase db) {
      Type type = db.lookupType("ParallelScavengeHeap");
      youngGenField = type.getAddressField("_young_gen");
      oldGenField    = type.getAddressField("_old_gen");
   }

   public ParallelScavengeHeap(Address addr) {
      super(addr);
   }

   // Fields
   private static AddressField youngGenField;
   private static AddressField oldGenField;

   // Accessors
   public PSYoungGen youngGen() {
      return (PSYoungGen) VMObjectFactory.newObject(PSYoungGen.class, youngGenField.getValue());
   }

   public PSOldGen oldGen() {
      return (PSOldGen) VMObjectFactory.newObject(PSOldGen.class, oldGenField.getValue());
   }

   public long capacity() {
      return youngGen().capacity() + oldGen().capacity();
   }

   public long used() {
      return youngGen().used() + oldGen().used();
   }

   public boolean isIn(Address a) {
      if (youngGen().isIn(a)) {
         return true;
      }

      if (oldGen().isIn(a)) {
         return true;
      }

      return false;
   }

   public CollectedHeapName kind() {
      return CollectedHeapName.PARALLEL;
   }

   // Simple wrapper to provide toString() usable for debugging.
   private class LiveRegionProviderImpl implements LiveRegionsProvider {
      private String name;
      private MutableSpace space;

      public LiveRegionProviderImpl(String name, MutableSpace space) {
         this.name = name;
         this.space = space;
      }

      @Override
      public List<MemRegion> getLiveRegions() {
         return space.getLiveRegions();
      }
      @Override
      public String toString() {
         return name;
      }
   }

   public void liveRegionsIterate(LiveRegionsClosure closure) {
      // Add eden space
      closure.doLiveRegions(new LiveRegionProviderImpl("eden", youngGen().edenSpace()));
      // Add from-space but not to-space
      closure.doLiveRegions(new LiveRegionProviderImpl("from", youngGen().fromSpace()));

      closure.doLiveRegions(new LiveRegionProviderImpl("old ", oldGen().objectSpace()));
   }

   public void printOn(PrintStream tty) {
      tty.print("ParallelScavengeHeap [ ");
      youngGen().printOn(tty);
      oldGen().printOn(tty);
      tty.print(" ] ");
   }
}
