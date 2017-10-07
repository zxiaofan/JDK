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

import javafx.beans.NamedArg;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * This class extends {@code SimpleBooleanProperty} and provides a full
 * implementation of a {@code StyleableProperty}.
 *
 * This class is used to make a {@link javafx.beans.property.BooleanProperty},
 * that would otherwise be implemented as a {@link SimpleBooleanProperty},
 * styleable by CSS.
 *
 * @see javafx.beans.property.SimpleBooleanProperty
 * @see CssMetaData
 * @see StyleableProperty
 * @see StyleableBooleanProperty
 * @since JavaFX 8.0
 */
public class SimpleStyleableBooleanProperty extends StyleableBooleanProperty {

    private static final Object DEFAULT_BEAN = null;
    private static final String DEFAULT_NAME = "";

    private final Object bean;
    private final String name;
    private final CssMetaData<? extends Styleable, Boolean> cssMetaData;

    /**
     * The constructor of the {@code SimpleStyleableBooleanProperty}.
     * @param cssMetaData
     *            the CssMetaData associated with this {@code StyleableProperty}
     */
    public SimpleStyleableBooleanProperty(@NamedArg("cssMetaData") CssMetaData<? extends Styleable, Boolean> cssMetaData) {
        this(cssMetaData, DEFAULT_BEAN, DEFAULT_NAME);
    }

    /**
     * The constructor of the {@code SimpleStyleableBooleanProperty}.
     *
     * @param cssMetaData
     *            the CssMetaData associated with this {@code StyleableProperty}
     * @param initialValue
     *            the initial value of the wrapped {@code Object}
     */
    public SimpleStyleableBooleanProperty(@NamedArg("cssMetaData") CssMetaData<? extends Styleable, Boolean> cssMetaData, @NamedArg("initialValue") boolean initialValue) {
        this(cssMetaData, DEFAULT_BEAN, DEFAULT_NAME, initialValue);
    }

    /**
     * The constructor of the {@code SimpleStyleableBooleanProperty}.
     *
     * @param cssMetaData
     *            the CssMetaData associated with this {@code StyleableProperty}
     * @param bean
     *            the bean of this {@code BooleanProperty}
     * @param name
     *            the name of this {@code BooleanProperty}
     */
    public SimpleStyleableBooleanProperty(@NamedArg("cssMetaData") CssMetaData<? extends Styleable, Boolean> cssMetaData, @NamedArg("bean") Object bean, @NamedArg("name") String name) {
        this.bean = bean;
        this.name = (name == null) ? DEFAULT_NAME : name;
        this.cssMetaData = cssMetaData;
    }

    /**
     * The constructor of the {@code SimpleStyleableBooleanProperty}.
     *
     * @param cssMetaData
     *            the CssMetaData associated with this {@code StyleableProperty}
     * @param bean
     *            the bean of this {@code BooleanProperty}
     * @param name
     *            the name of this {@code BooleanProperty}
     * @param initialValue
     *            the initial value of the wrapped {@code Object}
     */
    public SimpleStyleableBooleanProperty(@NamedArg("cssMetaData") CssMetaData<? extends Styleable, Boolean> cssMetaData, @NamedArg("bean") Object bean, @NamedArg("name") String name, @NamedArg("initialValue") boolean initialValue) {
        super(initialValue);
        this.bean = bean;
        this.name = (name == null) ? DEFAULT_NAME : name;
        this.cssMetaData = cssMetaData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getBean() {
        return bean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    @Override
    public final CssMetaData<? extends Styleable, Boolean> getCssMetaData() {
        return cssMetaData;
    }

}
