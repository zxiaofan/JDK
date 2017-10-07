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

package javafx.beans.binding;

import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.sun.javafx.binding.StringFormatter;
import javafx.beans.value.ObservableValue;

/**
 * {@code BooleanExpression} is an
 * {@link javafx.beans.value.ObservableBooleanValue} plus additional convenience
 * methods to generate bindings in a fluent style.
 * <p>
 * A concrete sub-class of {@code BooleanExpression} has to implement the method
 * {@link javafx.beans.value.ObservableBooleanValue#get()}, which provides the
 * actual value of this expression.
 * @since JavaFX 2.0
 */
public abstract class BooleanExpression implements ObservableBooleanValue {

    /**
     * Sole constructor
     */
    public BooleanExpression() {
    }

    @Override
    public Boolean getValue() {
        return get();
    }

    /**
     * Returns a {@code BooleanExpression} that wraps a
     * {@link javafx.beans.value.ObservableBooleanValue}. If the
     * {@code ObservableBooleanValue} is already a {@code BooleanExpression}, it
     * will be returned. Otherwise a new
     * {@link javafx.beans.binding.BooleanBinding} is created that is bound to
     * the {@code ObservableBooleanValue}.
     *
     * @param value
     *            The source {@code ObservableBooleanValue}
     * @return A {@code BooleanExpression} that wraps the
     *         {@code ObservableBooleanValue} if necessary
     * @throws NullPointerException
     *             if {@code value} is {@code null}
     */
    public static BooleanExpression booleanExpression(
            final ObservableBooleanValue value) {
        if (value == null) {
            throw new NullPointerException("Value must be specified.");
        }
        return (value instanceof BooleanExpression) ? (BooleanExpression) value
                : new BooleanBinding() {
                    {
                        super.bind(value);
                    }

                    @Override
                    public void dispose() {
                        super.unbind(value);
                    }

                    @Override
                    protected boolean computeValue() {
                        return value.get();
                    }

                    @Override
                    public ObservableList<ObservableBooleanValue> getDependencies() {
                        return FXCollections.singletonObservableList(value);
                    }
                };
    }

    /**
     * Returns a {@code BooleanExpression} that wraps an
     * {@link javafx.beans.value.ObservableValue}. If the
     * {@code ObservableValue} is already a {@code BooleanExpression}, it
     * will be returned. Otherwise a new
     * {@link javafx.beans.binding.BooleanBinding} is created that is bound to
     * the {@code ObservableValue}.
     *
     * Note: null values will be interpreted as "false".
     *
     * @param value
     *            The source {@code ObservableValue}
     * @return A {@code BooleanExpression} that wraps the
     *         {@code ObservableValue} if necessary
     * @throws NullPointerException
     *             if {@code value} is {@code null}
     * @since JavaFX 8.0
     */
    public static BooleanExpression booleanExpression(final ObservableValue<Boolean> value) {
        if (value == null) {
            throw new NullPointerException("Value must be specified.");
        }
        return (value instanceof BooleanExpression) ? (BooleanExpression) value
                : new BooleanBinding() {
            {
                super.bind(value);
            }

            @Override
            public void dispose() {
                super.unbind(value);
            }

            @Override
            protected boolean computeValue() {
                final Boolean val = value.getValue();
                return val == null ? false : val;
            }

            @Override
            public ObservableList<ObservableValue<Boolean>> getDependencies() {
                return FXCollections.singletonObservableList(value);
            }
        };
    }

    /**
     * Creates a new {@code BooleanExpression} that performs the conditional
     * AND-operation on this {@code BooleanExpression} and a
     * {@link ObservableBooleanValue}.
     *
     * @param other
     *            the other {@code ObservableBooleanValue}
     * @return the new {@code BooleanExpression}
     * @throws NullPointerException
     *             if {@code other} is {@code null}
     */
    public BooleanBinding and(final ObservableBooleanValue other) {
        return Bindings.and(this, other);
    }

    /**
     * Creates a new {@code BooleanExpression} that performs the conditional
     * OR-operation on this {@code BooleanExpression} and a
     * {@link ObservableBooleanValue}.
     *
     * @param other
     *            the other {@code ObservableBooleanValue}
     * @return the new {@code BooleanExpression}
     * @throws NullPointerException
     *             if {@code other} is {@code null}
     */
    public BooleanBinding or(final ObservableBooleanValue other) {
        return Bindings.or(this, other);
    }

    /**
     * Creates a new {@code BooleanExpression} that calculates the negation of
     * this {@code BooleanExpression}.
     *
     * @return the new {@code BooleanExpression}
     */
    public BooleanBinding not() {
        return Bindings.not(this);
    }

    /**
     * Creates a new {@code BooleanExpression} that holds {@code true} if this and
     * another {@link javafx.beans.value.ObservableBooleanValue} are equal.
     *
     * @param other
     *            the other {@code ObservableBooleanValue}
     * @return the new {@code BooleanExpression}
     * @throws NullPointerException
     *             if {@code other} is {@code null}
     */
    public BooleanBinding isEqualTo(final ObservableBooleanValue other) {
        return Bindings.equal(this, other);
    }

    /**
     * Creates a new {@code BooleanExpression} that holds {@code true} if this and
     * another {@link javafx.beans.value.ObservableBooleanValue} are equal.
     *
     * @param other
     *            the other {@code ObservableBooleanValue}
     * @return the new {@code BooleanExpression}
     * @throws NullPointerException
     *             if {@code other} is {@code null}
     */
    public BooleanBinding isNotEqualTo(final ObservableBooleanValue other) {
        return Bindings.notEqual(this, other);
    }

    /**
     * Creates a {@link javafx.beans.binding.StringBinding} that holds the value
     * of this {@code BooleanExpression} turned into a {@code String}. If the
     * value of this {@code BooleanExpression} changes, the value of the
     * {@code StringBinding} will be updated automatically.
     *
     * @return the new {@code StringBinding}
     */
    public StringBinding asString() {
        return (StringBinding) StringFormatter.convert(this);
    }

    /**
     * Creates an {@link javafx.beans.binding.ObjectExpression} that holds the value
     * of this {@code BooleanExpression}. If the
     * value of this {@code BooleanExpression} changes, the value of the
     * {@code ObjectExpression} will be updated automatically.
     *
     * @return the new {@code ObjectExpression}
     * @since JavaFX 8.0
     */
    public ObjectExpression<Boolean> asObject() {
        return new ObjectBinding<Boolean>() {
            {
                bind(BooleanExpression.this);
            }

            @Override
            public void dispose() {
                unbind(BooleanExpression.this);
            }

            @Override
            protected Boolean computeValue() {
                return BooleanExpression.this.getValue();
            }
        };
    }
}
