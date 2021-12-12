/*
 * Copyright (c) 2017, Red Hat, Inc. and/or its affiliates.
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

package sun.jvm.hotspot.gc.epsilon;

import java.io.*;
import java.util.*;

import sun.jvm.hotspot.gc.shared.*;
import sun.jvm.hotspot.code.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class EpsilonHeap extends CollectedHeap {

  private static AddressField spaceField;
  private static Field virtualSpaceField;
  private ContiguousSpace space;
  private VirtualSpace virtualSpace;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static void initialize(TypeDataBase db) {
    Type type = db.lookupType("EpsilonHeap");
    spaceField = type.getAddressField("_space");
    virtualSpaceField = type.getField("_virtual_space");
  }

  public EpsilonHeap(Address addr) {
    super(addr);
    space = new ContiguousSpace(spaceField.getValue(addr));
    virtualSpace = new VirtualSpace(addr.addOffsetTo(virtualSpaceField.getOffset()));
  }

  @Override
  public CollectedHeapName kind() {
    return CollectedHeapName.EPSILON;
  }

  @Override
  public long capacity() {
    return space.capacity();
  }

  @Override
  public long used() {
    return space.used();
  }

  public ContiguousSpace space() {
    return space;
  }

  @Override
  public void liveRegionsIterate(LiveRegionsClosure closure) {
    closure.doLiveRegions(space());
  }

  @Override
  public void printOn(PrintStream tty) {
     MemRegion mr = reservedRegion();
     tty.println("Epsilon heap");
     tty.println(" reserved:  [" + mr.start() + ", " + mr.end() + "]");
     tty.println(" committed: [" + virtualSpace.low() + ", " + virtualSpace.high() + "]");
     tty.println(" used:      [" + space.bottom() + ", " + space.top() + "]");
  }

}
