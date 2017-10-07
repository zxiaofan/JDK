/*
 * Copyright (c) 2003, 2016, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.TypeElement;

import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;

/**
 * The interface for writing annotation type output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @author Bhavesh Patel (Modified)
 */

public interface AnnotationTypeWriter {

    /**
     * Get the header of the page.
     *
     * @param header the header string to write
     * @return a content tree for the header documentation
     */
    public Content getHeader(String header);

    /**
     * Get the annotation content header.
     *
     * @return annotation content header that needs to be added to the documentation
     */
    public Content getAnnotationContentHeader();

    /**
     * Get the annotation information tree header.
     *
     * @return annotation information tree header that needs to be added to the documentation
     */
    public Content getAnnotationInfoTreeHeader();

    /**
     * Get the annotation information.
     *
     * @param annotationInfoTree content tree containing the annotation information
     * @return a content tree for the annotation
     */
    public Content getAnnotationInfo(Content annotationInfoTree);

    /**
     * Add the signature of the current annotation type.
     *
     * @param modifiers the modifiers for the signature
     * @param annotationInfoTree the annotation content tree to which the signature will be added
     */
    public void addAnnotationTypeSignature(String modifiers, Content annotationInfoTree);

    /**
     * Build the annotation type description.
     *
     * @param annotationInfoTree content tree to which the description will be added
     */
    public void addAnnotationTypeDescription(Content annotationInfoTree);

    /**
     * Add the tag information for the current annotation type.
     *
     * @param annotationInfoTree content tree to which the tag information will be added
     */
    public void addAnnotationTypeTagInfo(Content annotationInfoTree);

    /**
     * If this annotation is deprecated, add the appropriate information.
     *
     * @param annotationInfoTree content tree to which the deprecated information will be added
     */
    public void addAnnotationTypeDeprecationInfo (Content annotationInfoTree);

    /**
     * Get the member tree header for the annotation type.
     *
     * @return a content tree for the member tree header
     */
    public Content getMemberTreeHeader();

    /**
     * Add the annotation content tree to the documentation content tree.
     *
     * @param contentTree content tree to which the annotation content will be added
     * @param annotationContentTree annotation content tree which will be added to the content tree
     */
    public void addAnnotationContentTree(Content contentTree, Content annotationContentTree);

    /**
     * Get the member tree.
     *
     * @param memberTree the content tree that will be modified and returned
     * @return a content tree for the member
     */
    public Content getMemberTree(Content memberTree);

    /**
     * Get the member summary tree.
     *
     * @param memberTree the content tree that will be used to build the summary tree
     * @return a content tree for the member summary
     */
    public Content getMemberSummaryTree(Content memberTree);

    /**
     * Get the member details tree.
     *
     * @param memberTree the content tree that will be used to build the details tree
     * @return a content tree for the member details
     */
    public Content getMemberDetailsTree(Content memberTree);

    /**
     * Add the footer of the page.
     *
     * @param contentTree content tree to which the footer will be added
     */
    public void addFooter(Content contentTree);

    /**
     * Print the document.
     *
     * @param contentTree content tree that will be printed as a document
     * @throws DocFileIOException if there is a problem while writing the document
     */
    public void printDocument(Content contentTree) throws DocFileIOException;

    /**
     * Return the {@link TypeElement} being documented.
     *
     * @return the TypeElement representing the annotation being documented.
     */
    public TypeElement getAnnotationTypeElement();
}
