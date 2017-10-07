/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javafx.css.converter;

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

import java.util.Map;

/**
 * Converts an SVG shape string into a Shape object.
 *
 * @since 9
 */
public class ShapeConverter extends StyleConverter<String, Shape> {
    private static final ShapeConverter INSTANCE = new ShapeConverter();

    public static StyleConverter<String, Shape> getInstance() { return INSTANCE; }

    @Override public Shape convert(ParsedValue<String, Shape> value, Font font) {

        Shape shape = super.getCachedValue(value);
        if (shape != null) return shape;

        String svg = value.getValue();
        if (svg == null || svg.isEmpty()) return null;
        SVGPath path = new SVGPath();
        path.setContent(svg);

        super.cacheValue(value, path);

        return path;
    }

    private static Map<ParsedValue<String, Shape>, Shape> cache;

    public static void clearCache() { if (cache != null) cache.clear(); }

}
