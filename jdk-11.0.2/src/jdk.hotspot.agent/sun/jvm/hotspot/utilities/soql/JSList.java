/*
 * Copyright (c) 2004, 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;
import sun.jvm.hotspot.oops.*;

/**
   This is JavaScript wrapper for Java List.
*/

public class JSList extends DefaultScriptObject {
   public JSList(List list, JSJavaFactory fac) {
      this.list = list;
      this.factory = fac;
   }

   public Object get(String name) {
      if (name.equals("length")) {
         return new Integer(list.size());
      } else {
         return super.get(name);
      }
   }

   public Object get(int index) {
      if (isInRange(index)) {
          Object item = list.get(index);
          return wrapObject(item);
      } else {
          return super.get(index);
      }
   }

   public Object[] getIds() {
      Object[] superIds = super.getIds();
      final int size = list.size();
      Object[] res = new Object[superIds.length + size];
      for (int i = 0; i < size; i++) {
          res[i] = new Integer(i);
      }
      System.arraycopy(superIds, 0, res, size, superIds.length);
      return res;
   }

   public boolean has(String name) {
      if (name.equals("length")) {
         return true;
      } else {
         return super.has(name);
      }
   }

   public boolean has(int index) {
      if (isInRange(index)) {
         return true;
      } else {
         return super.has(index);
      }
   }

   public void put(String name, Object value) {
      if (! name.equals("length")) {
         super.put(name, value);
      }
   }

   public void put(int index, Object value) {
      if (! isInRange(index)) {
         super.put(index, value);
      }
   }

   public String toString() {
       StringBuffer buf = new StringBuffer();
       buf.append('[');
       for (Iterator itr = list.iterator(); itr.hasNext();) {
           buf.append(wrapObject(itr.next()));
           if (itr.hasNext()) {
               buf.append(", ");
           }
       }
       buf.append(']');
       return buf.toString();
   }

   //-- Internals only below this point
   private boolean isInRange(int index) {
      return index >= 0 && index < list.size();
   }

   private Object wrapObject(Object obj) {
      return factory.newJSJavaWrapper(obj);
   }

   private final List list;
   private final JSJavaFactory factory;
}
