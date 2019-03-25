/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdeps;

/**
 * Signals that an exception of some sort has occurred while processing
 * a multi-release jar file.
 *
 * @since   9
 */
class MultiReleaseException extends RuntimeException {
    private static final long serialVersionUID = 4474870142461654108L;
    private final String key;
    private final Object[] params;

    /**
     * Constructs an {@code MultiReleaseException} with the specified detail
     * error message array.
     *
     * @param key
     *        The key that identifies the message in the jdeps.properties file
     * @param params
     *        The detail message array
     */
    public MultiReleaseException(String key, Object... params) {
        super();
        this.key = key;
        this.params = params;
    }

    /**
     * Returns the resource message key
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the detailed error message array.
     *
     * @return the detailed error message array
     */
    public Object[] getParams() {
        return params;
    }
}
