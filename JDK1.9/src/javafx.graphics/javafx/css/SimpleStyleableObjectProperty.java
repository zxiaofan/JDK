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
import javafx.beans.property.SimpleObjectProperty;

/**
 * This class extends {@code SimpleObjectProperty} and provides a full
 * implementation of a {@code StyleableProperty}.
 *
 * This class is used to make a {@link javafx.beans.property.ObjectProperty},
 * that would otherwise be implemented as a {@link SimpleObjectProperty},
 * styleable by CSS.
 *
 * @see javafx.beans.property.SimpleObjectProperty
 * @see CssMetaData
 * @see StyleableProperty
 * @see StyleableObjectProperty
 * @since JavaFX 8.0
 */
public class SimpleStyleableObjectProperty<T> extends StyleableObjectProperty<T> {

    private static final Object DEFAULT_BEAN = null;
    private static final String DEFAULT_NAME = "";

    private final Object bean;
    private final String name;
    private final CssMetaData<? extends Styleable, T> cssMetaData;

    /**
     * The constructor of the {@code SimpleStyleableObjectProperty}.
     * @param cssMetaData
     *            the CssMetaData associated with this {@code StyleableProperty}
     */
    public SimpleStyleableObjectProperty(@NamedArg("cssMetaData") CssMetaData<? extends Styleable, T> cssMetaData) {
        this(cssMetaData, DEFAULT_BEAN, DEFAULT_NAME);
    }

    /**
     * The constructor of the {@code SimpleStyleableObjectProperty}.
     *
     * @param cssMetaData
     *            the CssMetaData associated with this {@code StyleableProperty}
     * @param initialValue
     *            the initial value of the wrapped {@code Object}
     */
    public SimpleStyleableObjectProperty(@NamedArg("cssMetaData") CssMetaData<? extends Styleable, T> cssMetaData, @NamedArg("initialValue") T initialValue) {
        this(cssMetaData, DEFAULT_BEAN, DEFAULT_NAME, initialValue);
    }

    /**
     * The constructor of the {@code SimpleStyleableObjectProperty}.
     *
     * @param cssMetaData
     *            the CssMetaData associated with this {@code StyleableProperty}
     * @param bean
     *            the bean of this {@code ObjectProperty}
     * @param name
     *            the name of this {@code ObjectProperty}
     */
    public SimpleStyleableObjectProperty(@NamedArg("cssMetaData") CssMetaData<? extends Styleable, T> cssMetaData, @NamedArg("bean") Object bean, @NamedArg("name") String name) {
        this.bean = bean;
        this.name = (name == null) ? DEFAULT_NAME : name;
        this.cssMetaData = cssMetaData;
    }

    /**
     * The constructor of the {@code SimpleStyleableObjectProperty}.
     *
     * @param cssMetaData
     *            the CssMetaData associated with this {@code StyleableProperty}
     * @param bean
     *            the bean of this {@code ObjectProperty}
     * @param name
     *            the name of this {@code ObjectProperty}
     * @param initialValue
     *            the initial value of the wrapped {@code Object}
     */
    public SimpleStyleableObjectProperty(@NamedArg("cssMetaData") CssMetaData<? extends Styleable, T> cssMetaData, @NamedArg("bean") Object bean, @NamedArg("name") String name, @NamedArg("initialValue") T initialValue) {
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
    public final CssMetaData<? extends Styleable, T> getCssMetaData() {
        return cssMetaData;
    }

}
