/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.packager.services.singleton;

/**
 * The {@code SingleInstanceListener} interface is used for implementing
 * Single Instance functionality for Java Packager.
 *
 * @since 10
 */
public interface SingleInstanceListener {

    /**
     * This method should be implemented by the application to
     * handle the single instance behaviour - how should the application
     * handle the arguments when another instance of the application is
     * invoked with params.
     *
     * @param params parameters for the application main
     */
    public void newActivation(String... params);
}
