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

package sun.jvm.hotspot.debugger;

import java.io.Serializable;

/** The only reason for this is to not throw UnmappedAddressException
    across readBytesFromProcess() calls; we can't decompose the
    RemoteException precisely enough */

public class ReadResult implements Serializable {
  private byte[] data; // NULL if read failed
  private long   failureAddress;

  /** Successful result */
  public ReadResult(byte[] data) {
    this.data = data;
  }

  /** Unsuccessful result */
  public ReadResult(long failureAddress) {
    this.failureAddress = failureAddress;
  }

  public byte[] getData() {
    return data;
  }

  public long getFailureAddress() {
    return failureAddress;
  }
}
