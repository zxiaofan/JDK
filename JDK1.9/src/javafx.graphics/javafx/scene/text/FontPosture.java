/*
 * Copyright (c) 2008, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.text;

/**
 * Specifies whether the font is italicized
 * @since JavaFX 2.0
 */
public enum FontPosture {
    /**
     * represents regular.
     */
    REGULAR("", "regular"),
    /**
     * represents italic.
     */
    ITALIC("italic");

    private final String[] names;

    private FontPosture(String... names) {
        this.names = names;
    }

    /**
     * Returns {@code FontPosture} by its name.
     *
     * @param name name of the {@code FontPosture}
     * @return the FontPosture by its name
     */
    public static FontPosture findByName(String name) {
        if (name == null) return null;

        for (FontPosture s : FontPosture.values()) {
            for (String n : s.names) {
                if (n.equalsIgnoreCase(name)) return s;
            }
        }

        return null;
    }
}
