/*
 * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Describes a VM flag exposed via {@link HotSpotVMConfigAccess}.
 */
public final class VMFlag {

    /**
     * The name of the flag.
     */
    public final String name;

    /**
     * The C++ type of the flag.
     */
    public final String type;

    /**
     * The flag's value.
     */
    public final Object value;

    @VMEntryPoint
    VMFlag(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Flag[type=%s, name=%s, value=%s]", type, name, value);
    }
}
