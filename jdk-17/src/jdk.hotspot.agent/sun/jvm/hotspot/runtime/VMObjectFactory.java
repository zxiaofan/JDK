/*
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

package sun.jvm.hotspot.runtime;

import java.lang.reflect.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;

/** <P> This class implements a factory mechanism for the objects
    created to wrap Addresses. It requires that the class passed in
    implement a constructor taking with the following signature: </P>

    <P>
    <CODE> public &lt;Type&gt;(sun.jvm.hotspot.Address)
    </CODE>
    </P>

    <P> It is used to write shorter code when wrapping Addresses since
    null checks are no longer necessary. In addition, it is a central
    location where a canonicalizing map could be implemented if one
    were desired (though the current system is designed to not require
    one.) </P>
*/

public class VMObjectFactory<T extends VMObject> {
  public static <T> T newObject(Class<T> clazz, Address addr)
    throws ConstructionException {
    try {
      if (addr == null) {
        return null;
      }

      Constructor<T> c = clazz.getConstructor(new Class[] {
        Address.class
      });
      return c.newInstance(new Object[] { addr });
    }
    catch (java.lang.reflect.InvocationTargetException ite) {
        if (ite.getCause() instanceof RuntimeException) {
            throw (RuntimeException)ite.getCause();
        }
        throw new ConstructionException(ite);
    }
    catch (Exception e) {
      throw new ConstructionException(e);
    }
  }
}
