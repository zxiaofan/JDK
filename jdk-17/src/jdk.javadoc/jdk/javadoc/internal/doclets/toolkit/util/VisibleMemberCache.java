/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.TypeElement;
import java.util.HashMap;
import java.util.Map;

/**
 * This class manages the visible member table for each type element.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */

public class VisibleMemberCache {
    private final Map<TypeElement, VisibleMemberTable> cache;
    private final BaseConfiguration configuration;

    public VisibleMemberCache(BaseConfiguration configuration) {
        this.configuration = configuration;
        cache = new HashMap<>();
    }

    public VisibleMemberTable getVisibleMemberTable(TypeElement te) {
        return cache.computeIfAbsent(te, t -> new VisibleMemberTable(t, configuration, this));
    }
}
