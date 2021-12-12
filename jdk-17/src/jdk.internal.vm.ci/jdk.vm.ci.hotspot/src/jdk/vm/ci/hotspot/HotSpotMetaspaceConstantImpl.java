/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Objects;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.VMConstant;

final class HotSpotMetaspaceConstantImpl implements HotSpotMetaspaceConstant, VMConstant {

    static HotSpotMetaspaceConstantImpl forMetaspaceObject(MetaspaceObject metaspaceObject, boolean compressed) {
        return new HotSpotMetaspaceConstantImpl(metaspaceObject, compressed);
    }

    static MetaspaceObject getMetaspaceObject(Constant constant) {
        return ((HotSpotMetaspaceConstantImpl) constant).metaspaceObject;
    }

    private final MetaspaceObject metaspaceObject;
    private final boolean compressed;

    private HotSpotMetaspaceConstantImpl(MetaspaceObject metaspaceObject, boolean compressed) {
        this.metaspaceObject = metaspaceObject;
        this.compressed = compressed;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(metaspaceObject) ^ (compressed ? 1 : 2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HotSpotMetaspaceConstantImpl)) {
            return false;
        }

        HotSpotMetaspaceConstantImpl other = (HotSpotMetaspaceConstantImpl) o;
        return Objects.equals(this.metaspaceObject, other.metaspaceObject) && this.compressed == other.compressed;
    }

    @Override
    public String toValueString() {
        return String.format("meta{%s%s}", metaspaceObject, compressed ? ";compressed" : "");
    }

    @Override
    public String toString() {
        return toValueString();
    }

    @Override
    public boolean isDefaultForKind() {
        return false;
    }

    @Override
    public boolean isCompressed() {
        return compressed;
    }

    @Override
    public Constant compress() {
        assert !isCompressed();
        HotSpotMetaspaceConstantImpl res = HotSpotMetaspaceConstantImpl.forMetaspaceObject(metaspaceObject, true);
        assert res.isCompressed();
        return res;
    }

    @Override
    public Constant uncompress() {
        assert isCompressed();
        HotSpotMetaspaceConstantImpl res = HotSpotMetaspaceConstantImpl.forMetaspaceObject(metaspaceObject, false);
        assert !res.isCompressed();
        return res;
    }

    @Override
    public HotSpotResolvedObjectType asResolvedJavaType() {
        if (metaspaceObject instanceof HotSpotResolvedObjectType) {
            return (HotSpotResolvedObjectType) metaspaceObject;
        }
        return null;
    }

    @Override
    public HotSpotResolvedJavaMethod asResolvedJavaMethod() {
        if (metaspaceObject instanceof HotSpotResolvedJavaMethod) {
            return (HotSpotResolvedJavaMethod) metaspaceObject;
        }
        return null;
    }
}
