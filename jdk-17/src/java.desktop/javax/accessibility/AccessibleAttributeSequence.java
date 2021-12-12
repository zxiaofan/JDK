/*
 * Copyright (c) 2003, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.accessibility;

import javax.swing.text.AttributeSet;

/**
 * This class collects together the span of text that share the same contiguous
 * set of attributes, along with that set of attributes. It is used by
 * implementors of the class {@code AccessibleContext} in order to generate
 * {@code ACCESSIBLE_TEXT_ATTRIBUTES_CHANGED} events.
 *
 * @see AccessibleContext
 * @see AccessibleContext#ACCESSIBLE_TEXT_ATTRIBUTES_CHANGED
 */
public class AccessibleAttributeSequence {

    /**
     * The start index of the text sequence.
     */
    public int startIndex;

    /**
     * The end index of the text sequence.
     */
    public int endIndex;

    /**
     * The text attributes.
     */
    public AttributeSet attributes;

    /**
     * Constructs an {@code AccessibleAttributeSequence} with the given
     * parameters.
     *
     * @param  start the beginning index of the span of text
     * @param  end the ending index of the span of text
     * @param  attr the {@code AttributeSet} shared by this text span
     * @since 1.6
     */
    public AccessibleAttributeSequence(int start, int end, AttributeSet attr) {
        startIndex = start;
        endIndex = end;
        attributes = attr;
    }
};
