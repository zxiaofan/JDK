/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package jdk.nashorn.internal.parser;

import jdk.nashorn.internal.ir.BreakNode;

/**
 * An interface that is implemented by ParserContextNodes that can
 * contain a {@link BreakNode}
 */
interface ParserContextBreakableNode extends ParserContextNode {

    /**
     * Returns true if not i breakable without label, false otherwise
     * @return Returns true if not i breakable without label, false otherwise
     */
    boolean isBreakableWithoutLabel();
}
