/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.taglets;

import java.util.Set;
import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;
import jdk.javadoc.doclet.Taglet.Location;
import jdk.javadoc.internal.doclets.toolkit.Content;

/**
 * This is the Taglet interface used internally within the doclet.
 */

public interface Taglet {
    /**
     * Returns the set of allowed locations for a block tag handled by this taglet.
     *
     * @return the set of allowable locations
     */
    Set<Location> getAllowedLocations();

    /**
     * Indicates whether this {@code Taglet} can be used in field documentation.
     *
     * @return {@code true} if this {@code Taglet} can be used in field documentation
     *         and {@code false} otherwise
     */
    boolean inField();

    /**
     * Indicates whether this {@code Taglet} can be used in constructor documentation.
     *
     * @return {@code true} if this {@code Taglet} can be used in constructor documentation
     *         and {@code false} otherwise
     */
    boolean inConstructor();

    /**
     * Indicates whether this {@code Taglet} can be used in method documentation.
     *
     * @return {@code true} if this {@code Taglet} can be used in method documentation
     *         and {@code false} otherwise
     */
    boolean inMethod();

    /**
     * Indicates whether this {@code Taglet} can be used in overview documentation.
     *
     * @return {@code true} if this {@code Taglet} can be used in overview documentation
     *         and {@code false} otherwise
     */
    boolean inOverview();

    /**
     * Indicates whether this {@code Taglet} can be used in module documentation.
     *
     * @return {@code true} if this {@code Taglet} can be used in module documentation
     *         and {@code false} otherwise
     */
    boolean inModule();

    /**
     * Indicates whether this {@code Taglet} can be used in package documentation.
     *
     * @return {@code true} if this {@code Taglet} can be used in package documentation
     *         and {@code false} otherwise
     */
    boolean inPackage();

    /**
     * Indicates whether this {@code Taglet} can be used in type documentation (classes or interfaces).
     *
     * @return {@code true} if this {@code Taglet} can be used in type documentation
     *         and {@code false} otherwise
     */
    boolean inType();

    /**
     * Indicates whether this {@code Taglet} represents an inline tag.
     *
     * @return {@code true} if this {@code Taglet} represents an inline tag
     *         and {@code false} otherwise
     */
    boolean isInlineTag();

    /**
     * Indicates whether this {@code Taglet} represents a block tag.
     *
     * @return {@code true} if this {@code Taglet} represents a block tag
     * @implSpec This implementation returns the inverse
     * result to {@code isInlineTag}.
     */
    default boolean isBlockTag() {
        return !isInlineTag();
    }

    /**
     * Returns the name of this tag.
     * @return the name of this tag
     */
    String getName();

    /**
     * Returns the content to be included in the generated output for an
     * instance of an inline tag handled by this taglet.
     *
     * @param owner  the element for the enclosing doc comment
     * @param tag    the tag
     * @param writer the taglet-writer used in this doclet
     *
     * @return the output for this tag
     * @throws UnsupportedTagletOperationException if the method is not supported by the taglet
     */
    Content getInlineTagOutput(Element owner, DocTree tag, TagletWriter writer) throws
            UnsupportedTagletOperationException;

    /**
     * Returns the content to be included in the generated output for
     * all instances of block tags handled by this taglet.
     *
     * @param owner  the element for the enclosing doc comment
     * @param writer the taglet-writer used in this doclet
     *
     * @return the output for this tag
     * @throws UnsupportedTagletOperationException if the method is not supported by the taglet
     */
    Content getAllBlockTagOutput(Element owner, TagletWriter writer) throws
            UnsupportedTagletOperationException;

    class UnsupportedTagletOperationException extends UnsupportedOperationException {
        private static final long serialVersionUID = -3530273193380250271L;
        public UnsupportedTagletOperationException(String message) {
            super(message);
        }
    }
}
