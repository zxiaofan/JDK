/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.ResolvedJavaType;

public abstract class HotSpotResolvedJavaType extends HotSpotJavaType implements ResolvedJavaType {

    HotSpotResolvedJavaType(String name) {
        super(name);
    }

    abstract Class<?> mirror();

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof HotSpotResolvedJavaType)) {
            return false;
        }
        HotSpotResolvedJavaType that = (HotSpotResolvedJavaType) obj;
        return this.mirror().equals(that.mirror());
    }

    @Override
    public final int hashCode() {
        return getName().hashCode();
    }

}
