/*
 * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.util;

import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration;

/**
 * Build list of all the preview packages, classes, constructors, fields and methods.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class PreviewAPIListBuilder extends SummaryAPIListBuilder {

    /**
     * Constructor.
     *
     * @param configuration the current configuration of the doclet
     */
    public PreviewAPIListBuilder(BaseConfiguration configuration) {
        super(configuration, e -> configuration.utils.isPreviewAPI(e));
        buildSummaryAPIInfo();
    }
}
