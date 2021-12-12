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
package jdk.jpackage.internal;

import java.util.HashMap;
import java.util.Map;

final class WixVariables {

    void defineWixVariable(String variableName) {
        setWixVariable(variableName, "yes");
    }

    void setWixVariable(String variableName, String variableValue) {
        values.put(variableName, variableValue);
    }

    Map<String, String> getValues() {
        return values;
    }

    private final Map<String, String> values = new HashMap<>();
}
