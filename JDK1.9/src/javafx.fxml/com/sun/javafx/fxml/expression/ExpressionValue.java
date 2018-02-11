/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.fxml.expression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import com.sun.javafx.fxml.BeanAdapter;

/**
 * Class representing an observable expression value.
 */
public class ExpressionValue extends ObservableValueBase<Object> {
    // Monitors a namespace for changes along a key path
    private class KeyPathMonitor {
        private String key;
        private KeyPathMonitor next;

        private Object namespace = null;

        private ListChangeListener<Object> listChangeListener = new ListChangeListener<Object>() {
            @Override
            public void onChanged(Change<? extends Object> change) {
                while (change.next()) {
                    int index = Integer.parseInt(key);

                    if (index >= change.getFrom() && index < change.getTo()) {
                        fireValueChangedEvent();
                        remonitor();
                    }
                }
            }
        };

        private MapChangeListener<String, Object> mapChangeListener = new MapChangeListener<String, Object>() {
            @Override
            public void onChanged(Change<? extends String, ? extends Object> change) {
                if (key.equals(change.getKey())) {
                    fireValueChangedEvent();
                    remonitor();
                }
            }
        };

        private ChangeListener<Object> propertyChangeListener = new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                fireValueChangedEvent();
                remonitor();
            }
        };

        public KeyPathMonitor(Iterator<String> keyPathIterator) {
            this.key = keyPathIterator.next();

            if (keyPathIterator.hasNext()) {
                next = new KeyPathMonitor(keyPathIterator);
            } else {
                next = null;
            }
        }

        @SuppressWarnings("unchecked")
        public void monitor(Object namespace) {
            if (namespace instanceof ObservableList<?>) {
                ((ObservableList<Object>)namespace).addListener(listChangeListener);
            } else if (namespace instanceof ObservableMap<?, ?>) {
                ((ObservableMap<String, Object>)namespace).addListener(mapChangeListener);
            } else {
                BeanAdapter namespaceAdapter = new BeanAdapter(namespace);
                ObservableValue<Object> propertyModel = namespaceAdapter.getPropertyModel(key);

                if (propertyModel != null) {
                    propertyModel.addListener(propertyChangeListener);
                }

                namespace = namespaceAdapter;
            }

            this.namespace = namespace;

            if (next != null) {
                Object value = Expression.get(namespace, key);
                if (value != null) {
                    next.monitor(value);
                }
            }
        }

        @SuppressWarnings("unchecked")
        public void unmonitor() {
            if (namespace instanceof ObservableList<?>) {
                ((ObservableList<Object>)namespace).removeListener(listChangeListener);
            } else if (namespace instanceof ObservableMap<?, ?>) {
                ((ObservableMap<String, Object>)namespace).removeListener(mapChangeListener);
            } else if (namespace != null) {
                BeanAdapter namespaceAdapter = (BeanAdapter)namespace;
                ObservableValue<Object> propertyModel = namespaceAdapter.getPropertyModel(key);

                if (propertyModel != null) {
                    propertyModel.removeListener(propertyChangeListener);
                }
            }

            namespace = null;

            if (next != null) {
                next.unmonitor();
            }
        }

        public void remonitor() {
            if (next != null) {
                next.unmonitor();
                Object value = Expression.get(namespace, key);
                if (value != null) {
                    next.monitor(value);
                }
            }
        }
    }

    private Object namespace;
    private Expression expression;
    private Class<?> type;

    private ArrayList<KeyPathMonitor> argumentMonitors;

    private int listenerCount = 0;

    public ExpressionValue(Object namespace, Expression expression, Class<?> type) {
        if (namespace == null) {
            throw new NullPointerException();
        }

        if (expression == null) {
            throw new NullPointerException();
        }

        if (type == null) {
            throw new NullPointerException();
        }

        this.namespace = namespace;
        this.expression = expression;
        this.type = type;

        List<KeyPath> arguments = expression.getArguments();
        argumentMonitors = new ArrayList<KeyPathMonitor>(arguments.size());

        for (KeyPath argument : arguments) {
            argumentMonitors.add(new KeyPathMonitor(argument.iterator()));
        }
    }

    @Override
    public Object getValue() {
        return BeanAdapter.coerce(expression.evaluate(namespace), type);
    }

    @Override
    public void addListener(InvalidationListener listener) {
        if (listenerCount == 0) {
            monitorArguments();
        }

        super.addListener(listener);
        listenerCount++;
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        super.removeListener(listener);
        listenerCount--;

        if (listenerCount == 0) {
            unmonitorArguments();
        }
    }

    @Override
    public void addListener(ChangeListener<? super Object> listener) {
        if (listenerCount == 0) {
            monitorArguments();
        }

        super.addListener(listener);
        listenerCount++;
    }

    @Override
    public void removeListener(ChangeListener<? super Object> listener) {
        super.removeListener(listener);
        listenerCount--;

        if (listenerCount == 0) {
            unmonitorArguments();
        }
    }

    private void monitorArguments() {
        for (KeyPathMonitor argumentMonitor : argumentMonitors) {
            argumentMonitor.monitor(namespace);
        }
    }

    private void unmonitorArguments() {
        for (KeyPathMonitor argumentMonitor : argumentMonitors) {
            argumentMonitor.unmonitor();
        }
    }
}
