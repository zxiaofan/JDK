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
import com.sun.source.doctree.UnknownBlockTagTree;
import jdk.javadoc.doclet.Taglet.Location;
import jdk.javadoc.internal.doclets.toolkit.Content;

/**
 * A base class that implements the {@link Taglet} interface.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class BaseTaglet implements Taglet {

    protected final DocTree.Kind tagKind;
    protected final String name;
    private final boolean inline;
    private final Set<Location> sites;

    BaseTaglet(DocTree.Kind tagKind, boolean inline, Set<Location> sites) {
        this(tagKind.tagName, tagKind, inline, sites);
    }

    BaseTaglet(String name, boolean inline, Set<Location> sites) {
        this(name, inline ? DocTree.Kind.UNKNOWN_INLINE_TAG : DocTree.Kind.UNKNOWN_BLOCK_TAG, inline, sites);
    }

    private BaseTaglet(String name, DocTree.Kind tagKind, boolean inline, Set<Location> sites) {
        this.name = name;
        this.tagKind = tagKind;
        this.inline = inline;
        this.sites = sites;
    }

    @Override
    public Set<Location> getAllowedLocations() {
        return sites;
    }

    @Override
    public final boolean inField() {
        return sites.contains(Location.FIELD);
    }

    @Override
    public final boolean inConstructor() {
        return sites.contains(Location.CONSTRUCTOR);
    }

    @Override
    public final boolean inMethod() {
        return sites.contains(Location.METHOD);
    }

    @Override
    public final boolean inOverview() {
        return sites.contains(Location.OVERVIEW);
    }

    @Override
    public final boolean inModule() {
        return sites.contains(Location.MODULE);
    }

    @Override
    public final boolean inPackage() {
        return sites.contains(Location.PACKAGE);
    }

    @Override
    public final boolean inType() {
        return sites.contains(Location.TYPE);
    }

    @Override
    public final boolean isInlineTag() {
        return inline;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the kind of trees recognized by this taglet.
     *
     * @return the kind of trees recognized by this taglet
     */
    public DocTree.Kind getTagKind() {
        return tagKind;
    }

    /**
     * Returns whether or not this taglet accepts a {@code DocTree} node.
     * The taglet accepts a tree node if it has the same kind, and
     * if the kind is {@code UNKNOWN_BLOCK_TAG} the same tag name.
     *
     * @param tree the tree node
     * @return {@code true} if this taglet accepts this tree node
     */
    public boolean accepts(DocTree tree) {
        return (tree.getKind() == DocTree.Kind.UNKNOWN_BLOCK_TAG
                    && tagKind == DocTree.Kind.UNKNOWN_BLOCK_TAG)
                ? ((UnknownBlockTagTree) tree).getTagName().equals(name)
                : tree.getKind() == tagKind;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec This implementation throws {@link UnsupportedTagletOperationException}.
     */
    @Override
    public Content getInlineTagOutput(Element element, DocTree tag, TagletWriter writer) {
        throw new UnsupportedTagletOperationException("Method not supported in taglet " + getName() + ".");
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec This implementation throws {@link UnsupportedTagletOperationException}
     */
    @Override
    public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
        throw new UnsupportedTagletOperationException("Method not supported in taglet " + getName() + ".");
    }
}
