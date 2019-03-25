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
package jdk.javadoc.internal.doclets.formats.html;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.sun.source.doctree.DocTree;
import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlConstants;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTag;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
import jdk.javadoc.internal.doclets.formats.html.markup.Navigation;
import jdk.javadoc.internal.doclets.formats.html.markup.Navigation.PageMode;
import jdk.javadoc.internal.doclets.formats.html.markup.Table;
import jdk.javadoc.internal.doclets.formats.html.markup.TableHeader;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;
import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
import jdk.javadoc.internal.doclets.toolkit.util.DocPaths;
import jdk.javadoc.internal.doclets.toolkit.util.IndexBuilder;

/**
 * Generate the file with list of all the classes in this run.
 */
public class AllClassesIndexWriter extends HtmlDocletWriter {

    /**
     * Index of all the classes.
     */
    protected IndexBuilder indexbuilder;

    /**
     * The HTML tree for main tag.
     */
    protected HtmlTree mainTree = HtmlTree.MAIN();

    private final Navigation navBar;

    /**
     * Construct AllClassesFrameWriter object. Also initializes the indexbuilder variable in this
     * class.
     *
     * @param configuration The current configuration
     * @param filename Path to the file which is getting generated.
     * @param indexbuilder Unicode based Index from {@link IndexBuilder}
     */
    public AllClassesIndexWriter(HtmlConfiguration configuration,
            DocPath filename, IndexBuilder indexbuilder) {
        super(configuration, filename);
        this.indexbuilder = indexbuilder;
        this.navBar = new Navigation(null, configuration, fixedNavDiv, PageMode.ALLCLASSES, path);
    }

    /**
     * Create AllClassesIndexWriter object.
     *
     * @param configuration The current configuration
     * @param indexBuilder IndexBuilder object for all classes index.
     * @throws DocFileIOException
     */
    public static void generate(HtmlConfiguration configuration,
            IndexBuilder indexBuilder) throws DocFileIOException {
        generate(configuration, indexBuilder, DocPaths.ALLCLASSES_INDEX);
    }

    private static void generate(HtmlConfiguration configuration, IndexBuilder indexBuilder,
            DocPath fileName) throws DocFileIOException {
        AllClassesIndexWriter allClassGen = new AllClassesIndexWriter(configuration,
                fileName, indexBuilder);
        allClassGen.buildAllClassesFile();
    }

    /**
     * Print all the classes in the file.
     */
    protected void buildAllClassesFile() throws DocFileIOException {
        String label = configuration.getText("doclet.All_Classes");
        HtmlTree bodyTree = getBody(true, getWindowTitle(label));
        HtmlTree htmlTree = (configuration.allowTag(HtmlTag.HEADER))
                ? HtmlTree.HEADER()
                : bodyTree;
        addTop(htmlTree);
        navBar.setUserHeader(getUserHeaderFooter(true));
        htmlTree.addContent(navBar.getContent(true));
        if (configuration.allowTag(HtmlTag.HEADER)) {
            bodyTree.addContent(htmlTree);
        }
        Content allClassesContent = new ContentBuilder();
        addContents(allClassesContent);
        if (configuration.allowTag(HtmlTag.MAIN)) {
            mainTree.addContent(allClassesContent);
            bodyTree.addContent(mainTree);
        } else {
            bodyTree.addContent(allClassesContent);
        }
        Content tree = (configuration.allowTag(HtmlTag.FOOTER))
                ? HtmlTree.FOOTER()
                : bodyTree;
        navBar.setUserFooter(getUserHeaderFooter(false));
        tree.addContent(navBar.getContent(false));
        addBottom(tree);
        if (configuration.allowTag(HtmlTag.FOOTER)) {
            bodyTree.addContent(tree);
        }
        printHtmlDocument(null, true, bodyTree);
    }

    /**
     * Add all types to the content tree.
     *
     * @param content HtmlTree content to which the links will be added
     */
    protected void addContents(Content content) {
        Table table = new Table(configuration.htmlVersion, HtmlStyle.typeSummary)
                .setSummary(resources.classTableSummary)
                .setHeader(new TableHeader(contents.classLabel, contents.descriptionLabel))
                .setRowScopeColumn(1)
                .setColumnStyles(HtmlStyle.colFirst, HtmlStyle.colLast)
                .setDefaultTab(resources.getText("doclet.All_Classes"))
                .addTab(resources.interfaceSummary, utils::isInterface)
                .addTab(resources.classSummary, e -> utils.isOrdinaryClass((TypeElement)e))
                .addTab(resources.enumSummary, utils::isEnum)
                .addTab(resources.exceptionSummary, e -> utils.isException((TypeElement)e))
                .addTab(resources.errorSummary, e -> utils.isError((TypeElement)e))
                .addTab(resources.annotationTypeSummary, utils::isAnnotationType)
                .setTabScript(i -> "show(" + i + ");")
                .setUseTBody(false)
                .setPutIdFirst(true);
        for (Character unicode : indexbuilder.index()) {
            for (Element element : indexbuilder.getMemberList(unicode)) {
                TypeElement typeElement = (TypeElement) element;
                if (!utils.isCoreClass(typeElement)) {
                    continue;
                }
                addTableRow(table, typeElement);
            }
        }
        Content titleContent = contents.allClassesLabel;
        Content pHeading = HtmlTree.HEADING(HtmlConstants.TITLE_HEADING, true,
                HtmlStyle.title, titleContent);
        Content headerDiv = HtmlTree.DIV(HtmlStyle.header, pHeading);
        content.addContent(headerDiv);
        if (!table.isEmpty()) {
            HtmlTree li = HtmlTree.LI(HtmlStyle.blockList, table.toContent());
            HtmlTree ul = HtmlTree.UL(HtmlStyle.blockList, li);
            HtmlTree div = new HtmlTree(HtmlTag.DIV);
            div.setStyle(HtmlStyle.allClassesContainer);
            div.addContent(ul);
            content.addContent(div);
            if (table.needsScript()) {
                getMainBodyScript().append(table.getScript());
            }
        }
    }

    /**
     * Add table row.
     *
     * @param table the table to which the row will be added
     * @param klass the type to be added to the table
     */
    protected void addTableRow(Table table, TypeElement klass) {
        List<Content> rowContents = new ArrayList<>();
        Content classLink = getLink(new LinkInfoImpl(
                configuration, LinkInfoImpl.Kind.INDEX, klass));
        ContentBuilder description = new ContentBuilder();
        if (utils.isDeprecated(klass)) {
            description.addContent(getDeprecatedPhrase(klass));
            List<? extends DocTree> tags = utils.getDeprecatedTrees(klass);
            if (!tags.isEmpty()) {
                addSummaryDeprecatedComment(klass, tags.get(0), description);
            }
        } else {
            addSummaryComment(klass, description);
        }
        rowContents.add(classLink);
        rowContents.add(description);
        table.addRow(klass, rowContents);
    }
}
