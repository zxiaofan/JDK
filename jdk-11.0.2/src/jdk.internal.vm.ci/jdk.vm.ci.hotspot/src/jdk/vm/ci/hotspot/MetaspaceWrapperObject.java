/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
 * A tag interface indicating that this type is a wrapper around a HotSpot metaspace object that
 * requires GC interaction to keep alive.
 *
 * It would preferable if this were the base class containing the pointer but that would require
 * mixins since most of the wrapper types have complex supertype hierarchies.
 */
interface MetaspaceWrapperObject {

    long getMetaspacePointer();

    /**
     * Check if this object is properly registered for metadata tracking. All classes which
     * implement this interface must be registered with the
     * {@link HotSpotJVMCIMetaAccessContext#add} unless they are kept alive through other means.
     * Currently the only type which doesn't require explicit registration is
     * {@link HotSpotResolvedObjectTypeImpl} since it's kept alive by references to the
     * {@link Class}.
     *
     * @return true if this object is properly registered for meta data tracking.
     */
    default boolean isRegistered() {
        return HotSpotJVMCIRuntime.runtime().metaAccessContext.isRegistered(this);
    }
}
