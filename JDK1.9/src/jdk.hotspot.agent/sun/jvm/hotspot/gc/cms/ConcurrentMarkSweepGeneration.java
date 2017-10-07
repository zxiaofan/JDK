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

package sun.jvm.hotspot.gc.cms;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.gc.shared.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;

public class ConcurrentMarkSweepGeneration extends CardGeneration {
  private static AddressField cmsSpaceField;

  public ConcurrentMarkSweepGeneration(Address addr) {
    super(addr);
  }

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("ConcurrentMarkSweepGeneration");
    cmsSpaceField = type.getAddressField("_cmsSpace");
  }

  // Accessing space
  public CompactibleFreeListSpace cmsSpace() {
    return (CompactibleFreeListSpace) VMObjectFactory.newObject(
                                 CompactibleFreeListSpace.class,
                                 cmsSpaceField.getValue(addr));
  }

  public long capacity()                { return cmsSpace().capacity(); }
  public long used()                    { return cmsSpace().used(); }
  public long free()                    { return cmsSpace().free(); }
  public long contiguousAvailable()     { throw new RuntimeException("not yet implemented"); }
  public boolean contains(Address p)    { return cmsSpace().contains(p); }
  public void spaceIterate(SpaceClosure blk, boolean usedOnly) {
     blk.doSpace(cmsSpace());
  }

  public Generation.Name kind() {
    return Generation.Name.CONCURRENT_MARK_SWEEP;
  }

  public String name() {
    return "concurrent mark-sweep generation";
  }

  public void printOn(PrintStream tty) {
    tty.println(name());
    cmsSpace().printOn(tty);
  }
}
