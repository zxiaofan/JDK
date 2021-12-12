/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.jfc.model;

import java.util.List;
import java.util.Optional;

// Base class for elements that the user can interact with,
// <selection>, <text> and <flag>
public abstract class XmlInput extends XmlElement implements ControlElement {

    public abstract String getOptionSyntax();

    abstract void configure(UserInterface ui) throws AbortException;

    abstract void configure(String value);

    public final Optional<String> getContentType() {
        return optional("contentType");
    }

    @Override
    public final String getName() {
        return attribute("name");
    }

    public final String getLabel() {
        return attribute("label");
    }

    @Override
    protected List<String> attributes() {
        return List.of("name", "label");
    }
}
