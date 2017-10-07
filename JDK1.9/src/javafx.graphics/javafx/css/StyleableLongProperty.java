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

import javafx.beans.property.LongPropertyBase;
import javafx.beans.value.ObservableValue;

/**
 * This class extends {@code LongPropertyBase} and provides a partial
 * implementation of a {@code StyleableProperty}. The method
 * {@link StyleableProperty#getCssMetaData()} is not implemented.
 *
 * This class is used to make a {@link javafx.beans.property.LongProperty},
 * that would otherwise be implemented as a {@link LongPropertyBase},
 * styleable by CSS.
 *
 * @see javafx.beans.property.LongPropertyBase
 * @see CssMetaData
 * @see StyleableProperty
 * @since JavaFX 8.0
 */
public abstract class StyleableLongProperty
    extends LongPropertyBase implements StyleableProperty<Number> {

    /**
     * The constructor of the {@code StyleableLongProperty}.
     */
    public StyleableLongProperty() {
        super();
    }

    /**
     * The constructor of the {@code StyleableLongProperty}.
     *
     * @param initialValue
     *            the initial value of the wrapped {@code Object}
     */
    public StyleableLongProperty(long initialValue) {
        super(initialValue);
    }

    /** {@inheritDoc} */
    @Override
    public void applyStyle(StyleOrigin origin, Number v) {
        setValue(v);
        this.origin = origin;
    }

    /** {@inheritDoc} */
    @Override
    public void bind(ObservableValue<? extends Number> observable) {
        super.bind(observable);
        origin = StyleOrigin.USER;
    }

    /** {@inheritDoc} */
    @Override
    public void set(long v) {
        super.set(v);
        origin = StyleOrigin.USER;
    }

    /** {@inheritDoc} */
    @Override
    public StyleOrigin getStyleOrigin() { return origin; }

    private StyleOrigin origin = null;

}
