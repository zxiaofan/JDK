/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.options;

/**
 * A nested Boolean {@link OptionKey} that can be overridden by a {@link #masterOption master
 * option}.
 * <p>
 * <li>If the option is present on the command line the specified value is used.
 * <li>Otherwise {@link #getValue} depends on the {@link #masterOption} and evaluates as follows:
 * <ul>
 * <li>If {@link #masterOption} is set, this value equals to {@link #initialValue}.
 * <li>Otherwise, if {@link #masterOption} is {@code false}, this option is {@code false}.
 */
public class NestedBooleanOptionKey extends OptionKey<Boolean> {
    private final OptionKey<Boolean> masterOption;
    private final Boolean initialValue;

    public NestedBooleanOptionKey(OptionKey<Boolean> masterOption, Boolean initialValue) {
        super(null);
        this.masterOption = masterOption;
        this.initialValue = initialValue;
    }

    public OptionKey<Boolean> getMasterOption() {
        return masterOption;
    }

    @Override
    public Boolean getValue(OptionValues options) {
        Boolean v = super.getValue(options);
        if (v == null) {
            return initialValue && masterOption.getValue(options);
        }
        return v;
    }
}
