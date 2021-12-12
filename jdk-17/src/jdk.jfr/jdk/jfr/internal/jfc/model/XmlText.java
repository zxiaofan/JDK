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

// Corresponds to <text>
final class XmlText extends XmlInput {

    @Override
    public String getOptionSyntax() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("=<");
        sb.append(getContentType().orElse("text"));
        sb.append(">");
        return sb.toString();
    }

    @Override
    public void configure(String value) {
        if (isTimespan()) {
            value = Utilities.parseTimespan(value);
        }
        setContent(value);
        notifyListeners();
    }

    @Override
    public void configure(UserInterface ui) throws AbortException {
        ui.println();
        ui.println(getLabel() + ": " + getContent() + "  (default)");
        while (!readInput(ui)) {
            ;
        }
    }

    @Override
    protected Result evaluate() {
        return Result.of(getContent());
    }

    private boolean readInput(UserInterface ui) throws AbortException {
        String line = ui.readLine();
        if (line.isBlank()) {
            ui.println("Using default: " + getContent());
            return true;
        }
        if (isTimespan()) {
            try {
                line = Utilities.parseTimespan(line);
            } catch (IllegalArgumentException iae) {
                ui.println(iae.getMessage());
                return false;
            }
        }
        ui.println("Using: " + line);
        configure(line);
        return true;
    }

    private boolean isTimespan() {
        return getContentType().orElse("text").equals("timespan");
    }
}
