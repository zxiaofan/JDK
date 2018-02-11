/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package com.sun.prism;

/**
 * Interface for receiving notifications about resource factory state changes.
 */
public interface ResourceFactoryListener {

    /**
     * Called when the factory is lost and about to be reset. This may result in some of the vram
     * based resources becoming invalid. The listeners can chose which resources
     * to let go of depending on whether they're based in vram.
     */
    public void factoryReset();

    /**
     * Called when the factory is released. This may result in all resources
     * becoming invalid. The listeners should let go of all resources created
     * from this factory.
     */
    public void factoryReleased();
}
