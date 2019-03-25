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
 * This interface marks nodes that access some memory location, and that have an edge to the last
 * node that kills this location.
 */
public interface MemoryAccess {

    LocationIdentity getLocationIdentity();

    MemoryNode getLastLocationAccess();

    /**
     * @param lla the {@link MemoryNode} that represents the last kill of the location
     */
    void setLastLocationAccess(MemoryNode lla);
}
