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

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

/**
 * The interface for writing constructor output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @author Bhavesh Patel (Modified)
 */

public interface ConstructorWriter {

    /**
     * Get the constructor details tree header.
     *
     * @param typeElement the class being documented
     * @param memberDetailsTree the content tree representing member details
     * @return content tree for the constructor details header
     */
    public Content getConstructorDetailsTreeHeader(TypeElement typeElement,
            Content memberDetailsTree);

    /**
     * Get the constructor documentation tree header.
     *
     * @param constructor the constructor being documented
     * @param constructorDetailsTree the content tree representing constructor details
     * @return content tree for the constructor documentation header
     */
    public Content getConstructorDocTreeHeader(ExecutableElement constructor,
            Content constructorDetailsTree);

    /**
     * Get the signature for the given constructor.
     *
     * @param constructor the constructor being documented
     * @return content tree for the constructor signature
     */
    public Content getSignature(ExecutableElement constructor);

    /**
     * Add the deprecated output for the given constructor.
     *
     * @param constructor the constructor being documented
     * @param constructorDocTree content tree to which the deprecated information will be added
     */
    public void addDeprecated(ExecutableElement constructor, Content constructorDocTree);

    /**
     * Add the comments for the given constructor.
     *
     * @param constructor the constructor being documented
     * @param constructorDocTree the content tree to which the comments will be added
     */
    public void addComments(ExecutableElement constructor, Content constructorDocTree);

    /**
     * Add the tags for the given constructor.
     *
     * @param constructor the constructor being documented
     * @param constructorDocTree the content tree to which the tags will be added
     */
    public void addTags(ExecutableElement constructor, Content constructorDocTree);

    /**
     * Get the constructor details tree.
     *
     * @param memberDetailsTree the content tree representing member details
     * @return content tree for the constructor details
     */
    public Content getConstructorDetails(Content memberDetailsTree);

    /**
     * Get the constructor documentation.
     *
     * @param constructorDocTree the content tree representing constructor documentation
     * @param isLastContent true if the content to be added is the last content
     * @return content tree for the constructor documentation
     */
    public Content getConstructorDoc(Content constructorDocTree, boolean isLastContent);

    /**
     * Let the writer know whether a non public constructor was found.
     *
     * @param foundNonPubConstructor true if we found a non public constructor.
     */
    public void setFoundNonPubConstructor(boolean foundNonPubConstructor);
}
