/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.doclet;

import java.util.Locale;
import java.util.Set;

import javax.lang.model.SourceVersion;

import jdk.javadoc.internal.doclets.formats.html.HtmlDoclet;

/**
 * This doclet generates HTML-formatted documentation for the specified modules,
 * packages and types.
 *
 * @see <a href="{@docRoot}/../specs/doc-comment-spec.html">
 *      Documentation Comment Specification for the Standard Doclet</a>
 */
public class StandardDoclet implements Doclet {

    private final HtmlDoclet htmlDoclet;

    public StandardDoclet() {
        htmlDoclet = new HtmlDoclet(this);
    }

    @Override
    public void init(Locale locale, Reporter reporter) {
        htmlDoclet.init(locale, reporter);
    }

    @Override
    public String getName() {
        return "Standard";
    }

    @Override
    public Set<Doclet.Option> getSupportedOptions() {
        return htmlDoclet.getSupportedOptions();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return htmlDoclet.getSupportedSourceVersion();
    }

    @Override
    public boolean run(DocletEnvironment docEnv) {
        return htmlDoclet.run(docEnv);
    }
}
