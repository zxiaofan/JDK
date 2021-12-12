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

// Corresponds to <control>
final class XmlControl extends XmlElement {

    public List<XmlInput> getInputs() {
        return elements(XmlInput.class);
    }

    public List<XmlCondition> getConditions() {
        return elements(XmlCondition.class);
    }

    //  Returns list of all <selection>, <condition>, <flag> and <text>
    public List<ControlElement> getControlElements() {
        return elements(ControlElement.class);
    }

    @Override
    String comment() {
        return """
               Contents of the control element is not read by the JVM, it's used
               by JDK Mission Control and the 'jfr'-tool to change settings that
               carry the control attribute.
               """;
    }

    @Override
    protected List<Constraint> constraints() {
        return List.of(
            Constraint.any(XmlCondition.class),
            Constraint.any(XmlText.class),
            Constraint.any(XmlSelection.class),
            Constraint.any(XmlFlag.class)
        );
    }
}
