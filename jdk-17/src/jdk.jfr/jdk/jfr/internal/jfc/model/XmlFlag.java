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

// Corresponds to <flag>
final class XmlFlag extends XmlInput {

    @Override
    public String getOptionSyntax() {
        return getName() + "=<true|false>";
    }

    @Override
    public void configure(String value) {
        Utilities.checkValid(value, "true", "false");
        setContent(value);
        notifyListeners();
    }

    @Override
    public void configure(UserInterface ui) throws AbortException {
        Result defaultValue = Result.of(getContent());
        ui.println();
        ui.println(getLabel() + " [Y/N]: " + (defaultValue.isTrue() ? "Yes" : "No") + " (default)");

        while (!read(ui, defaultValue)) {
            ;
        }
    }

    @Override
    protected Result evaluate() {
        return Result.of(getContent());
    }

    private boolean read(UserInterface ui, Result defaultValue) throws AbortException {
        String line = ui.readLine();
        if (line.isBlank()) {
            ui.println("Using default: " + (defaultValue.isTrue() ? "Yes" : "No"));
            return true;
        }
        if (line.equalsIgnoreCase("Y") || line.equalsIgnoreCase("N")) {
            boolean value = line.equalsIgnoreCase("Y");
            ui.println("Using: " + (value ? "Yes" : "No"));
            configure(String.valueOf(value));
            return true;
        }
        ui.println("Not a valid choice.");
        return false;
    }
}
