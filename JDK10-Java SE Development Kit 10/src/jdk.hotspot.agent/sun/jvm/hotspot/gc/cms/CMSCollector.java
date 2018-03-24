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
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;

public class CMSCollector extends VMObject {
  private static long markBitMapFieldOffset;

  public CMSCollector(Address addr) {
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
    Type type = db.lookupType("CMSCollector");
    markBitMapFieldOffset = type.getField("_markBitMap").getOffset();
  }

  //Accessing mark bitmap
  public CMSBitMap markBitMap() {
   return (CMSBitMap) VMObjectFactory.newObject(
                                CMSBitMap.class,
                                addr.addOffsetTo(markBitMapFieldOffset));
  }

  public long blockSizeUsingPrintezisBits(Address addr) {
    CMSBitMap markBitMap = markBitMap();
    long addressSize = VM.getVM().getAddressSize();
    if ( markBitMap.isMarked(addr) &&  markBitMap.isMarked(addr.addOffsetTo(1*addressSize)) ) {
      Address nextOneAddr = markBitMap.getNextMarkedWordAddress(addr.addOffsetTo(2*addressSize));
      //return size in bytes
      long size =  (nextOneAddr.addOffsetTo(1*addressSize)).minus(addr);
      return size;
    } else {
      //missing Printezis marks
      return -1;
    }

  }
}
