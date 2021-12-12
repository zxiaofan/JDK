/*
 * Copyright (c) 2001, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

import java.util.*;

import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class ObjectSynchronizer {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type = db.lookupType("ObjectSynchronizer");
    inUseList = type.getAddressField("_in_use_list").getValue();
  }

  public long identityHashValueFor(Oop obj) {
    Mark mark = obj.getMark();
    if (mark.isUnlocked()) {
      // FIXME: can not generate marks in debugging system
      return mark.hash();
    } else if (mark.hasMonitor()) {
      ObjectMonitor monitor = mark.monitor();
      Mark temp = monitor.header();
      return temp.hash();
    } else {
      if (Assert.ASSERTS_ENABLED) {
        Assert.that(VM.getVM().isDebugging(), "Can not access displaced header otherwise");
      }
      if (mark.hasDisplacedMarkHelper()) {
        Mark temp = mark.displacedMarkHelper();
        return temp.hash();
      }
      // FIXME: can not do anything else here in debugging system
      return 0;
    }
  }

  public static Iterator objectMonitorIterator() {
    if (inUseList != null) {
      return new ObjectMonitorIterator();
    } else {
      return null;
    }
  }

  private static class ObjectMonitorIterator implements Iterator {

    // JVMTI raw monitors are not included in _in_use_list and
    // are not returned by this Iterator.

    ObjectMonitorIterator() {
      mon = new ObjectMonitor(inUseList);
    }

    public boolean hasNext() {
      return (mon.nextOM() != null);
    }

    public Object next() {
      // advance to next entry
      Address monAddr = mon.nextOM();
      if (monAddr == null) {
        throw new NoSuchElementException();
      }
      mon = new ObjectMonitor(monAddr);
      return mon;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    private ObjectMonitor mon;
  }

  private static Address inUseList;

}
