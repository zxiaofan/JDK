/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.source.doctree.DocTree;
import jdk.javadoc.internal.doclets.toolkit.Content;

import javax.lang.model.element.Element;
import java.util.EnumSet;

import static com.sun.source.doctree.DocTree.Kind.SYSTEM_PROPERTY;

/**
 * A taglet that represents the {@code @systemProperty} tag.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */

public class SystemPropertyTaglet extends BaseTaglet {

    SystemPropertyTaglet(){
        super(SYSTEM_PROPERTY.tagName, true, EnumSet.of(Site.CONSTRUCTOR, Site.METHOD, Site.FIELD,
                Site.PACKAGE, Site.MODULE, Site.TYPE));
    }

    @Override
    public Content getTagletOutput(Element element, DocTree tag, TagletWriter writer) {
        return writer.systemPropertyTagOutput(element, tag);
    }
}
