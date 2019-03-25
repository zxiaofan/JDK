/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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
package sun.net.www.http;

/**
 * A <code>Hurryable</code> is a class that has been instructed to complete
 * its input processing so as to make resource associated with that input
 * available to others.
 */
public interface Hurryable {

    /**
     * @return a <code>boolean</code> indicating if the stream has been
     *         hurried or not.
     */
    boolean hurry();

}
