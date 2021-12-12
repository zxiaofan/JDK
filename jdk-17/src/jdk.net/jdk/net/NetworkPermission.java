/*
 * Copyright (c) 2014, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.net;

import java.security.BasicPermission;

/**
 * Represents permission to access the extended networking capabilities
 * defined in the jdk.net package. These permissions contain a target
 * name, but no actions list. Callers either possess the permission or not.
 *
 * @see jdk.net.ExtendedSocketOptions
 *
 * @since 1.8
 */

public final class NetworkPermission extends BasicPermission {

    private static final long serialVersionUID = -2012939586906722291L;

    /**
     * Creates a NetworkPermission with the given target name.
     *
     * @param name the permission target name
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public NetworkPermission(String name)
    {
        super(name);
    }

    /**
     * Creates a NetworkPermission with the given target name.
     *
     * @param name the permission target name
     * @param actions should be {@code null}. Is ignored if not.
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public NetworkPermission(String name, String actions)
    {
        super(name, actions);
    }
}
