/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * Represents a constant that was retrieved from a constant pool.
 * Used to keep track of the constant pool slot for the constant.
 */
public final class HotSpotConstantPoolObject extends HotSpotObjectConstantImpl {

    static JavaConstant forObject(HotSpotResolvedObjectType type, int cpi, Object object) {
        return new HotSpotConstantPoolObject(type, cpi, object);
    }

    public static JavaConstant forObject(HotSpotResolvedObjectType type, int cpi, JavaConstant object) {
        return forObject(type, cpi, ((HotSpotObjectConstantImpl)object).object());
    }

    private final HotSpotResolvedObjectType type;
    private final int cpi;

    public HotSpotResolvedObjectType getCpType() { return type; }
    public int getCpi()  { return cpi; }

    HotSpotConstantPoolObject(HotSpotResolvedObjectType type, int cpi, Object object) {
        super(object, false);
        this.type = type;
        this.cpi = cpi;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof HotSpotConstantPoolObject) {
            if (super.equals(o)) {
                HotSpotConstantPoolObject other = (HotSpotConstantPoolObject) o;
                return type == other.type && cpi == other.cpi;
            }
        }
        return false;
    }

    @Override
    public String toValueString() {
        return getCpType().getName() + getCpi();
    }

    @Override
    public String toString() {
        return super.toString() + "@" + toValueString();
    }

}
