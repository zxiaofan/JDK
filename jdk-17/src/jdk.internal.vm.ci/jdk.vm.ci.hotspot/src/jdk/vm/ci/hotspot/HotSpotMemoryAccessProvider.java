/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.MemoryAccessProvider;

/**
 * HotSpot specific extension of {@link MemoryAccessProvider}.
 */
public interface HotSpotMemoryAccessProvider extends MemoryAccessProvider {

    /**
     * @throws IllegalArgumentException if the address computed from {@code base} and
     *             {@code displacement} does not denote a location holding a narrow oop
     */
    JavaConstant readNarrowOopConstant(Constant base, long displacement);

    Constant readKlassPointerConstant(Constant base, long displacement);

    Constant readNarrowKlassPointerConstant(Constant base, long displacement);

    Constant readMethodPointerConstant(Constant base, long displacement);
}
