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

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

// Corresponds to <configuration>
final class XmlConfiguration extends XmlElement {

    public List<XmlEvent> getEvents() {
        return elements(XmlEvent.class);
    }

    public Optional<String> getDescription() {
        return optional("description");
    }

    public Optional<String> getLabel() {
        return optional("label");
    }

    public Optional<String> getProvider() {
        return optional("provider");
    }

    public Optional<String> getVersion() {
        return optional("version");
    }

    public List<XmlControl> getControls() {
        return elements(XmlControl.class);
    }

    @Override
    String comment() {
        return """
               Recommended way to edit .jfc files is to use the configure command of
               the 'jfr' tool, i.e. jfr configure, or JDK Mission Control
               see Window -> Flight Recorder Template Manager
               """;
    }

    XmlEvent getEvent(String eventName, boolean add) {
        for (XmlEvent event : getEvents()) {
            if (eventName.equals(event.getName())) {
                return event;
            }
        }
        if (!add) {
            throw new IllegalArgumentException("Could not find event '" + eventName + "'");
        }
        XmlEvent event = new XmlEvent();
        event.setAttribute("name", eventName);
        addChild(event);
        return event;
    }

    @Override
    protected List<String> attributes() {
        return List.of("version", "label");
    }

    @Override
    protected void validateAttributes() throws ParseException {
        super.validateAttributes();
        if (!attribute("version").equals("2.0")) {
            throw new ParseException("Only .jfc files of version 2.0 is supported", -1);
        }
    }

    @Override
    protected List<Constraint> constraints() {
        return List.of(
            Constraint.any(XmlEvent.class),
            Constraint.any(XmlControl.class)
        );
    }
}
