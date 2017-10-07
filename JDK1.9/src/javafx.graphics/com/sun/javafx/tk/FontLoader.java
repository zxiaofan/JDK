/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;

import java.io.InputStream;
import java.util.List;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public abstract class FontLoader {
    public abstract void loadFont(Font font);
    public abstract List<String> getFamilies();
    public abstract List<String> getFontNames();
    public abstract List<String> getFontNames(String family);
    public abstract Font font(String family, FontWeight weight,
                              FontPosture posture, float size);
    public abstract Font[] loadFont(InputStream in, double size, boolean all);
    public abstract Font[] loadFont(String path, double size, boolean all);
    public abstract FontMetrics getFontMetrics(Font font);
    public abstract float getCharWidth(char ch, Font font);
    public abstract float getSystemFontSize();
}
