/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

public class SOQLException extends Exception {
   public SOQLException(String msg) {
      super(msg);
   }

   public SOQLException(String msg, Throwable cause) {
      super(msg, cause);
   }

   public SOQLException(Throwable cause) {
      super(cause);
   }
}
