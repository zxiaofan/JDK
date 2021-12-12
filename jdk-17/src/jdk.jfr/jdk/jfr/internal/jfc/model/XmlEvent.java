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

// Corresponds to <event>
final class XmlEvent extends XmlElement {

    public String getName() {
        return attribute("name");
    }

    public List<XmlSetting> getSettings() {
        return elements(XmlSetting.class);
    }

    XmlSetting getSetting(String settingName, boolean add) {
        for (XmlSetting setting : getSettings()) {
            if (settingName.equals(setting.getName())) {
                return setting;
            }
        }
        if (!add) {
            String msg = "Could not find setting '" + settingName;
            msg += "' for event '" + getName() + "'";
            throw new IllegalArgumentException(msg);
        }
        XmlSetting setting = new XmlSetting();
        setting.setAttribute("name", settingName);
        addChild(setting);
        return setting;
    }

    @Override
    protected List<String> attributes() {
        return List.of("name");
    }

    @Override
    protected List<Constraint> constraints() {
        return List.of(Constraint.any(XmlSetting.class));
    }
}
