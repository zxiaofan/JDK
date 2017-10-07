/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.cdbg;

public interface AccessControl {
  public static final int NO_PROTECTION = 0;
  public static final int PRIVATE       = 1;
  public static final int PROTECTED     = 2;
  public static final int PUBLIC        = 3;
}
