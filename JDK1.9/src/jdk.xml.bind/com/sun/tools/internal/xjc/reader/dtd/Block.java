/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.dtd;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Kohsuke Kawaguchi
 */
final class Block {
    final boolean isOptional;
    final boolean isRepeated;

    /**
     * {@link Element}s that belong to this block.
     * <p>
     * We want to preserve the order they are added, but we don't want
     * dupliates.
     */
    final Set<Element> elements = new LinkedHashSet<Element>();

    Block(boolean optional, boolean repeated) {
        isOptional = optional;
        isRepeated = repeated;
    }
}
