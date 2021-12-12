/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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
package sun.jvm.hotspot.debugger.posix;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;
import sun.jvm.hotspot.utilities.memo.*;

/** Provides a simple wrapper around the ELF library which handles
    relocation. */
public abstract class DSO implements LoadObject {

    private String         filename;
    private Address        addr;
    private long           size;

    public DSO(String filename, long size, Address relocation) {
        this.filename = filename;
        this.size = size;
        this.addr = relocation;
    }

    public String getName() {
        return filename;
    }

    public Address getBase() {
        return addr;
    }

    public long getSize() {
        return size;
    }

    public CDebugInfoDataBase getDebugInfoDataBase() throws DebuggerException {
        // FIXME: after stabs parser
        return null;
    }

    public BlockSym debugInfoForPC(Address pc) throws DebuggerException  {
        // FIXME: after stabs parser
        return null;
    }

    public LineNumberInfo lineNumberForPC(Address pc) throws DebuggerException {
        // FIXME: after stabs parser
        return null;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof DSO)) {
           return false;
        }
        DSO other = (DSO)o;
        return getBase().equals(other.getBase());
    }

    public int hashCode() {
        return getBase().hashCode();
    }

    protected abstract Address newAddress(long addr);
    protected abstract long getAddressValue(Address addr);
}
