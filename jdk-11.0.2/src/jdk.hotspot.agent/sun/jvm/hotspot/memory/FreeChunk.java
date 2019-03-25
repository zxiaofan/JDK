/*
 * Copyright (c) 2003, 2009, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;

public class FreeChunk extends VMObject {
   static {
      VM.registerVMInitializedObserver(new Observer() {
         public void update(Observable o, Object data) {
            initialize(VM.getVM().getTypeDataBase());
         }
      });
   }

   private static synchronized void initialize(TypeDataBase db) {
      Type type = db.lookupType("FreeChunk");
      nextField = type.getAddressField("_next");
      prevField = type.getAddressField("_prev");
      sizeField = type.getAddressField("_size");
   }

   // Fields
   private static AddressField nextField;
   private static AddressField prevField;
   private static AddressField sizeField;

   // Accessors
   public FreeChunk next() {
      return (FreeChunk) VMObjectFactory.newObject(FreeChunk.class, nextField.getValue(addr));
   }

   public FreeChunk prev() {
      Address prev = prevField.getValue(addr).andWithMask(~0x3);
      return (FreeChunk) VMObjectFactory.newObject(FreeChunk.class, prev);
   }

   public long size() {
      if (VM.getVM().isCompressedOopsEnabled()) {
        Mark mark = new Mark(addr.addOffsetTo(sizeField.getOffset()));
        return mark.getSize();
      } else {
        Address size = sizeField.getValue(addr);
        Debugger dbg = VM.getVM().getDebugger();
        return dbg.getAddressValue(size);
      }
   }

   public FreeChunk(Address addr) {
      super(addr);
   }

   public static boolean indicatesFreeChunk(Address cur) {
      FreeChunk f = new FreeChunk(cur);
      return f.isFree();
   }

   public boolean isFree() {
      if (VM.getVM().isCompressedOopsEnabled()) {
        Mark mark = new Mark(addr.addOffsetTo(sizeField.getOffset()));
        return mark.isCmsFreeChunk();
      } else {
        Address prev = prevField.getValue(addr);
        Debugger dbg = VM.getVM().getDebugger();
        long word = dbg.getAddressValue(prev);
        return (word & 0x1L) == 0x1L;
      }
   }
}
