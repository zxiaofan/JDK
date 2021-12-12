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

// Corresponds to <option>
final class XmlOption extends XmlElement {

    public String getLabel() {
        return attribute("label");
    }

    public String getName() {
        return attribute("name");
    }

    @Override
    boolean isEntity() {
        return false;
    }

    @Override
    protected List<String> attributes() {
        return List.of("label", "name");
    }
}
