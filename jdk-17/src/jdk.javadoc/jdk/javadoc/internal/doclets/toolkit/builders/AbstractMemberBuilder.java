/*
 * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.builders;

import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.DocletException;
import jdk.javadoc.internal.doclets.toolkit.util.VisibleMemberTable;
import jdk.javadoc.internal.doclets.toolkit.util.VisibleMemberTable.Kind;

/**
 * The superclass for all member builders.  Member builders are only executed
 * within Class Builders.  They essentially build sub-components.  For example,
 * method documentation is a sub-component of class documentation.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public abstract class AbstractMemberBuilder extends AbstractBuilder {

    protected final TypeElement typeElement;

    protected final VisibleMemberTable visibleMemberTable;

    /**
     * Construct a SubBuilder.
     * @param context a context object, providing information used in this run
     *        of the doclet.
     */
    public AbstractMemberBuilder(Context context, TypeElement typeElement) {
        super(context);
        this.typeElement = typeElement;
        visibleMemberTable = configuration.getVisibleMemberTable(typeElement);
    }

    /**
     * This method is not supported by sub-builders.
     *
     * @throws AssertionError always
     */
    @Override
    public void build() {
        // You may not call the build method in a subbuilder.
        throw new AssertionError();
    }

    /**
     *
     * Build the documentation.
     *
     * @param contentTree The content tree into which to add the documentation
     * @throws DocletException  if there is a problem building the documentation
     */
    public abstract void build(Content contentTree) throws DocletException;

    /**
     * Returns true if this subbuilder has anything to document.
     *
     * @return true if this subbuilder has anything to document
     */
    public abstract boolean hasMembersToDocument();

    /**
     * Returns a list of visible elements of the specified kind in this
     * type element.
     * @param kind of members
     * @return a list of members
     */
    protected List<? extends Element> getVisibleMembers(Kind kind) {
        return visibleMemberTable.getVisibleMembers(kind);
    }
}
