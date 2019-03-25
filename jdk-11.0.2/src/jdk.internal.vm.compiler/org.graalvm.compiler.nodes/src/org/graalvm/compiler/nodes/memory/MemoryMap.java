/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.memory;

import jdk.internal.vm.compiler.word.LocationIdentity;

/**
 * Maps a {@linkplain LocationIdentity location} to the last node that (potentially) wrote to the
 * location.
 */
public interface MemoryMap {

    /**
     * Gets the last node that that (potentially) wrote to {@code locationIdentity}.
     */
    MemoryNode getLastLocationAccess(LocationIdentity locationIdentity);

    /**
     * Gets the location identities in the domain of this map.
     */
    Iterable<LocationIdentity> getLocations();
}
