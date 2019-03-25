/**
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
 * ParserContextNode that represents a LabelNode
 */
class ParserContextLabelNode extends ParserContextBaseNode {

    /** Name for label */
    private final String name;

    /**
     * Constructor
     *
     * @param name The name of the label
     */
    public ParserContextLabelNode(final String name) {
        this.name = name;
    }

    /**
     * Returns the name of the label
     * @return name of label
     */
    public String getLabelName() {
        return name;
    }
}
