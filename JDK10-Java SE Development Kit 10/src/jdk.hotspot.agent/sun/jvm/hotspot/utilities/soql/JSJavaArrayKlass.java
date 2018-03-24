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
   This is JavaScript wrapper for Java ArrayKlass.
*/

public abstract class JSJavaArrayKlass extends JSJavaKlass {
   public JSJavaArrayKlass(ArrayKlass kls, JSJavaFactory fac) {
      super(kls, fac);
   }

   public final ArrayKlass getArrayKlass() {
      return (ArrayKlass) getKlass();
   }

   public Object getMetaClassFieldValue(String name) {
      if (name.equals("dimension")) {
         return new Long(getArrayKlass().getDimension());
      } else {
         return super.getMetaClassFieldValue(name);
      }
   }

   public boolean hasMetaClassField(String name) {
      if (name.equals("dimension")) {
         return true;
      } else {
         return super.hasMetaClassField(name);
      }
   }

   public boolean isArray() {
      return true;
   }

   public String[] getMetaClassFieldNames() {
       String[] superFields = super.getMetaClassFieldNames();
       String[] res = new String[superFields.length + 1];
       System.arraycopy(superFields, 0, res, 0, superFields.length);
       res[superFields.length] = "dimension";
       return res;
   }

   public abstract Object getFieldValue(int index, Array array);
}
