/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger;

public class NotInHeapException extends AddressException {
  public NotInHeapException(long addr) {
    super(addr);
  }

  public NotInHeapException(String detail, long addr) {
    super(detail, addr);
  }
}
