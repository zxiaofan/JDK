/*
 * Copyright (c) 2017, Red Hat, Inc. and/or its affiliates.
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

package sun.jvm.hotspot.gc.cms;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.gc.shared.GenCollectedHeap;
import sun.jvm.hotspot.gc.shared.CollectedHeapName;

public class CMSHeap extends GenCollectedHeap {

  public CMSHeap(Address addr) {
    super(addr);
  }

  public CollectedHeapName kind() {
    return CollectedHeapName.CMS;
  }
}
