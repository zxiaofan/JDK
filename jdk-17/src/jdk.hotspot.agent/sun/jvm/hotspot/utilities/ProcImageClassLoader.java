/*
 * Copyright (c) 2002, 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.utilities;

import java.io.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.tools.jcore.*;

/**
   Class loader that loads classes from the process/core image
   of the debuggee.
*/

public class ProcImageClassLoader extends ClassLoader {
   public ProcImageClassLoader(ClassLoader parent) {
      super(parent);
   }

   public ProcImageClassLoader() {
      this(Thread.currentThread().getContextClassLoader());
   }

   protected Class findClass(String className) throws ClassNotFoundException {
      try {
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
         InstanceKlass klass = SystemDictionaryHelper.findInstanceKlass(className);
         ClassWriter cw = new ClassWriter(klass, bos);
         cw.write();
         byte[] buf = bos.toByteArray();
         return defineClass(className, buf, 0, buf.length);
      } catch (Exception e) {
         throw (ClassNotFoundException) new ClassNotFoundException().initCause(e);
      }
   }
}
