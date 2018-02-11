/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.javadoc.internal.doclets.formats.html.markup.Comment;
import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
import jdk.javadoc.internal.doclets.formats.html.markup.DocType;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlConstants;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlDocument;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTag;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
import jdk.javadoc.internal.doclets.formats.html.markup.StringContent;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;
import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
import jdk.javadoc.internal.doclets.toolkit.util.DocPaths;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlDocWriter.CONTENT_TYPE;

/**
 * Writes an index.html file that tries to redirect to an alternate page.
 * The redirect uses JavaSCript, if enabled, falling back on
 * {@code <meta http-eqiv=refresh content="0,<uri>">}.
 * If neither are supported/enabled in a browser, the page displays the
 * standard "JavaScipt not enabled" message, and a link to the alternate page.
 */
public class IndexRedirectWriter extends HtmlDocletWriter {

    public static void generate(ConfigurationImpl configuration)
            throws DocFileIOException {
        IndexRedirectWriter indexRedirect;
        DocPath filename = DocPaths.INDEX;
            indexRedirect = new IndexRedirectWriter(configuration, filename);
            indexRedirect.generateIndexFile();
    }

    IndexRedirectWriter(ConfigurationImpl configuration, DocPath filename) {
        super(configuration, filename);
    }

    /**
     * Generate an index file that redirects to an alternate file.
     * @throws DocFileIOException if there is a problem generating the file
     */
    void generateIndexFile() throws DocFileIOException {
        Content htmlDocType = configuration.isOutputHtml5()
                ? DocType.HTML5
                : DocType.TRANSITIONAL;
        Content htmlComment = new Comment(configuration.getText("doclet.New_Page"));
        Content head = new HtmlTree(HtmlTag.HEAD);
        head.addContent(getGeneratedBy(!configuration.notimestamp));

        String title = (configuration.windowtitle.length() > 0)
                ? configuration.windowtitle
                : configuration.getText("doclet.Generated_Docs_Untitled");

        Content windowTitle = HtmlTree.TITLE(new StringContent(title));
        head.addContent(windowTitle);
        Content metaContentType = HtmlTree.META("Content", CONTENT_TYPE,
                (configuration.charset.length() > 0) ?
                        configuration.charset : HtmlConstants.HTML_DEFAULT_CHARSET);
        head.addContent(metaContentType);

        String topFilePath = configuration.topFile.getPath();
        String javaScriptRefresh = "window.location.replace('" + topFilePath + "')";
        HtmlTree scriptTree = HtmlTree.SCRIPT();
        scriptTree.addContent(javaScriptRefresh);
        head.addContent(scriptTree);
        HtmlTree metaRefresh = new HtmlTree(HtmlTag.META);
        metaRefresh.addAttr(HtmlAttr.HTTP_EQUIV, "Refresh");
        metaRefresh.addAttr(HtmlAttr.CONTENT, "0;" + topFilePath);
        if (configuration.isOutputHtml5()) {
            head.addContent(HtmlTree.NOSCRIPT(metaRefresh));
        } else {
            head.addContent(metaRefresh);
        }

        head.addContent(getStyleSheetProperties(configuration));

        ContentBuilder bodyContent = new ContentBuilder();
        bodyContent.addContent(HtmlTree.NOSCRIPT(
                HtmlTree.P(configuration.getContent("doclet.No_Script_Message"))));

        bodyContent.addContent(HtmlTree.P(HtmlTree.A(topFilePath, new StringContent(topFilePath))));

        Content body = new HtmlTree(HtmlTag.BODY);
        if (configuration.allowTag(HtmlTag.MAIN)) {
            HtmlTree main = HtmlTree.MAIN(bodyContent);
            body.addContent(main);
        } else {
            body.addContent(bodyContent);
        }

        Content htmlTree = HtmlTree.HTML(configuration.getLocale().getLanguage(),
                head, body);
        Content htmlDocument = new HtmlDocument(htmlDocType,
                htmlComment, htmlTree);
        write(htmlDocument);

    }
}
