/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.code.CallingConvention;
import jdk.vm.ci.code.CallingConvention.Type;

public enum HotSpotCallingConventionType implements CallingConvention.Type {
    /**
     * A request for the outgoing argument locations at a call site to Java code.
     */
    JavaCall(true),

    /**
     * A request for the incoming argument locations.
     */
    JavaCallee(false),

    /**
     * A request for the outgoing argument locations at a call site to external native code that
     * complies with the platform ABI.
     */
    NativeCall(true);

    /**
     * Determines if this is a request for the outgoing argument locations at a call site.
     */
    public final boolean out;

    public static final Type[] VALUES = values();

    HotSpotCallingConventionType(boolean out) {
        this.out = out;
    }
}
