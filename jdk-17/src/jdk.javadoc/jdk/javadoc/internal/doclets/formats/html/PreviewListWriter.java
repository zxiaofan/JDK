/*
 * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.formats.html;

import java.util.List;

import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
import jdk.javadoc.internal.doclets.formats.html.Navigation.PageMode;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;
import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
import jdk.javadoc.internal.doclets.toolkit.util.DocPaths;
import jdk.javadoc.internal.doclets.toolkit.util.PreviewAPIListBuilder;

/**
 * Generate File to list all the preview elements with the
 * appropriate links.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @see java.util.List
 */
public class PreviewListWriter extends SummaryListWriter<PreviewAPIListBuilder> {

    /**
     * Constructor.
     *
     * @param configuration the configuration for this doclet
     * @param filename the file to be generated
     */

    public PreviewListWriter(HtmlConfiguration configuration, DocPath filename) {
        super(configuration, filename, PageMode.PREVIEW, "preview elements",
              configuration.contents.previewAPI, "doclet.Window_Preview_List");
    }

    /**
     * Get list of all the preview elements.
     * Then instantiate PreviewListWriter and generate File.
     *
     * @param configuration the current configuration of the doclet.
     * @throws DocFileIOException if there is a problem writing the preview list
     */
    public static void generate(HtmlConfiguration configuration) throws DocFileIOException {
        if (configuration.conditionalPages.contains(HtmlConfiguration.ConditionalPage.PREVIEW)) {
            DocPath filename = DocPaths.PREVIEW_LIST;
            PreviewListWriter depr = new PreviewListWriter(configuration, filename);
            depr.generateSummaryListFile(configuration.previewAPIListBuilder);
        }
    }

    @Override
    protected void addComments(Element e, Content desc) {
        List<? extends DocTree> tags = utils.getFirstSentenceTrees(e);
        if (!tags.isEmpty()) {
            addPreviewComment(e, tags, desc);
        } else {
            desc.add(HtmlTree.EMPTY);
        }
    }

}
