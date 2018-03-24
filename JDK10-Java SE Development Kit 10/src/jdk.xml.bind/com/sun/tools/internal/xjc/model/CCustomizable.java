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

package com.sun.tools.internal.xjc.model;

import com.sun.tools.internal.xjc.Plugin;
import com.sun.xml.internal.xsom.XSComponent;

import org.xml.sax.Locator;

/**
 * Implemented by model components that can have customizations contributed by {@link Plugin}s.
 *
 * @author Kohsuke Kawaguchi
 */
public interface CCustomizable {
    /**
     * Gets the list of customizations attached to this model component.
     *
     * @return
     *      can be an empty list but never be null. The returned list is read-only.
     *      Do not modify.
     *
     * @see Plugin#getCustomizationURIs()
     */
    CCustomizations getCustomizations();

    /**
     * Gets the source location in the schema from which this model component is created.
     *
     * @return never null.
     */
    Locator getLocator();

    /**
     * If this model object is built from XML Schema,
     * this property returns a schema component from which the model is built.
     *
     * @return
     *      null if the model is built from sources other than XML Schema
     *      (such as DTD.)
     */
    XSComponent getSchemaComponent();
}
