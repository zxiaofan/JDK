/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.runtime;

import jdk.vm.ci.code.Architecture;

import org.graalvm.compiler.core.target.Backend;

/**
 * A runtime supporting a host backend as well, zero or more additional backends.
 */
public interface RuntimeProvider {

    /**
     * Gets the host backend.
     */
    Backend getHostBackend();

    /**
     * Gets the backend for a given architecture.
     *
     * @param arch a specific architecture class
     */
    <T extends Architecture> Backend getBackend(Class<T> arch);
}
