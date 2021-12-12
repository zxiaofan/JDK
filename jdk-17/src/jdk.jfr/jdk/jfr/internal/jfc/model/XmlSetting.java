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

// Corresponds to <setting>
final class XmlSetting extends XmlElement {

    @Override
    public boolean isEntity() {
        return false;
    }

    @Override
    protected List<String> attributes() {
        return List.of("name");
    }

    public String getName() {
        return attribute("name");
    }

    public Optional<String> getControl() {
        return optional("control");
    }

    @Override
    public void onChange() {
        String value = evaluate().value();
        if (value != null) {
            setContent(value);
        }
    }

    @Override
    final void setContent(String value) {
        super.setContent(value);
        if (getParent() instanceof XmlEvent event) {
            SettingsLog.log(this, value);
        }
    }

    @Override
    protected Result evaluate() {
        for (XmlElement producer : getProducers()) {
            Result result = producer.evaluate();
            if (!result.isNull()) {
                return result;
            }
        }
        return Result.NULL;
    }

    public String getFullName() {
        if (getParent() instanceof XmlEvent event) {
            return event.getName() + "#" + getName();
        }
        return "unknown";
    }
}
