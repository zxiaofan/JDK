/*
 * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
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
 *
 */

package jdk.internal.misc;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.nio.channels.FileChannel.MapMode;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

/**
 * JDK-specific map modes implemented in java.base.
 */
public class ExtendedMapMode {

    static final MethodHandle MAP_MODE_CONSTRUCTOR;
    static {
        try {
            PrivilegedExceptionAction<Lookup> pae = () ->
                MethodHandles.privateLookupIn(MapMode.class, MethodHandles.lookup());
            @SuppressWarnings("removal")
            Lookup lookup = AccessController.doPrivileged(pae);
            var methodType = MethodType.methodType(void.class, String.class);
            MAP_MODE_CONSTRUCTOR = lookup.findConstructor(MapMode.class, methodType);
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    public static final MapMode READ_ONLY_SYNC = newMapMode("READ_ONLY_SYNC");

    public static final MapMode READ_WRITE_SYNC = newMapMode("READ_WRITE_SYNC");

    private static MapMode newMapMode(String name) {
        try {
            return (MapMode) MAP_MODE_CONSTRUCTOR.invoke(name);
        } catch (Throwable e) {
            throw new InternalError(e);
        }
    }

    private ExtendedMapMode() { }
}
