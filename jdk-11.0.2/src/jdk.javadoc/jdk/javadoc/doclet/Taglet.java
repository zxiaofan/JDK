/*
 * Copyright (c) 2001, 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;

/**
 * The interface for a custom taglet supported by doclets such as
 * the {@link jdk.javadoc.doclet.StandardDoclet standard doclet}.
 * Custom taglets are used to handle custom tags in documentation
 * comments.
 *
 * <p>A custom taglet must implement this interface, and must have
 * a public default constructor (i.e. a public constructor with no
 * parameters), by which, the doclet will instantiate and
 * register the custom taglet.
 *
 * @since 9
 */

public interface Taglet {

    /**
     * Returns the set of locations in which a tag may be used.
     * @return the set of locations in which a tag may be used
     */
    Set<Location> getAllowedLocations();

    /**
     * Indicates whether this taglet is for inline tags or not.
     * @return true if this taglet is for an inline tag, and false otherwise
     */
    boolean isInlineTag();

    /**
     * Returns the name of the tag.
     * @return the name of this custom tag.
     */
    String getName();

    /**
     * Initializes this taglet with the given doclet environment and doclet.
     *
     * @apiNote
     * The environment may be used to access utility classes for
     * {@link javax.lang.model.util.Elements elements} and
     * {@link javax.lang.model.util.Types types} if needed.
     *
     * @implSpec
     * This implementation does nothing.
     *
     * @param env the environment in which the doclet and taglet are running
     * @param doclet the doclet that instantiated this taglet
     */
    default void init(DocletEnvironment env, Doclet doclet) { }

    /**
     * Returns the string representation of a series of instances of
     * this tag to be included in the generated output.
     * If this taglet is for an {@link #isInlineTag inline} tag it will
     * be called once per instance of the tag, each time with a singleton list.
     * Otherwise, if this tag is a block tag, it will be called once per
     * comment, with a list of all the instances of the tag in a comment.
     * @param tags the list of instances of this tag
     * @param element the element to which the enclosing comment belongs
     * @return the string representation of the tags to be included in
     *  the generated output
     */
    String toString(List<? extends DocTree> tags, Element element);

    /**
     * The kind of location in which a tag may be used.
     */
    public static enum Location {
        /** In an Overview document. */
        OVERVIEW,
        /** In the documentation for a module. */
        MODULE,
        /** In the documentation for a package. */
        PACKAGE,
        /** In the documentation for a class, interface or enum. */
        TYPE,
        /** In the documentation for a constructor. */
        CONSTRUCTOR,
        /** In the documentation for a method. */
        METHOD,
        /** In the documentation for a field. */
        FIELD
    }
}
