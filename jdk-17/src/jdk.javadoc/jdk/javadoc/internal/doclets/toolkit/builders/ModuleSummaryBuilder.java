/*
 * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.builders;

import javax.lang.model.element.ModuleElement;

import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.DocFilesHandler;
import jdk.javadoc.internal.doclets.toolkit.DocletException;
import jdk.javadoc.internal.doclets.toolkit.ModuleSummaryWriter;


/**
 * Builds the summary for a given module.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ModuleSummaryBuilder extends AbstractBuilder {

    /**
     * The module being documented.
     */
    private final ModuleElement mdle;

    /**
     * The doclet specific writer that will output the result.
     */
    private final ModuleSummaryWriter moduleWriter;

    /**
     * Construct a new ModuleSummaryBuilder.
     *
     * @param context  the build context.
     * @param mdle the module being documented.
     * @param moduleWriter the doclet specific writer that will output the
     *        result.
     */
    private ModuleSummaryBuilder(Context context,
            ModuleElement mdle, ModuleSummaryWriter moduleWriter) {
        super(context);
        this.mdle = mdle;
        this.moduleWriter = moduleWriter;
    }

    /**
     * Construct a new ModuleSummaryBuilder.
     *
     * @param context  the build context.
     * @param mdle the module being documented.
     * @param moduleWriter the doclet specific writer that will output the
     *        result.
     *
     * @return an instance of a ModuleSummaryBuilder.
     */
    public static ModuleSummaryBuilder getInstance(Context context,
            ModuleElement mdle, ModuleSummaryWriter moduleWriter) {
        return new ModuleSummaryBuilder(context, mdle, moduleWriter);
    }

    /**
     * Build the module summary.
     *
     * @throws DocletException if there is a problem while building the documentation
     */
    @Override
    public void build() throws DocletException {
        if (moduleWriter == null) {
            //Doclet does not support this output.
            return;
        }
        buildModuleDoc();
    }

    /**
     * Build the module documentation.
     *
     * @throws DocletException if there is a problem while building the documentation
     */
    protected void buildModuleDoc() throws DocletException {
        Content contentTree = moduleWriter.getModuleHeader(mdle.getQualifiedName().toString());

        buildContent();

        moduleWriter.addModuleFooter();
        moduleWriter.printDocument(contentTree);
        DocFilesHandler docFilesHandler = configuration.getWriterFactory().getDocFilesHandler(mdle);
        docFilesHandler.copyDocFiles();
    }

    /**
     * Build the content for the module doc.
     *
     * @throws DocletException if there is a problem while building the documentation
     */
    protected void buildContent() throws DocletException {
        Content moduleContentTree = moduleWriter.getContentHeader();

        moduleWriter.addModuleSignature(moduleContentTree);
        buildModuleDescription(moduleContentTree);
        buildSummary(moduleContentTree);

        moduleWriter.addModuleContent(moduleContentTree);
    }

    /**
     * Builds the list of summary sections for this module.
     *
     * @param moduleContentTree the module content tree to which the summaries will
     *                           be added
     * @throws DocletException if there is a problem while building the documentation
     */
    protected void buildSummary(Content moduleContentTree) throws DocletException {
        Content summariesList = moduleWriter.getSummariesList();

        buildPackagesSummary(summariesList);
        buildModulesSummary(summariesList);
        buildServicesSummary(summariesList);

        moduleContentTree.add(moduleWriter.getSummaryTree(summariesList));
    }

    /**
     * Builds the summary of the module dependencies of this module.
     *
     * @param summariesList the list of summaries to which the summary will be added
     */
    protected void buildModulesSummary(Content summariesList) {
        moduleWriter.addModulesSummary(summariesList);
    }

    /**
     * Builds the summary of the packages exported or opened by this module.
     *
     * @param summariesList the list of summaries to which the summary will be added
     */
    protected void buildPackagesSummary(Content summariesList) {
        moduleWriter.addPackagesSummary(summariesList);
    }

    /**
     * Builds the summary of the services used or provided by this module.
     *
     * @param summariesList the list of summaries to which the summary will be added
     */
    protected void buildServicesSummary(Content summariesList) {
        moduleWriter.addServicesSummary(summariesList);
    }

    /**
     * Builds the description for this module.
     *
     * @param moduleContentTree the tree to which the module description will
     *                           be added
     */
    protected void buildModuleDescription(Content moduleContentTree) {
        if (!options.noComment()) {
            moduleWriter.addModuleDescription(moduleContentTree);
        }
    }
}
