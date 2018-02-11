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

package com.sun.tools.internal.xjc.api;

/**
 * Callback interface that allows the driver of the XJC API
 * to rename JAXB-generated classes/interfaces/enums.
 *
 * @author Kohsuke Kawaguchi
 */
public interface ClassNameAllocator {
    /**
     * Hook that allows the client of the XJC API to rename some of the JAXB-generated classes.
     *
     * <p>
     * When registered, this calllbcak is consulted for every package-level
     * classes/interfaces/enums (hereafter, simply "classes")
     * that the JAXB RI generates. Note that
     * the JAXB RI does not use this allocator for nested/inner classes.
     *
     * <p>
     * If the allocator chooses to rename some classes. It is
     * the allocator's responsibility to find unique names.
     * If the returned name collides with other classes, the JAXB RI will
     * report errors.
     *
     * @param packageName
     *      The package name, such as "" or "foo.bar". Never be null.
     * @param className
     *      The short name of the proposed class name. Such as
     *      "Foo" or "Bar". Never be null, never be empty.
     *      Always a valid Java identifier.
     *
     * @return
     *      The short name of the class name that should be used.
     *      The class will be generated into the same package with this name.
     *      The return value must be a valid Java identifier. May not be null.
     */
    String assignClassName( String packageName, String className );
}
