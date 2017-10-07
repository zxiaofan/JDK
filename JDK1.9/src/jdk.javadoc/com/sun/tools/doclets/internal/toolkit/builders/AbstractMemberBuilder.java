/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.builders;

import java.util.Set;

import com.sun.tools.doclets.internal.toolkit.*;
import com.sun.tools.doclets.internal.toolkit.util.*;

/**
 * The superclass for all member builders.  Member builders are only executed
 * within Class Builders.  They essentially build sub-components.  For example,
 * method documentation is a sub-component of class documentation.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @since 1.5
 */
@Deprecated
public abstract class AbstractMemberBuilder extends AbstractBuilder {

    /**
     * Construct a SubBuilder.
     * @param configuration the configuration used in this run
     *        of the doclet.
     */
    public AbstractMemberBuilder(Context context) {
        super(context);
    }

    /**
     * This method is not supported by sub-builders.
     *
     * @throws DocletAbortException this method will always throw a
     * DocletAbortException because it is not supported.
     */
    public void build() throws DocletAbortException {
        //You may not call the build method in a subbuilder.
        throw new DocletAbortException("not supported");
    }


    /**
     * Build the sub component if there is anything to document.
     *
     * @param node the XML element that specifies which components to document.
     * @param contentTree content tree to which the documentation will be added
     */
    @Override
    public void build(XMLNode node, Content contentTree) {
        if (hasMembersToDocument()) {
            super.build(node, contentTree);
        }
    }

    /**
     * Return true if this subbuilder has anything to document.
     *
     * @return true if this subbuilder has anything to document.
     */
    public abstract boolean hasMembersToDocument();
}
