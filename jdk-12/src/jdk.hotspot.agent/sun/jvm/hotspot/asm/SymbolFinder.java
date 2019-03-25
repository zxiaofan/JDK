/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.asm;

// SymbolFinder gets Symbol for a given address.

public interface SymbolFinder {
   // return address value as hex string if no symbol associated with the given address.
   public String getSymbolFor(long address);
}
