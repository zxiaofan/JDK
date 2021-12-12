/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

import jdk.internal.javac.NoPreview;

/**
 * A tree node used as the base class for the different types of
 * expressions.
 *
 * @jls 15 Expressions
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
@NoPreview
public interface ExpressionTree extends Tree, CaseLabelTree {}
