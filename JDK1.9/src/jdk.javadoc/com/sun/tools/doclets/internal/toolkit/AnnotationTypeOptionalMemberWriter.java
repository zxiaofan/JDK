/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit;

import com.sun.javadoc.*;

/**
 * The interface for writing annotation type optional member output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @author Bhavesh Patel (Modified)
 * @since 1.5
 */

@Deprecated
public interface AnnotationTypeOptionalMemberWriter extends
        AnnotationTypeRequiredMemberWriter {

    /**
     * Add the the default value documentation.
     *
     * @param member the member being documented
     * @param annotationDocTree content tree to which the default value will be added
     */
    public void addDefaultValueInfo(MemberDoc member, Content annotationDocTree);
}
