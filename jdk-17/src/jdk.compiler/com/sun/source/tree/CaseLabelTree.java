/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

import jdk.internal.javac.PreviewFeature;

/**
 * A marker interface for {@code Tree}s that may be used as {@link CaseTree} labels.
 *
 * @since 17
 */
@PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
public interface CaseLabelTree extends Tree {}
