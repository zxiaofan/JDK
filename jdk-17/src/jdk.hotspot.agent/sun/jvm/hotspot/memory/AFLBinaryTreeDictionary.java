/*
 * @(#)BinaryTreeDictionary.java
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
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class AFLBinaryTreeDictionary extends VMObject {
   static {
      VM.registerVMInitializedObserver(new Observer() {
         public void update(Observable o, Object data) {
            initialize(VM.getVM().getTypeDataBase());
         }
      });
   }

   private static synchronized void initialize(TypeDataBase db) {
      Type type = db.lookupType("AFLBinaryTreeDictionary");
      totalSizeField = type.getCIntegerField("_total_size");
   }

   // Fields
   private static CIntegerField totalSizeField;

   // Accessors
   public long size() {
      return totalSizeField.getValue(addr);
   }

   // Constructor
   public AFLBinaryTreeDictionary(Address addr) {
      super(addr);
   }
}
