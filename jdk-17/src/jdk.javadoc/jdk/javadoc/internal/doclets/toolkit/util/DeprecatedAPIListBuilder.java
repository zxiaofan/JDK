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

import java.util.*;

import javax.lang.model.element.Element;

import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration;

/**
 * Build list of all the deprecated packages, classes, constructors, fields and methods.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class DeprecatedAPIListBuilder extends SummaryAPIListBuilder {

    private SortedSet<Element> forRemoval;
    public final List<String> releases;

    /**
     * Constructor.
     *
     * @param configuration the current configuration of the doclet
     * @param releases list of releases
     */
    public DeprecatedAPIListBuilder(BaseConfiguration configuration, List<String> releases) {
        super(configuration, configuration.utils::isDeprecated);
        this.releases = releases;
        buildSummaryAPIInfo();
    }

    public SortedSet<Element> getForRemoval() {
        if (forRemoval == null) {
            forRemoval = createSummarySet();
        }
        return forRemoval;
    }

    @Override
    protected void handleElement(Element e) {
        if (utils.isDeprecatedForRemoval(e)) {
            getForRemoval().add(e);
        }
    }
}
