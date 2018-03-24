/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.fxml.builder;

import java.util.AbstractMap;
import java.util.Set;

import javafx.scene.image.Image;
import javafx.util.Builder;

/**
 * JavaFX image builder.
 */
public class JavaFXImageBuilder extends AbstractMap<String, Object> implements Builder<Image> {
    private String      url = "";
    private double      requestedWidth = 0;
    private double      requestedHeight = 0;
    private boolean     preserveRatio = false;
    private boolean     smooth = false;
    private boolean     backgroundLoading = false;

    @Override
    public Image build() {
        return new Image( url, requestedWidth, requestedHeight, preserveRatio, smooth, backgroundLoading);
    }

    @Override
    public Object put(String key, Object value) {
        if ( value != null) {
            String str = value.toString();

            if ( "url".equals( key)) {
                url = str;
            } else if ( "requestedWidth".equals(key)) {
                requestedWidth =  Double.parseDouble( str);
            } else if ( "requestedHeight".equals(key)) {
                requestedHeight =  Double.parseDouble(str);
            } else if ( "preserveRatio".equals(key)) {
                preserveRatio =  Boolean.parseBoolean(str);
            } else if ( "smooth".equals(key)) {
                smooth =  Boolean.parseBoolean(str);
            } else if ( "backgroundLoading".equals(key)) {
                backgroundLoading = Boolean.parseBoolean(str);
            } else {
                throw new IllegalArgumentException("Unknown Image property: " + key);
            }
        }

        return null;
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
