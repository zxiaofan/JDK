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
   This is JavaScript wrapper for a Map.
*/

public class JSMap extends DefaultScriptObject {
   public JSMap(Map map, JSJavaFactory fac) {
      this.map = map;
      this.factory = fac;
   }

   public Object get(String name) {
      if (map.containsKey(name)) {
         return wrapObject(map.get(name));
      } else {
         return super.get(name);
      }
   }

   public Object[] getIds() {
      Object[] superIds = super.getIds();
      Object[] tmp = map.keySet().toArray();
      Object[] res = new Object[superIds.length + tmp.length];
      System.arraycopy(tmp, 0, res, 0, tmp.length);
      System.arraycopy(superIds, 0, res, tmp.length, superIds.length);
      return res;
   }

   public boolean has(String name) {
      if (map.containsKey(name)) {
         return true;
      } else {
         return super.has(name);
      }
   }

   public void put(String name, Object value) {
      if (! map.containsKey(name)) {
         super.put(name, value);
      }
   }

   public String toString() {
       StringBuffer buf = new StringBuffer();
       Set keys = map.keySet();
       buf.append('{');
       for (Iterator itr = keys.iterator(); itr.hasNext();) {
           Object key = itr.next();
           buf.append(key);
           buf.append('=');
           buf.append(wrapObject(map.get(key)));
           if (itr.hasNext()) {
              buf.append(", ");
           }
      }
      buf.append('}');
      return buf.toString();
   }

   private Object wrapObject(Object obj) {
      return factory.newJSJavaWrapper(obj);
   }

   private final Map map;
   private final JSJavaFactory factory;
}
