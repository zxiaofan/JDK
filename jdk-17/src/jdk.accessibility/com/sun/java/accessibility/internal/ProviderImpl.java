/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.java.accessibility.internal;

import javax.accessibility.AccessibilityProvider;

/* This class provided methods to identify and activate the mapping from the
 * JavaAccessBridge API to the Java Accessibility API.
 */
public final class ProviderImpl extends AccessibilityProvider {
    /**
     * Typically the service name returned by the name() method would be a simple
     * name such as JavaAccessBridge, but the following name is used for compatibility
     * with prior versions of ${user.home}/.accessibility.properties and
     * ${java.home}/conf/accessibility.properties where the text on the
     * assistive.technologies= line is a fully qualified class name. As of Java 9
     * class names are no longer used to identify assistive technology implementations.
     * If the properties file exists the installer will not replace it thus the
     * need for compatibility.
     */
    private final String name = "com.sun.java.accessibility.AccessBridge";

    public ProviderImpl() {}

    public String getName() {
        return name;
    }

    public void activate() {
        /**
         * Note that the AccessBridge is instantiated here rather than in the
         * constructor.  If the caller determines that this object is named
         * "com.sun.java.accessibility.AccessBridge" then the caller will call
         * start to instantiate the AccessBridge which will in turn activate it.
         */
        new AccessBridge();
    }

}
