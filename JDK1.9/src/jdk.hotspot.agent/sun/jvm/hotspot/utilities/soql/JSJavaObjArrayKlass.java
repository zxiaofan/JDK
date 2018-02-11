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

import java.util.*;
import sun.jvm.hotspot.oops.*;

/**
   This is JavaScript wrapper for ObjArrayKlass.
*/

public class JSJavaObjArrayKlass extends JSJavaArrayKlass {
   public JSJavaObjArrayKlass(ObjArrayKlass kls, JSJavaFactory fac) {
      super(kls, fac);
   }

   public ObjArrayKlass getObjArrayKlass() {
      return (ObjArrayKlass) getArrayKlass();
   }

   public String getName() {
      Klass botKls = getObjArrayKlass().getBottomKlass();
      int dimension = (int) getObjArrayKlass().getDimension();
      StringBuffer buf = new StringBuffer();
      if (botKls instanceof TypeArrayKlass) {
          dimension--;
      }
      buf.append(factory.newJSJavaKlass(botKls).getName());
      for (int i = 0; i < dimension; i++) {
         buf.append("[]");
      }
      return buf.toString();
   }

   public Object getFieldValue(int index, Array array) {
      Oop obj = ((ObjArray)array).getObjAt(index);
      return factory.newJSJavaObject(obj);
   }
}
