/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit;

import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;

/**
 * The interface for writing module summary output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */

public interface ModuleSummaryWriter {

    /**
     * Get the header for the summary.
     *
     * @param heading module name.
     * @return the header to be added to the content tree
     */
    public abstract Content getModuleHeader(String heading);

    /**
     * Get the header for the module content.
     *
     * @return a content tree for the module content header
     */
    public abstract Content getContentHeader();

    /**
     * Get the header for the summary header.
     *
     * @return a content tree with the summary header
     */
    public abstract Content getSummaryHeader();

    /**
     * Get the header for the summary tree.
     *
     * @param summaryContentTree the content tree.
     * @return a content tree with the summary tree
     */
    public abstract Content getSummaryTree(Content summaryContentTree);

    /**
     * Adds the module description.
     *
     * @param moduleContentTree the content tree to which the module description
     *                           will be added
     */
    public abstract void addModuleDescription(Content moduleContentTree);

    /**
     * Adds the tag information from the "module-info.java" file to the documentation
     * tree.
     *
     * @param moduleContentTree the content tree to which the module tags will
     *                           be added
     */
    public abstract void addModuleTags(Content moduleContentTree);

    /**
     * Adds the modules summary to the documentation tree.
     *
     * @param summaryContentTree the content tree to which the summary will be added
     */
    public abstract void addModulesSummary(Content summaryContentTree);

    /**
     * Adds the packages summary to the documentation tree.
     *
     * @param summaryContentTree the content tree to which the summary will be added
     */
    public abstract void addPackagesSummary(Content summaryContentTree);

    /**
     * Adds the services summary to the documentation tree.
     *
     * @param summaryContentTree the content tree to which the summary will be added
     */
    public abstract void addServicesSummary(Content summaryContentTree);

    /**
     * Adds the module content tree to the documentation tree.
     *
     * @param contentTree the tree to which the module content tree will be added
     * @param moduleContentTree the content tree that will be added
     */
    public abstract void addModuleContent(Content contentTree, Content moduleContentTree);

    /**
     * Adds the footer to the documentation tree.
     *
     * @param contentTree the tree to which the footer will be added
     */
    public abstract void addModuleFooter(Content contentTree);

    /**
     * Print the module summary document.
     *
     * @param contentTree the content tree that will be printed
     * @throws DocFileIOException if there is a problem while writing the document
     */
    public abstract void printDocument(Content contentTree) throws DocFileIOException;
}
