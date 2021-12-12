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

import java.io.*;
import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ContiguousSpace extends CompactibleSpace implements LiveRegionsProvider {
  private static AddressField topField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("ContiguousSpace");

    topField = type.getAddressField("_top");
  }

  public ContiguousSpace(Address addr) {
    super(addr);
  }

  public Address top() {
    return topField.getValue(addr);
  }

  /** In bytes */
  public long capacity() {
    return end().minus(bottom());
  }

  /** In bytes */
  public long used() {
    return top().minus(bottom());
  }

  /** In bytes */
  public long free() {
    return end().minus(top());
  }

  /** In a contiguous space we have a more obvious bound on what parts
      contain objects. */
  public MemRegion usedRegion() {
    return new MemRegion(bottom(), top());
  }

  /** Returns regions of Space where live objects live */
  public List<MemRegion> getLiveRegions() {
    List<MemRegion> res = new ArrayList<>();
    res.add(new MemRegion(bottom(), top()));
    return res;
  }

  /** Testers */
  public boolean contains(Address p) {
    return (bottom().lessThanOrEqual(p) && top().greaterThan(p));
  }

  public void printOn(PrintStream tty) {
    tty.print(" [" + bottom() + "," +
                top() + "," + end() + ")");
    super.printOn(tty);
  }
}
