/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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
import com.sun.source.doctree.SystemPropertyTree;
import jdk.javadoc.doclet.Taglet.Location;
import jdk.javadoc.internal.doclets.toolkit.Content;

import javax.lang.model.element.Element;
import java.util.EnumSet;

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
        super(DocTree.Kind.SYSTEM_PROPERTY, true, EnumSet.of(Location.CONSTRUCTOR, Location.METHOD, Location.FIELD,
                Location.PACKAGE, Location.MODULE, Location.TYPE));
    }

    @Override
    public Content getInlineTagOutput(Element element, DocTree tag, TagletWriter writer) {
        return writer.systemPropertyTagOutput(element, (SystemPropertyTree) tag);
    }
}
