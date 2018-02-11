/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.taglets;

/**
 * A taglet that adds the initial line of documentation to the JavaFX
 * property setters.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
@Deprecated
public class PropertySetterTaglet extends BasePropertyTaglet {

    /**
     * Construct a new PropertyGetterTaglet.
     */
    public PropertySetterTaglet () {
        name = "propertySetter";
    }

    @Override
    String getText(TagletWriter tagletWriter) {
        return tagletWriter.configuration().getText("doclet.PropertySetter");
    }
}
