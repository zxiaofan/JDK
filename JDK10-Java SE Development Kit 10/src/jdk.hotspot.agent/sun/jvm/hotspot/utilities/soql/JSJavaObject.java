/*
 * Copyright (c) 2003, 2007, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.utilities.soql;

import sun.jvm.hotspot.oops.Oop;

/** This is JavaScript wrapper for a Java Object in debuggee.*/

public abstract class JSJavaObject extends DefaultScriptObject {
   public JSJavaObject(Oop oop, JSJavaFactory factory) {
       this.oop = oop;
       this.factory = factory;
   }

   public final Oop getOop() {
       return oop;
   }

   public boolean equals(Object o) {
      if (o == null || !(o instanceof JSJavaObject)) {
         return false;
      }

      JSJavaObject other = (JSJavaObject) o;
      return oop.equals(other.oop);
   }

   public int hashCode() {
      return oop.hashCode();
   }

   public String toString() {
      return "Object " + oop.getHandle().toString();
   }

   private final Oop oop;
   protected final JSJavaFactory factory;
}
