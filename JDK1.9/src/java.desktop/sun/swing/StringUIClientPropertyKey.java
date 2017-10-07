/*
 * Copyright (c) 2006, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.swing;

import javax.swing.UIClientPropertyKey;

/**
 * An implementation of {@code UIClientPropertyKey} that wraps a {@code String}.
 *
 * @author Shannon Hickey
 */
public class StringUIClientPropertyKey implements UIClientPropertyKey {

    private final String key;

    public StringUIClientPropertyKey(String key) {
        this.key = key;
    }

    public String toString() {
        return key;
    }
}
