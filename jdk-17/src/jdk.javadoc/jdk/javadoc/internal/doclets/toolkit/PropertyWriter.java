/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.ExecutableElement;

/**
 * The interface for writing property output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */

public interface PropertyWriter extends MemberWriter {

    /**
     * Get the property details tree header.
     *
     * @param memberDetailsTree the content tree representing member details
     * @return content tree for the property details header
     */
    Content getPropertyDetailsTreeHeader(Content memberDetailsTree);

    /**
     * Get the property documentation tree header.
     *
     * @param property the property being documented
     * @return content tree for the property documentation header
     */
    Content getPropertyDocTreeHeader(ExecutableElement property);

    /**
     * Get the signature for the given property.
     *
     * @param property the property being documented
     * @return content tree for the property signature
     */
    Content getSignature(ExecutableElement property);

    /**
     * Add the deprecated output for the given property.
     *
     * @param property the property being documented
     * @param propertyDocTree content tree to which the deprecated information will be added
     */
    void addDeprecated(ExecutableElement property, Content propertyDocTree);

    /**
     * Add the preview output for the given member.
     *
     * @param member the member being documented
     * @param annotationDocTree content tree to which the preview information will be added
     */
    void addPreview(ExecutableElement member, Content contentTree);

    /**
     * Add the comments for the given property.
     *
     * @param property the property being documented
     * @param propertyDocTree the content tree to which the comments will be added
     */
    void addComments(ExecutableElement property, Content propertyDocTree);

    /**
     * Add the tags for the given property.
     *
     * @param property the property being documented
     * @param propertyDocTree the content tree to which the tags will be added
     */
    void addTags(ExecutableElement property, Content propertyDocTree);

    /**
     * Get the property details tree.
     *
     * @param memberDetailsTreeHeader the content tree representing member details header
     * @param memberDetailsTree the content tree representing member details
     * @return content tree for the property details
     */
    Content getPropertyDetails(Content memberDetailsTreeHeader, Content memberDetailsTree);

    /**
     * Gets the member header tree.
     *
     * @return a content tree for the member header
     */
    Content getMemberTreeHeader();
}
