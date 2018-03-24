/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2;

/**
 * Place holder for TODOs.
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public abstract class TODO {
    /**
     * When this method is called,
     * that means we need to check the spec and corrects
     * the behavior.
     *
     * Search the usage of this method.
     */
    public static void checkSpec() {}
    public static void checkSpec(String comment) {}

    /**
     * When this method iscalled,
     * that means the current code is a mock up and
     * it needs to be properly implemented later.
     */
    public static void prototype() {}

    public static void prototype(String comment) {}

    /**
     * When this method is called, it means that there is an
     * unimplemeted portion of the spec in the schema generator.
     */
    public static void schemaGenerator(String comment) {}
}
