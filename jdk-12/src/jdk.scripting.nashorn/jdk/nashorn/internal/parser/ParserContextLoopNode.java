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

/**
 * A ParserContextNode that represents a loop that is being parsed
 */
class ParserContextLoopNode extends ParserContextBaseNode implements ParserContextBreakableNode {

    @Override
    public boolean isBreakableWithoutLabel() {
        return true;
    }

}
