/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.tools.DocumentationTool.DocumentationTask;
import javax.tools.JavaFileObject;

import com.sun.tools.javac.main.Option;
import com.sun.tools.javac.util.ClientCodeException;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;
import jdk.javadoc.internal.tool.Start;

/**
 * Provides access to functionality specific to the JDK documentation tool,
 * javadoc.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own
 * risk.  This code and its internal interfaces are subject to change
 * or deletion without notice.</b></p>
 */
public class JavadocTaskImpl implements DocumentationTask {
    private final AtomicBoolean used = new AtomicBoolean();

    private final Context context;
    private final Class<?> docletClass;
    private final Iterable<String> options;
    private final Iterable<? extends JavaFileObject> fileObjects;
    private Locale locale;
    private final List<String> addModules = new ArrayList<>();

    public JavadocTaskImpl(Context context,
                           Class<?> docletClass,
                           Iterable<String> options,
                           Iterable<? extends JavaFileObject> fileObjects)
    {
        this.context = context;
        this.docletClass = docletClass;

        this.options = (options == null) ? Collections.emptySet()
                : nullCheck(options);
        this.fileObjects = (fileObjects == null) ? Collections.emptySet()
                : nullCheck(fileObjects);
        setLocale(Locale.getDefault());
    }

    @Override
    public void setLocale(Locale locale) {
        if (used.get()) {
            throw new IllegalStateException();
        }
        this.locale = locale;
    }

    @Override
    public void addModules(Iterable<String> moduleNames) {
        nullCheck(moduleNames);
        if (used.get()) {
            throw new IllegalStateException();
        }
        for (String name : moduleNames) {
            addModules.add(name);
        }
    }

    @Override
    public Boolean call() {
        if (used.getAndSet(true)) {
            throw new IllegalStateException("multiple calls to method 'call'");
        }
        initContext();
        Start jdoc = new Start(context);
        try {
            return jdoc.begin(docletClass, options, fileObjects);
        } catch (ClientCodeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private void initContext() {
        //initialize compiler's default locale
        context.put(Locale.class, locale);
        if (!addModules.isEmpty()) {
            String names = String.join(",", addModules);
            Options opts = Options.instance(context);
            String prev = opts.get(Option.ADD_MODULES);
            opts.put(Option.ADD_MODULES, (prev == null) ? names : prev + "," + names);
        }
    }

    private static <T> Iterable<T> nullCheck(Iterable<T> items) {
        for (T item : items) {
            if (item == null)
                throw new NullPointerException();
        }
        return items;
    }
}
