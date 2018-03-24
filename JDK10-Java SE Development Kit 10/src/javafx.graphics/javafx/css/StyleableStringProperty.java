/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

import javafx.beans.property.StringPropertyBase;
import javafx.beans.value.ObservableValue;

/**
 * This class extends {@code StringPropertyBase} and provides a partial
 * implementation of a {@code StyleableProperty}. The method
 * {@link StyleableProperty#getCssMetaData()} is not implemented.
 *
 * This class is used to make a {@link javafx.beans.property.StringProperty},
 * that would otherwise be implemented as a {@link StringPropertyBase},
 * styleable by CSS.
 *
 * @see javafx.beans.property.StringPropertyBase
 * @see CssMetaData
 * @see StyleableProperty
 * @since JavaFX 8.0
 */
public abstract class StyleableStringProperty
    extends StringPropertyBase implements StyleableProperty<String> {

    /**
     * The constructor of the {@code StyleableStringProperty}.
     */
    public StyleableStringProperty() {
        super();
    }

    /**
     * The constructor of the {@code StyleableStringProperty}.
     *
     * @param initialValue
     *            the initial value of the wrapped {@code Object}
     */
    public StyleableStringProperty(String initialValue) {
        super(initialValue);
    }

    /** {@inheritDoc} */
    @Override
    public void applyStyle(StyleOrigin origin, String v) {
        // call set here in case the set method is overriden
        set(v);
        this.origin = origin;
    }

    /** {@inheritDoc} */
    @Override
    public void bind(ObservableValue<? extends String> observable) {
        super.bind(observable);
        origin = StyleOrigin.USER;
    }

    /** {@inheritDoc} */
    @Override
    public void set(String v) {
        super.set(v);
        origin = StyleOrigin.USER;
    }


    /** {@inheritDoc} */
    @Override
    public StyleOrigin getStyleOrigin() { return origin; }

    private StyleOrigin origin = null;

}
