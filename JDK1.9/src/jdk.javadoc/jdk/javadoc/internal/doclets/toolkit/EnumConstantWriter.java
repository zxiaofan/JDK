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

import java.io.*;

import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

/**
 * The interface for writing enum constant output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @author Bhavesh Patel (Modified)
 */

public interface EnumConstantWriter {

    /**
     * Get the enum constants details tree header.
     *
     * @param typeElement the class being documented
     * @param memberDetailsTree the content tree representing member details
     * @return content tree for the enum constants details header
     */
    public Content getEnumConstantsDetailsTreeHeader(TypeElement typeElement,
            Content memberDetailsTree);

    /**
     * Get the enum constants documentation tree header.
     *
     * @param enumConstant the enum constant being documented
     * @param enumConstantsDetailsTree the content tree representing enum constant details
     * @return content tree for the enum constant documentation header
     */
    public Content getEnumConstantsTreeHeader(VariableElement enumConstant,
            Content enumConstantsDetailsTree);

    /**
     * Get the signature for the given enum constant.
     *
     * @param enumConstant the enum constant being documented
     * @return content tree for the enum constant signature
     */
    public Content getSignature(VariableElement enumConstant);

    /**
     * Add the deprecated output for the given enum constant.
     *
     * @param enumConstant the enum constant being documented
     * @param enumConstantsTree content tree to which the deprecated information will be added
     */
    public void addDeprecated(VariableElement enumConstant, Content enumConstantsTree);

    /**
     * Add the comments for the given enum constant.
     *
     * @param enumConstant the enum constant being documented
     * @param enumConstantsTree the content tree to which the comments will be added
     */
    public void addComments(VariableElement enumConstant, Content enumConstantsTree);

    /**
     * Add the tags for the given enum constant.
     *
     * @param enumConstant the enum constant being documented
     * @param enumConstantsTree the content tree to which the tags will be added
     */
    public void addTags(VariableElement enumConstant, Content enumConstantsTree);

    /**
     * Get the enum constants details tree.
     *
     * @param memberDetailsTree the content tree representing member details
     * @return content tree for the enum constant details
     */
    public Content getEnumConstantsDetails(Content memberDetailsTree);

    /**
     * Get the enum constants documentation.
     *
     * @param enumConstantsTree the content tree representing enum constants documentation
     * @param isLastContent true if the content to be added is the last content
     * @return content tree for the enum constants documentation
     */
    public Content getEnumConstants(Content enumConstantsTree, boolean isLastContent);
}
