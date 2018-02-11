/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Arrays;

import jdk.vm.ci.code.Location;
import jdk.vm.ci.code.ReferenceMap;

/**
 * Describes where the object references are in machine state, compliant with what HotSpot expects.
 */
public final class HotSpotReferenceMap extends ReferenceMap {

    private final Location[] objects;
    private final Location[] derivedBase;
    private final int[] sizeInBytes;
    private final int maxRegisterSize;

    /**
     *
     * @param objects This array is now owned by this object and must not be mutated by the caller.
     * @param derivedBase This array is now owned by this object and must not be mutated by the
     *            caller.
     * @param sizeInBytes This array is now owned by this object and must not be mutated by the
     *            caller.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "caller transfers ownership of `objects`, `derivedBase` and `sizeInBytes`")
    public HotSpotReferenceMap(Location[] objects, Location[] derivedBase, int[] sizeInBytes, int maxRegisterSize) {
        this.objects = objects;
        this.derivedBase = derivedBase;
        this.sizeInBytes = sizeInBytes;
        this.maxRegisterSize = maxRegisterSize;
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HotSpotReferenceMap) {
            HotSpotReferenceMap that = (HotSpotReferenceMap) obj;
            if (sizeInBytes == that.sizeInBytes && maxRegisterSize == that.maxRegisterSize && Arrays.equals(objects, that.objects) && Arrays.equals(derivedBase, that.derivedBase)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(objects);
    }
}
