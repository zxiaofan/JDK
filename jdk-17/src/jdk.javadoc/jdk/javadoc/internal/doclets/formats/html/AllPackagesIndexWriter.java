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

import javax.lang.model.element.PackageElement;

import jdk.javadoc.internal.doclets.formats.html.markup.BodyContents;
import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
import jdk.javadoc.internal.doclets.formats.html.Navigation.PageMode;
import jdk.javadoc.internal.doclets.formats.html.markup.Text;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;
import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
import jdk.javadoc.internal.doclets.toolkit.util.DocPaths;

/**
 * Generate the file with list of all the packages in this run.
 */
public class AllPackagesIndexWriter extends HtmlDocletWriter {

    /**
     * Construct AllPackagesIndexWriter object.
     *
     * @param configuration The current configuration
     * @param filename Path to the file which is getting generated.
     */
    public AllPackagesIndexWriter(HtmlConfiguration configuration, DocPath filename) {
        super(configuration, filename);
    }

    /**
     * Create AllPackagesIndexWriter object.
     *
     * @param configuration The current configuration
     * @throws DocFileIOException
     */
    public static void generate(HtmlConfiguration configuration) throws DocFileIOException {
        generate(configuration, DocPaths.ALLPACKAGES_INDEX);
    }

    private static void generate(HtmlConfiguration configuration, DocPath fileName) throws DocFileIOException {
        AllPackagesIndexWriter allPkgGen = new AllPackagesIndexWriter(configuration, fileName);
        allPkgGen.buildAllPackagesFile();
    }

    /**
     * Print all the packages in the file.
     */
    protected void buildAllPackagesFile() throws DocFileIOException {
        String label = resources.getText("doclet.All_Packages");
        Content mainContent = new ContentBuilder();
        addPackages(mainContent);
        Content titleContent = contents.allPackagesLabel;
        Content pHeading = HtmlTree.HEADING_TITLE(Headings.PAGE_TITLE_HEADING,
                HtmlStyle.title, titleContent);
        Content headerDiv = HtmlTree.DIV(HtmlStyle.header, pHeading);
        HtmlTree bodyTree = getBody(getWindowTitle(label));
        bodyTree.add(new BodyContents()
                .setHeader(getHeader(PageMode.ALL_PACKAGES))
                .addMainContent(headerDiv)
                .addMainContent(mainContent)
                .setFooter(getFooter()));
        printHtmlDocument(null, "package index", bodyTree);
    }

    /**
     * Add all the packages to the content tree.
     *
     * @param content HtmlTree content to which the links will be added
     */
    protected void addPackages(Content content) {
        Table table = new Table(HtmlStyle.summaryTable)
                .setCaption(Text.of(contents.packageSummaryLabel.toString()))
                .setHeader(new TableHeader(contents.packageLabel, contents.descriptionLabel))
                .setColumnStyles(HtmlStyle.colFirst, HtmlStyle.colLast);
        for (PackageElement pkg : configuration.packages) {
            if (!(options.noDeprecated() && utils.isDeprecated(pkg))) {
                Content packageLinkContent = getPackageLink(pkg, getLocalizedPackageName(pkg));
                Content summaryContent = new ContentBuilder();
                addSummaryComment(pkg, summaryContent);
                table.addRow(pkg, packageLinkContent, summaryContent);
            }
        }
        content.add(table);
    }
}
