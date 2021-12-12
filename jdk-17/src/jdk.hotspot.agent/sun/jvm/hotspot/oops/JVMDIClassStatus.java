/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

// from #defines in jvmdi.h. These are also part of JVMDI spec.
// refer to GetClassStatus method of JVMDI spec.

public interface JVMDIClassStatus {
   public static int VERIFIED    = 0x01;
   public static int PREPARED    = 0x02;
   public static int INITIALIZED = 0x04;
   public static int ERROR       = 0x08;
}
