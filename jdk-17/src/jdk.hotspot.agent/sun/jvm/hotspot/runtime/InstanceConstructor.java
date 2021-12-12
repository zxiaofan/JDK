/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.CDebugger;
import sun.jvm.hotspot.debugger.cdbg.ClosestSymbol;
import sun.jvm.hotspot.debugger.cdbg.LoadObject;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.HotSpotTypeDataBase;

/** Given a pointer to some memory return an appropriate wrapper.
 Various subclasses provide different mechanisms for identifying the
 appropriate wrapper. */

abstract public class InstanceConstructor<T> {
  /** Instantiate the most-precisely typed wrapper object available
      for the type of the given Address. If no type in the mapping
      matched the type of the Address, throws a WrongTypeException.
      Returns null for a null address (similar behavior to
      VMObjectFactory). */
  abstract public T instantiateWrapperFor(Address addr) throws WrongTypeException;

  protected WrongTypeException newWrongTypeException(Address addr) {
    String message = "No suitable match for type of address " + addr;
    CDebugger cdbg = VM.getVM().getDebugger().getCDebugger();
    if (cdbg != null) {
      // Most common case: V-table pointer is the first field
      Address vtblPtr = addr.getAddressAt(0);
      LoadObject lo = cdbg.loadObjectContainingPC(vtblPtr);
      if (lo != null) {
        ClosestSymbol symbol = lo.closestSymbolToPC(vtblPtr);
        if (symbol != null) {
          message += " (nearest symbol is " + symbol.getName() + ")";
        }
      }
    }

    return new WrongTypeException(message);
  }
}
