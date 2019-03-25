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

package jdk.javadoc.internal.doclets.toolkit.taglets;

import java.util.EnumSet;
import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;
import jdk.javadoc.internal.doclets.toolkit.Content;

import static com.sun.source.doctree.DocTree.Kind.DEPRECATED;

/**
 * A taglet that represents the @deprecated tag.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 */

public class DeprecatedTaglet extends BaseTaglet {

    public DeprecatedTaglet() {
        super(DEPRECATED.tagName, false,
                EnumSet.of(Site.MODULE, Site.TYPE, Site.CONSTRUCTOR, Site.METHOD, Site.FIELD));
    }

    @Override
    public Content getTagletOutput(Element holder, TagletWriter writer) {
        return writer.deprecatedTagOutput(holder);
    }
}
