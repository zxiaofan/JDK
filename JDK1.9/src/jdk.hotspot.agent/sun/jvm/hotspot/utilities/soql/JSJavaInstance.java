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

import sun.jvm.hotspot.oops.*;

/** This is JavaScript wrapper for Java Instance in debuggee.*/

public class JSJavaInstance extends JSJavaObject {
   public JSJavaInstance(Instance instance, JSJavaFactory fac) {
      super(instance, fac);
      this.type = (JSJavaInstanceKlass) fac.newJSJavaKlass(instance.getKlass());
   }

   public final Instance getInstance() {
       return (Instance) getOop();
   }

   public final JSJavaClass getJSJavaClass() {
       return type.getJSJavaClass();
   }

   public Object get(String name) {
      if (hasField(name)) {
          return getFieldValue(name);
      } else {
          return super.get(name);
      }
   }

   public Object[] getIds() {
      String[] fieldNames = getFieldNames();
      Object[] superFields = super.getIds();
      Object[] res = new Object[fieldNames.length + superFields.length];
      System.arraycopy(fieldNames, 0, res, 0, fieldNames.length);
      System.arraycopy(superFields, 0, res, fieldNames.length, superFields.length);
      return res;
   }

   public boolean has(String name) {
      if (hasField(name)) {
         return true;
      } else {
         return super.has(name);
      }
   }

   public void put(String name, Object value) {
      if (! hasField(name)) {
         super.put(name, value);
      }
   }

   protected Object getFieldValue(String name) {
      try {
         return type.getInstanceFieldValue(name, getInstance());
      } catch (NoSuchFieldException exp) {
         return UNDEFINED;
      }
   }

   protected String[] getFieldNames() {
      return type.getInstanceFieldNames();
   }

   protected boolean hasField(String name) {
      return type.hasInstanceField(name);
   }

   protected final JSJavaInstanceKlass type;
}
