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

package javafx.beans.property.adapter;

import com.sun.javafx.binding.ExpressionHelper;
import com.sun.javafx.property.MethodHelper;
import com.sun.javafx.property.adapter.Disposer;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * A {@code JavaBeanDoubleProperty} provides an adapter between a regular
 * Java Bean property of type {@code double} or {@code Double} and a JavaFX
 * {@code DoubleProperty}. It cannot be created directly, but a
 * {@link JavaBeanDoublePropertyBuilder} has to be used.
 * <p>
 * As a minimum, the Java Bean class must implement a getter and a setter for the
 * property.
 * The class, as well as the getter and a setter methods, must be declared public.
 * If the getter of an instance of this class is called, the property of
 * the Java Bean is returned. If the setter is called, the value will be passed
 * to the Java Bean property. If the Java Bean property is bound (i.e. it supports
 * PropertyChangeListeners), this {@code JavaBeanDoubleProperty} will be
 * aware of changes in the Java Bean. Otherwise it can be notified about
 * changes by calling {@link #fireValueChangedEvent()}. If the Java Bean property
 * is also constrained (i.e. it supports VetoableChangeListeners), this
 * {@code JavaBeanDoubleProperty} will reject changes, if it is bound to an
 * {@link javafx.beans.value.ObservableValue ObservableValue&lt;Double&gt;}.
 * </p>
 * <p><b>Deploying an Application as a Module</b></p>
 * <p>
 * If the Java Bean class is in a named module, then it must be reflectively
 * accessible to the {@code javafx.base} module.
 * A class is reflectively accessible if the module
 * {@link Module#isOpen(String,Module) opens} the containing package to at
 * least the {@code javafx.base} module.
 * </p>
 * <p>
 * For example, if {@code com.foo.MyBeanClass} is in the {@code foo.app} module,
 * the {@code module-info.java} might
 * look like this:
 * </p>
 *
<pre>{@code module foo.app {
    opens com.foo to javafx.base;
}}</pre>
 *
 * <p>
 * Alternatively, a class is reflectively accessible if the module
 * {@link Module#isExported(String) exports} the containing package
 * unconditionally.
 * </p>
 *
 * @see javafx.beans.property.DoubleProperty
 * @see JavaBeanDoublePropertyBuilder
 * @since JavaFX 2.1
 */
public final class JavaBeanDoubleProperty extends DoubleProperty implements JavaBeanProperty<Number> {

    private final PropertyDescriptor descriptor;
    private final PropertyDescriptor.Listener<Number> listener;

    private ObservableValue<? extends Number> observable = null;
    private ExpressionHelper<Number> helper = null;

    private final AccessControlContext acc = AccessController.getContext();

    JavaBeanDoubleProperty(PropertyDescriptor descriptor, Object bean) {
        this.descriptor = descriptor;
        this.listener = descriptor.new Listener<Number>(bean, this);
        descriptor.addListener(listener);
        Disposer.addRecord(this, new DescriptorListenerCleaner(descriptor, listener));
    }

    /**
     * {@inheritDoc}
     *
     * @throws UndeclaredThrowableException if calling the getter of the Java Bean
     * property throws an {@code IllegalAccessException} or an
     * {@code InvocationTargetException}.
     */
    @Override
    public double get() {
        return AccessController.doPrivileged((PrivilegedAction<Double>) () -> {
            try {
                return ((Number)MethodHelper.invoke(
                    descriptor.getGetter(), getBean(), (Object[])null)).doubleValue();
            } catch (IllegalAccessException e) {
                throw new UndeclaredThrowableException(e);
            } catch (InvocationTargetException e) {
                throw new UndeclaredThrowableException(e);
            }
        }, acc);
    }

    /**
     * {@inheritDoc}
     *
     * @throws UndeclaredThrowableException if calling the getter of the Java Bean
     * property throws an {@code IllegalAccessException} or an
     * {@code InvocationTargetException}.
     */
    @Override
    public void set(final double value) {
        if (isBound()) {
            throw new RuntimeException("A bound value cannot be set.");
        }

        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            try {
                MethodHelper.invoke(descriptor.getSetter(), getBean(), new Object[] {value});
                ExpressionHelper.fireValueChangedEvent(helper);
            } catch (IllegalAccessException e) {
                throw new UndeclaredThrowableException(e);
            } catch (InvocationTargetException e) {
                throw new UndeclaredThrowableException(e);
            }
            return null;
        }, acc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bind(ObservableValue<? extends Number> observable) {
        if (observable == null) {
            throw new NullPointerException("Cannot bind to null");
        }

        if (!observable.equals(this.observable)) {
            unbind();
            set(observable.getValue().doubleValue());
            this.observable = observable;
            this.observable.addListener(listener);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unbind() {
        if (observable != null) {
            observable.removeListener(listener);
            observable = null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBound() {
        return observable != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getBean() {
        return listener.getBean();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return descriptor.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(ChangeListener<? super Number> listener) {
        helper = ExpressionHelper.addListener(helper, this, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(ChangeListener<? super Number> listener) {
        helper = ExpressionHelper.removeListener(helper, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(InvalidationListener listener) {
        helper = ExpressionHelper.addListener(helper, this, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(InvalidationListener listener) {
        helper = ExpressionHelper.removeListener(helper, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fireValueChangedEvent() {
        ExpressionHelper.fireValueChangedEvent(helper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        descriptor.removeListener(listener);

    }

    /**
     * Returns a string representation of this {@code JavaBeanDoubleProperty} object.
     * @return a string representation of this {@code JavaBeanDoubleProperty} object.
     */
    @Override
    public String toString() {
        final Object bean = getBean();
        final String name = getName();
        final StringBuilder result = new StringBuilder("DoubleProperty [");
        if (bean != null) {
            result.append("bean: ").append(bean).append(", ");
        }
        if ((name != null) && (!name.equals(""))) {
            result.append("name: ").append(name).append(", ");
        }
        if (isBound()) {
            result.append("bound, ");
        }
        result.append("value: ").append(get());
        result.append("]");
        return result.toString();
    }
}
