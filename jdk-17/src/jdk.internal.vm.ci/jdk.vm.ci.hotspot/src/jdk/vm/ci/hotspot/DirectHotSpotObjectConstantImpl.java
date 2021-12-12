/*
 * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
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

final class DirectHotSpotObjectConstantImpl extends HotSpotObjectConstantImpl {

    static JavaConstant forObject(Object object, boolean compressed) {
        if (object == null) {
            return compressed ? HotSpotCompressedNullConstant.COMPRESSED_NULL : JavaConstant.NULL_POINTER;
        } else {
            return new DirectHotSpotObjectConstantImpl(object, compressed);
        }
    }

    static HotSpotObjectConstantImpl forNonNullObject(Object object, boolean compressed) {
        if (object == null) {
            throw new NullPointerException();
        }
        return new DirectHotSpotObjectConstantImpl(object, compressed);
    }

    private DirectHotSpotObjectConstantImpl(Object object, boolean compressed) {
        super(compressed);
        assert object != null;
        this.object = object;
    }

    final Object object;

    @Override
    public JavaConstant compress() {
        assert !compressed;
        return new DirectHotSpotObjectConstantImpl(object, true);
    }

    @Override
    public JavaConstant uncompress() {
        assert compressed;
        return new DirectHotSpotObjectConstantImpl(object, false);
    }

    @Override
    public int getIdentityHashCode() {
        return System.identityHashCode(object);
    }
}
