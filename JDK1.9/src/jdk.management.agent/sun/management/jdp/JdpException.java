/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package sun.management.jdp;

/**
 * An Exception thrown if a JDP implementation encounters a problem.
 */
public final class JdpException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new JDP exception with a meaningful message
     *
     * @param msg - message
     */
    public JdpException(String msg) {
        super(msg);
    }
}
