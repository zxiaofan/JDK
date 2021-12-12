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
 * A case label that marks {@code default} in {@code case null, default}.
 *
 * @since 17
 */
@PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
public interface DefaultCaseLabelTree extends CaseLabelTree {}
