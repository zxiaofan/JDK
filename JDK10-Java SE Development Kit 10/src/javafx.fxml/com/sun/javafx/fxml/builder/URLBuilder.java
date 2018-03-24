/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.fxml.builder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import javafx.util.Builder;

/**
 * Builder for constructing URL instances.
 */
public class URLBuilder extends AbstractMap<String, Object> implements Builder<URL> {
    private ClassLoader classLoader;

    private Object value = null;

    public static final String VALUE_KEY = "value";

    public URLBuilder(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public Object put(String key, Object value) {
        if (key == null) {
            throw new NullPointerException();
        }

        if (key.equals(VALUE_KEY)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException(key + " is not a valid property.");
        }

        return null;
    }

    @Override
    public URL build() {
        if (value == null) {
            throw new IllegalStateException();
        }

        URL url;
        if (value instanceof URL) {
            url = (URL)value;
        } else {
            String spec = value.toString();

            if (spec.startsWith("/")) {
                // FIXME: JIGSAW -- use Class.getResourceAsStream if resource is in a module
                url = classLoader.getResource(spec);
            } else {
                try {
                    url = new URL(spec);
                } catch (MalformedURLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }

        return url;
    }

    @Override
    public Set<Map.Entry<String, Object>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
