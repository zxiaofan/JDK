/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020, NTT DATA.
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

package sun.jvm.hotspot.code;

import sun.jvm.hotspot.debugger.Address;

public class VtableBlob extends BufferBlob {

    public VtableBlob(Address addr) {
        super(addr);
    }

    public boolean isVtableBlob() {
        return true;
    }

    public String getName() {
        return "VtableBlob: " + super.getName();
    }

}
