/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.util.List;

import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.SeeTree;
import jdk.javadoc.doclet.Taglet.Location;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.CommentHelper;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Input;
import jdk.javadoc.internal.doclets.toolkit.util.Utils;

/**
 * A taglet that represents the @see tag.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class SeeTaglet extends BaseTaglet implements InheritableTaglet {

    public SeeTaglet() {
        super(DocTree.Kind.SEE, false, EnumSet.allOf(Location.class));
    }

    @Override
    public void inherit(DocFinder.Input input, DocFinder.Output output) {
        List<? extends SeeTree> tags = input.utils.getSeeTrees(input.element);
        if (!tags.isEmpty()) {
            CommentHelper ch =  input.utils.getCommentHelper(input.element);
            output.holder = input.element;
            output.holderTag = tags.get(0);
            output.inlineTags = input.isFirstSentence
                    ? ch.getFirstSentenceTrees(output.holderTag)
                    : ch.getReference(output.holderTag);
        }
    }

    @Override
    public Content getAllBlockTagOutput(Element holder, TagletWriter writer) {
        Utils utils = writer.configuration().utils;
        List<? extends SeeTree> tags = utils.getSeeTrees(holder);
        Element e = holder;
        if (tags.isEmpty() && utils.isExecutableElement(holder)) {
            Input input = new DocFinder.Input(utils, holder, this);
            DocFinder.Output inheritedDoc = DocFinder.search(writer.configuration(), input);
            if (inheritedDoc.holder != null) {
                tags = utils.getSeeTrees(inheritedDoc.holder);
                e = inheritedDoc.holder;
            }
        }
        return writer.seeTagOutput(e, tags);
    }
}
