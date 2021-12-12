/*
 * Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.
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

public class AddressException extends RuntimeException {
  private long addr;

  public AddressException(long addr) {
    this.addr = addr;
  }

  public AddressException(String detail, long addr) {
    super(detail);
    this.addr = addr;
  }

  public long getAddress() {
    return addr;
  }

  public String getMessage() {
    return Long.toHexString(addr);
  }
}
