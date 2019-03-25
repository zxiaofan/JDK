/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal;

/**
 * Class that exposes the current state of asserts.
 */
public final class AssertsEnabled {
    private static boolean assertsEnabled = false;
    static {
        assert assertsEnabled = true; // Intentional side effect
    }

    /**
     * Returns true if asserts are enabled
     * @return true if asserts are enabled
     */
    public static boolean assertsEnabled() {
        return assertsEnabled;
    }
}
