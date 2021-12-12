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

package sun.jvm.hotspot.memory;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class HeapBlock extends VMObject {
  private static long          heapBlockSize;
  private static Field         headerField;
  // Fields for class Header
  private static CIntegerField headerLengthField;
  private static CIntegerField headerUsedField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static void initialize(TypeDataBase db) {
    // HeapBlock
    Type type = db.lookupType("HeapBlock");
    heapBlockSize     = type.getSize();
    headerField       = type.getField("_header");

    // Header
    type = db.lookupType("HeapBlock::Header");
    headerLengthField = type.getCIntegerField("_length");
    headerUsedField   = type.getCIntegerField("_used");
  }

  public HeapBlock(Address addr) {
    super(addr);
  }

  public long getLength() {
    return getHeader().getLength();
  }

  public boolean isFree() {
    return getHeader().isFree();
  }

  public Address getAllocatedSpace() {
    return addr.addOffsetTo(heapBlockSize);
  }

  //--------------------------------------------------------------------------------
  // Internals only below this point
  //

  public static class Header extends VMObject {
    public Header(Address addr) {
      super(addr);
    }

    public long getLength() {
      return headerLengthField.getValue(addr);
    }

    public boolean isFree() {
      return (headerUsedField.getValue(addr) == 0);
    }
  }

  private Header getHeader() {
    return (Header) VMObjectFactory.newObject(HeapBlock.Header.class, addr.addOffsetTo(headerField.getOffset()));
  }
}
