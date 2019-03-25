/*
 * Copyright (c) 2003, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d;

import sun.awt.image.SunVolatileImage;
import sun.awt.image.VolatileSurfaceManager;

/**
 * This factory creates platform specific VolatileSurfaceManager
 * implementations.
 *
 * There are two platform specific SurfaceManagerFactories in OpenJDK,
 * UnixSurfaceManagerFactory and WindowsSurfaceManagerFactory.
 * The actually used SurfaceManagerFactory is set by the respective platform
 * GraphicsEnvironment implementations in the static initializer.
 */
public abstract class SurfaceManagerFactory {

    /**
     * The single shared instance.
     */
    private static SurfaceManagerFactory instance;

    /**
     * Returns the surface manager factory instance. This returns a factory
     * that has been set by {@link #setInstance(SurfaceManagerFactory)}.
     *
     * @return the surface manager factory
     */
    public static synchronized SurfaceManagerFactory getInstance() {

        if (instance == null) {
            throw new IllegalStateException("No SurfaceManagerFactory set.");
        }
        return instance;
    }

    /**
     * Sets the surface manager factory. This may only be called once, and it
     * may not be set back to {@code null} when the factory is already
     * instantiated.
     *
     * @param factory the factory to set
     */
    public static synchronized void setInstance(SurfaceManagerFactory factory) {

        if (factory == null) {
            // We don't want to allow setting this to null at any time.
            throw new IllegalArgumentException("factory must be non-null");
        }

        if (instance != null) {
            // We don't want to re-set the instance at any time.
            throw new IllegalStateException("The surface manager factory is already initialized");
        }

        instance = factory;
    }

    /**
     * Creates a new instance of a VolatileSurfaceManager given any
     * arbitrary SunVolatileImage.  An optional context Object can be supplied
     * as a way for the caller to pass pipeline-specific context data to
     * the VolatileSurfaceManager (such as a backbuffer handle, for example).
     */
     public abstract VolatileSurfaceManager
         createVolatileManager(SunVolatileImage image, Object context);
}
