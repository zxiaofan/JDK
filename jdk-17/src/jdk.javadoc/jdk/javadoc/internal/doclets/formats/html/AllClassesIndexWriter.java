/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Set;

import javax.lang.model.element.TypeElement;

import com.sun.source.doctree.DeprecatedTree;
import jdk.javadoc.internal.doclets.formats.html.markup.BodyContents;
import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
import jdk.javadoc.internal.doclets.formats.html.Navigation.PageMode;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;
import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
import jdk.javadoc.internal.doclets.toolkit.util.DocPaths;
import jdk.javadoc.internal.doclets.toolkit.util.IndexBuilder;
import jdk.javadoc.internal.doclets.toolkit.util.IndexItem;
import jdk.javadoc.internal.doclets.toolkit.util.Utils.ElementFlag;

/**
 * Generate the file with list of all the classes in this run.
 */
public class AllClassesIndexWriter extends HtmlDocletWriter {

    /**
     * Index of all the classes.
     */
    protected IndexBuilder indexBuilder;

    /**
     * Construct AllClassesIndexWriter object. Also initializes the indexBuilder variable in this
     * class.
     *
     * @param configuration The current configuration
     * @param filename Path to the file which is getting generated.
     * @param indexBuilder Unicode based Index from {@link IndexBuilder}
     */
    public AllClassesIndexWriter(HtmlConfiguration configuration,
            DocPath filename, IndexBuilder indexBuilder) {
        super(configuration, filename);
        this.indexBuilder = indexBuilder;
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
        String label = resources.getText("doclet.All_Classes_And_Interfaces");
        Content allClassesContent = new ContentBuilder();
        addContents(allClassesContent);
        Content mainContent = new ContentBuilder();
        mainContent.add(allClassesContent);
        HtmlTree bodyTree = getBody(getWindowTitle(label));
        bodyTree.add(new BodyContents()
                .setHeader(getHeader(PageMode.ALL_CLASSES))
                .addMainContent(mainContent)
                .setFooter(getFooter()));
        printHtmlDocument(null, "class index", bodyTree);
    }

    /**
     * Add all types to the content tree.
     *
     * @param content HtmlTree content to which the links will be added
     */
    protected void addContents(Content content) {
        Table table = new Table(HtmlStyle.summaryTable)
                .setHeader(new TableHeader(contents.classLabel, contents.descriptionLabel))
                .setColumnStyles(HtmlStyle.colFirst, HtmlStyle.colLast)
                .setId(HtmlIds.ALL_CLASSES_TABLE)
                .setDefaultTab(contents.allClassesAndInterfacesLabel)
                .addTab(contents.interfaces, utils::isInterface)
                .addTab(contents.classes, e -> utils.isOrdinaryClass((TypeElement)e))
                .addTab(contents.enums, utils::isEnum)
                .addTab(contents.records, e -> utils.isRecord((TypeElement)e))
                .addTab(contents.exceptions, e -> utils.isException((TypeElement)e))
                .addTab(contents.errors, e -> utils.isError((TypeElement)e))
                .addTab(contents.annotationTypes, utils::isAnnotationType);
        for (Character unicode : indexBuilder.getFirstCharacters()) {
            for (IndexItem indexItem : indexBuilder.getItems(unicode)) {
                TypeElement typeElement = (TypeElement) indexItem.getElement();
                if (typeElement != null && utils.isCoreClass(typeElement)) {
                    addTableRow(table, typeElement);
                }
            }
        }
        Content titleContent = contents.allClassesAndInterfacesLabel;
        Content pHeading = HtmlTree.HEADING_TITLE(Headings.PAGE_TITLE_HEADING,
                HtmlStyle.title, titleContent);
        Content headerDiv = HtmlTree.DIV(HtmlStyle.header, pHeading);
        content.add(headerDiv);
        if (!table.isEmpty()) {
            content.add(table);
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
        Content classLink = getLink(new HtmlLinkInfo(
                configuration, HtmlLinkInfo.Kind.INDEX, klass));
        ContentBuilder description = new ContentBuilder();
        Set<ElementFlag> flags = utils.elementFlags(klass);
        if (flags.contains(ElementFlag.PREVIEW)) {
            description.add(contents.previewPhrase);
            addSummaryComment(klass, description);
        } else if (flags.contains(ElementFlag.DEPRECATED)) {
            description.add(getDeprecatedPhrase(klass));
            List<? extends DeprecatedTree> tags = utils.getDeprecatedTrees(klass);
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
