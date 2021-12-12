/*
 * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.shared;

import sun.jvm.hotspot.debugger.*;

/** Class CardGeneration is a generation that is covered by a card
    table, and uses a card-size block-offset array to implement
    block_start. */

public abstract class CardGeneration extends Generation {
  public CardGeneration(Address addr) {
    super(addr);
  }

  // FIXME: not sure what I need to expose from here in order to have
  // verification similar to that of the old RememberedSet
}
