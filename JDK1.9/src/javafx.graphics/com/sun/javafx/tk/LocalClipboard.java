/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.security.AccessControlContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javafx.scene.image.Image;
import javafx.scene.input.DataFormat;
import javafx.scene.input.TransferMode;
import javafx.util.Pair;

final class LocalClipboard implements TKClipboard {
    private final Map<DataFormat, Object> values;

    public LocalClipboard() {
        values = new HashMap<DataFormat, Object>();
    }

    @Override
    public void setSecurityContext(final AccessControlContext ctx) {
        // ctx not needed
    }

    @Override
    public Set<DataFormat> getContentTypes() {
        return Collections.unmodifiableSet(
                   new HashSet<DataFormat>(values.keySet()));
    }

    @Override
    public boolean putContent(final Pair<DataFormat, Object>... content) {
        for (final Pair<DataFormat, Object> pair: content) {
            if (pair.getKey() == null) {
                throw new NullPointerException(
                        "Clipboard.putContent: null data format");
            }
            if (pair.getValue() == null) {
                throw new NullPointerException(
                        "Clipboard.putContent: null data");
            }
        }

        // all OK, replace clipboard content
        values.clear();
        for (final Pair<DataFormat, Object> pair: content) {
            values.put(pair.getKey(), pair.getValue());
        }

        return true;
    }

    @Override
    public Object getContent(final DataFormat dataFormat) {
        return values.get(dataFormat);
    }

    @Override
    public boolean hasContent(final DataFormat dataFormat) {
        return values.containsKey(dataFormat);
    }

    @Override
    public Set<TransferMode> getTransferModes() {
        throw new IllegalStateException();
    }

    @Override
    public void setDragView(final Image image) {
        throw new IllegalStateException();
    }

    @Override
    public void setDragViewOffsetX(final double offsetX) {
        throw new IllegalStateException();
    }

    @Override
    public void setDragViewOffsetY(final double offsetY) {
        throw new IllegalStateException();
    }

    @Override
    public Image getDragView() {
        throw new IllegalStateException();
    }

    @Override
    public double getDragViewOffsetX() {
        throw new IllegalStateException();
    }

    @Override
    public double getDragViewOffsetY() {
        throw new IllegalStateException();
    }
}
