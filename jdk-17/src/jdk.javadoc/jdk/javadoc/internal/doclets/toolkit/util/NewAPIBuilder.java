/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.util;

import com.sun.source.doctree.DocTree;
import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration;

import javax.lang.model.element.Element;
import java.util.List;


import static com.sun.source.doctree.DocTree.Kind.SINCE;

/**
 * Build list of all the packages, classes, constructors, fields and methods
 * that were added in one of the releases specified by the {@code --since}
 * option. The release names must exactly match the names used in the javadoc
 * {@code @since} tags of the respective elements.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class NewAPIBuilder extends SummaryAPIListBuilder {

    public final List<String> releases;

    public NewAPIBuilder(BaseConfiguration configuration, List<String> releases) {
        super(configuration, element -> isNewAPI(element, configuration.utils, releases));
        this.releases = releases;
        buildSummaryAPIInfo();
    }

    private static boolean isNewAPI(Element e, Utils utils, List<String> releases) {
        if (!utils.hasDocCommentTree(e)) {
            return false;
        }
        List<? extends DocTree> since = utils.getBlockTags(e, SINCE);
        if (since.isEmpty()) {
            return false;
        }
        CommentHelper ch = utils.getCommentHelper(e);
        return since.stream().anyMatch(tree -> releases.contains(ch.getBody(tree).toString()));
    }
}
