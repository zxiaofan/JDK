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

/**
 * This class collects together key details of a span of text. It is used by
 * implementors of the class {@code AccessibleExtendedText} in order to return
 * the requested triplet of a {@code String}, and the start and end
 * indicies/offsets into a larger body of text that the {@code String} comes
 * from.
 *
 * @see AccessibleExtendedText
 */
public class AccessibleTextSequence {

    /**
     * The start index of the text sequence.
     */
    public int startIndex;

    /**
     * The end index of the text sequence.
     */
    public int endIndex;

    /**
     * The text.
     */
    public String text;

    /**
     * Constructs an {@code AccessibleTextSequence} with the given parameters.
     *
     * @param  start the beginning index of the span of text
     * @param  end the ending index of the span of text
     * @param  txt the {@code String} shared by this text span
     * @since 1.6
     */
    public AccessibleTextSequence(int start, int end, String txt) {
        startIndex = start;
        endIndex = end;
        text = txt;
    }
};
