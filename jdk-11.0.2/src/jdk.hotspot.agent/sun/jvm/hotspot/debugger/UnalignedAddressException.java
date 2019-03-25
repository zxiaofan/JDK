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

public class UnalignedAddressException extends AddressException {
  public UnalignedAddressException(long addr) {
    super(addr);
  }

  public UnalignedAddressException(String detail, long addr) {
    super(detail, addr);
  }
}
