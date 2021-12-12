/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * A tag interface indicating that this type is a handledized wrapper around a HotSpot metaspace
 * object that requires GC interaction to keep alive.
 *
 * It would preferable if this were the base class containing the pointer but that would require
 * mixins since most of the wrapper types have complex supertype hierarchies.
 */
interface MetaspaceHandleObject extends MetaspaceObject {

    long getMetadataHandle();

    @Override
    default long getMetaspacePointer() {
        return UnsafeAccess.UNSAFE.getLong(getMetadataHandle());
    }
}
