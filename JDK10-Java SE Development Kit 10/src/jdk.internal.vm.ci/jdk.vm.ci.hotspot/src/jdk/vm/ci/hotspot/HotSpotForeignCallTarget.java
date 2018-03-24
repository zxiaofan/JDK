/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.hotspot;

import jdk.vm.ci.meta.InvokeTarget;

public class HotSpotForeignCallTarget implements InvokeTarget {

    /**
     * The entry point address of this call's target.
     */
    @SuppressFBWarnings(value = "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", justification = "accessed by subclasses")//
    protected long address;

    public HotSpotForeignCallTarget(long address) {
        this.address = address;
    }
}
