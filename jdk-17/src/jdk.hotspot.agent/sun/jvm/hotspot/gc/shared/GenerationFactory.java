/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.shared;

import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.gc.serial.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

/** Factory containing a VirtualConstructor suitable for instantiating
    wrapper objects for all types of generations */

public class GenerationFactory {
  private static VirtualConstructor ctor;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    ctor = new VirtualConstructor(db);

    ctor.addMapping("DefNewGeneration", DefNewGeneration.class);
    ctor.addMapping("TenuredGeneration", TenuredGeneration.class);
  }

  public static Generation newObject(Address addr) {
      try {
          return (Generation) ctor.instantiateWrapperFor(addr);
      } catch (WrongTypeException e) {
          return new Generation(addr) {
                  public String name() {
                      return "unknown generation type";
                  }
                  public void spaceIterate(SpaceClosure blk, boolean usedOnly) {
                  }
                  public void liveRegionsIterate(LiveRegionsClosure closure) {
                  }
                  public void printOn(java.io.PrintStream tty) {
                      tty.println("unknown subtype of Generation @ " + getAddress() + " (" +
                                  virtualSpace().low() + "," + virtualSpace().high() + ")");
                  }
                  public long used() {
                      return 0;
                  }
                  public long free() {
                      return 0;
                  }
                  public long capacity() {
                      return 0;
                  }
                  public long contiguousAvailable() {
                      return 0;
                  }

              };
      }
  }
}
