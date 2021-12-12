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
import java.util.StringJoiner;

// Corresponds to <selection>
final class XmlSelection extends XmlInput {

    @Override
    public String getOptionSyntax() {
        StringJoiner sj = new StringJoiner("|", "<", ">");
        for (XmlOption option : getOptions()) {
            sj.add(option.getName());
        }
        return getName() + "=" + sj.toString();
    }

    @Override
    public void configure(String value) {
        var valid = getOptions().stream().map(XmlOption::getName);
        Utilities.checkValid(value, valid.toArray());
        setAttribute("default", value);
        notifyListeners();
    }

    @Override
    public void configure(UserInterface ui) throws AbortException {
        XmlOption selected = getSelected();
        if (selected == null) {
            return;
        }
        String label = getLabel();
        ui.println();
        ui.println(label + ": " + selected.getLabel() + " (default)");
        int index = 1;
        List<XmlOption> options = getOptions();
        for (XmlOption s : options) {
            ui.println(index + ". " + s.getLabel());
            index++;
        }
        while (true) {
            String line = ui.readLine();
            if (line.isBlank()) {
                ui.println("Using default: " + selected.getLabel());
                return;
            }
            try {
                int s = Integer.parseInt(line) - 1;
                if (s >= 0 && s < options.size()) {
                    XmlOption o = options.get(s);
                    ui.println("Using: " + o.getLabel());
                    configure(o.getName());
                    return;
                }
                ui.println("Not in range.");
            } catch (NumberFormatException nfe) {
                ui.println("Must enter a number, or ENTER to select default.");
            }
        }
    }

    @Override
    protected List<String> attributes() {
        return List.of("name", "label", "default");
    }

    public String getDefault() {
        return attribute("default");
    }

    public List<XmlOption> getOptions() {
        return elements(XmlOption.class);
    }

    @Override
    protected List<Constraint> constraints() {
        return List.of(Constraint.atLeast(XmlOption.class, 1));
    }

    @Override
    protected Result evaluate() {
        return Result.of(getSelected().getContent());
    }

    private XmlOption getSelected() {
        List<XmlOption> options = getOptions();
        for (XmlOption optionElement : options) {
            if (getDefault().equals(optionElement.getName())) {
                return optionElement;
            }
        }
        return options.isEmpty() ? null : options.get(0);
    }
}
