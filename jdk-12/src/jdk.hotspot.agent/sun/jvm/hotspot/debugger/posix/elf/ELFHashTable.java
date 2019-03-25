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

package sun.jvm.hotspot.debugger.posix.elf;

public interface ELFHashTable {
    /**
     * Returns the ELFSymbol that has the specified name or null if no symbol
     * with that name exists.  NOTE: Currently this method does not work and
     * willl always return null.
     */
    public ELFSymbol getSymbol(String symbolName);
}
