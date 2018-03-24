/*
 * Copyright (c) 2007, 2015, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;

public class CMSBitMap extends VMObject {
  private static AddressField bmStartWordField;
  private static CIntegerField bmWordSizeField;
  private static CIntegerField shifterField;
  //private static AddressField bmField;
  private static long virtualSpaceFieldOffset;

  public CMSBitMap(Address addr) {
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
    Type type = db.lookupType("CMSBitMap");
    bmStartWordField = type.getAddressField("_bmStartWord");
    bmWordSizeField = type.getCIntegerField("_bmWordSize");
    shifterField = type.getCIntegerField("_shifter");
    //bmField = type.getAddressField("_bm");
    virtualSpaceFieldOffset = type.getField("_virtual_space").getOffset();
  }
  public void printAll() {
    System.out.println("bmStartWord(): "+bmStartWord());
    System.out.println("bmWordSize(): "+bmWordSize());
    System.out.println("shifter(): "+shifter());
  }

  public Address bmStartWord() {
    return bmStartWordField.getValue(addr);
  }
  public long bmWordSize() {
    return bmWordSizeField.getValue(addr);
  }
  public long shifter() {
    return shifterField.getValue(addr);
  }
  public VirtualSpace virtualSpace() {
    return (VirtualSpace) VMObjectFactory.newObject(VirtualSpace.class, addr.addOffsetTo(virtualSpaceFieldOffset));
  }

  public BitMap bm() {
    BitMap bitMap = new BitMap((int) (bmWordSize() >> shifter() ));
    VirtualSpace vs = virtualSpace();
    bitMap.set_map(vs.low());
    return bitMap;
  }

  public Address getNextMarkedWordAddress(Address addr) {
    Address endWord = bmStartWord().addOffsetTo(bmWordSize());
    int nextOffset = bm().getNextOneOffset(heapWordToOffset(addr), heapWordToOffset(endWord) );
    Address nextAddr = offsetToHeapWord(nextOffset);
    return nextAddr;
  }

  int heapWordToOffset(Address addr) {
    int temp = (int)addr.minus(bmStartWord()) / (int) VM.getVM().getAddressSize();
    int ret_val = temp >> shifter();
    return ret_val;
  }

  Address offsetToHeapWord(int offset) {
    int temp = offset << shifter();
    return bmStartWord().addOffsetTo(temp*VM.getVM().getAddressSize());
  }

  boolean isMarked(Address addr) {
    BitMap bm = bm();
    return bm.at(heapWordToOffset(addr));
  }
}
