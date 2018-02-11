/*
 * Copyright (c) 2010, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.css;

import javafx.css.converter.FontConverter;
import javafx.css.converter.SizeConverter;
import javafx.css.converter.StringConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * An partial implementation of CssMetaData for Font properties which
 * includes the font sub-properties: weight, style, family and size.
 * @param <S> The type of Styleable
 * @since JavaFX 8.0
 */
public abstract class FontCssMetaData<S extends Styleable> extends CssMetaData<S, Font> {

    /**
     * Constructs a FontCSSMetaData object from the specified property and initial Font.
     * {@literal The property name is concatenated with "-weight", "-style",
     * "-family" and "-size" to create the sub-properties.}
     * For example,
     * {@code new FontCssMetaData<Text>("-fx-font", Font.getDefault());}
     * {@literal will create a CssMetaData for "-fx-font" with sub-properties:
     * "-fx-font-weight", "-fx-font-style", "-fx-font-family" and "-fx-font-size"}
     * @param property the property name
     * @param initial the initial font
     */
    public FontCssMetaData(String property, Font initial) {
        super(property, FontConverter.getInstance(), initial, true, createSubProperties(property, initial));
    }

    private static <S extends Styleable> List<CssMetaData<? extends Styleable, ?>> createSubProperties(String property, Font initial) {

        final List<CssMetaData<S, ?>> subProperties =
                new ArrayList<>();

        final Font defaultFont = initial != null ? initial : Font.getDefault();

        final CssMetaData<S, String> FAMILY =
                new CssMetaData<S, String>(property.concat("-family"),
                StringConverter.getInstance(), defaultFont.getFamily(), true) {
            @Override
            public boolean isSettable(S styleable) {
                return false;
            }

            @Override
            public StyleableProperty<String> getStyleableProperty(S styleable) {
                return null;
            }
        };
        subProperties.add(FAMILY);

        final CssMetaData<S, Number> SIZE =
                new CssMetaData<S, Number>(property.concat("-size"),
                SizeConverter.getInstance(), defaultFont.getSize(), true) {
            @Override
            public boolean isSettable(S styleable) {
                return false;
            }

            @Override
            public StyleableProperty<Number> getStyleableProperty(S styleable) {
                return null;
            }
        };
        subProperties.add(SIZE);

        final CssMetaData<S, FontPosture> STYLE =
                new CssMetaData<S, FontPosture>(property.concat("-style"),
                FontConverter.FontStyleConverter.getInstance(), FontPosture.REGULAR, true) {
            @Override
            public boolean isSettable(S styleable) {
                return false;
            }

            @Override
            public StyleableProperty<FontPosture> getStyleableProperty(S styleable) {
                return null;
            }
        };
        subProperties.add(STYLE);

        final CssMetaData<S, FontWeight> WEIGHT =
                new CssMetaData<S, FontWeight>(property.concat("-weight"),
                FontConverter.FontWeightConverter.getInstance(), FontWeight.NORMAL, true) {
            @Override
            public boolean isSettable(S styleable) {
                return false;
            }

            @Override
            public StyleableProperty<FontWeight> getStyleableProperty(S styleable) {
                return null;
            }
        };
        subProperties.add(WEIGHT);

        return Collections.<CssMetaData<? extends Styleable, ?>>unmodifiableList(subProperties);
    }

}
