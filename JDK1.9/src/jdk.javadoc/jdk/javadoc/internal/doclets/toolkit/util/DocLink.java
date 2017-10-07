/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.util;

/**
 * Abstraction for simple relative URIs, consisting of a path,
 * an optional query, and an optional fragment. DocLink objects can
 * be created by the constructors below or from a DocPath using the
 * convenience methods, {@link DocPath#fragment fragment} and
 * {@link DocPath#query query}.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 */
public class DocLink {
    final String path;
    final String query;
    final String fragment;

    /** Create a DocLink representing the URI {@code #fragment}. */
    public static DocLink fragment(String fragment) {
        return new DocLink((String) null, (String) null, fragment);
    }

    /** Create a DocLink representing the URI {@code path}. */
    public DocLink(DocPath path) {
        this(path.getPath(), null, null);
    }

    /**
     * Create a DocLink representing the URI {@code path?query#fragment}.
     * query and fragment may be null.
     */
    public DocLink(DocPath path, String query, String fragment) {
        this(path.getPath(), query, fragment);
    }

    /**
     * Create a DocLink representing the URI {@code path?query#fragment}.
     * Any of the component parts may be null.
     */
    public DocLink(String path, String query, String fragment) {
        this.path = path;
        this.query = query;
        this.fragment = fragment;
    }

    /**
     * Return the link in the form "path?query#fragment", omitting any empty
     * components.
     */
    @Override
    public String toString() {
        // common fast path
        if (path != null && isEmpty(query) && isEmpty(fragment))
            return path;

        StringBuilder sb = new StringBuilder();
        if (path != null)
            sb.append(path);
        if (!isEmpty(query))
            sb.append("?").append(query);
        if (!isEmpty(fragment))
            sb.append("#").append(fragment);
        return sb.toString();
    }

    private static boolean isEmpty(String s) {
        return (s == null) || s.isEmpty();
    }
}
