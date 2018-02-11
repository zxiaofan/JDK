/*
 * Copyright (c) 2001, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.taglets;

import com.sun.javadoc.*;
import com.sun.tools.doclets.internal.toolkit.Content;
import com.sun.tools.doclets.internal.toolkit.util.*;

/**
 * A taglet that represents the @return tag.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @since 1.4
 */
@Deprecated
public class ReturnTaglet extends BaseExecutableMemberTaglet
        implements InheritableTaglet {

    public ReturnTaglet() {
        name = "return";
    }

    /**
     * {@inheritDoc}
     */
    public void inherit(DocFinder.Input input, DocFinder.Output output) {
       Tag[] tags = input.element.tags("return");
        if (tags.length > 0) {
            output.holder = input.element;
            output.holderTag = tags[0];
            output.inlineTags = input.isFirstSentence ?
                tags[0].firstSentenceTags() : tags[0].inlineTags();
        }
    }

    /**
     * Return true if this <code>Taglet</code>
     * is used in constructor documentation.
     * @return true if this <code>Taglet</code>
     * is used in constructor documentation and false
     * otherwise.
     */
    public boolean inConstructor() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public Content getTagletOutput(Doc holder, TagletWriter writer) {
        Type returnType = ((MethodDoc) holder).returnType();
        Tag[] tags = holder.tags(name);

        //Make sure we are not using @return tag on method with void return type.
        if (returnType.isPrimitive() && returnType.typeName().equals("void")) {
            if (tags.length > 0) {
                writer.getMsgRetriever().warning(holder.position(),
                    "doclet.Return_tag_on_void_method");
            }
            return null;
        }
        //Inherit @return tag if necessary.
        if (tags.length == 0) {
            DocFinder.Output inheritedDoc =
                DocFinder.search(writer.configuration(), new DocFinder.Input((MethodDoc) holder, this));
            tags = inheritedDoc.holderTag == null ? tags : new Tag[] {inheritedDoc.holderTag};
        }
        return tags.length > 0 ? writer.returnTagOutput(tags[0]) : null;
    }
}
