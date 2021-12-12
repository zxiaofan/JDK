/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclint;

import java.util.ServiceLoader;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;

/**
 * The base class for the DocLint service used by javac.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public abstract class DocLint implements Plugin {
    public static final String XMSGS_OPTION = "-Xmsgs";
    public static final String XMSGS_CUSTOM_PREFIX = "-Xmsgs:";
    public static final String XCHECK_PACKAGE = "-XcheckPackage:";

    private static ServiceLoader.Provider<DocLint> docLintProvider;

    public abstract boolean isValidOption(String opt);

    public static synchronized DocLint newDocLint() {
        if (docLintProvider == null) {
            docLintProvider = ServiceLoader.load(DocLint.class, ClassLoader.getSystemClassLoader()).stream()
                    .filter(p_ -> p_.get().getName().equals("doclint"))
                    .findFirst()
                    .orElse(new ServiceLoader.Provider<>() {
                        @Override
                        public Class<? extends DocLint> type() {
                            return NoDocLint.class;
                        }

                        @Override
                        public DocLint get() {
                            return new NoDocLint();
                        }
                    });
        }
        return docLintProvider.get();
    }

    private static class NoDocLint extends DocLint {
        @Override
        public String getName() {
            return "doclint-not-available";
        }

        @Override
        public void init(JavacTask task, String... args) {
            throw new IllegalStateException("doclint not available");
        }

        @Override
        public boolean isValidOption(String s) {
            // passively accept all "plausible" options
            return s.equals(XMSGS_OPTION)
                    || s.startsWith(XMSGS_CUSTOM_PREFIX)
                    || s.startsWith(XCHECK_PACKAGE);
        }
    }
}
