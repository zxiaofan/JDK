/*
 * Copyright (c) 2010, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.text;

import java.text.BreakIterator;

/**
 * Represents the hit information in a Text node.
 *
 * @since 9
 */
public class HitInfo {

    private int charIndex;
    private boolean leading;
    private int insertionIndex;
    private String text;

    /**
     * Create a HitInfo object representing a text index and forward bias.
     *
     * @param charIndex the character index.
     * @param leading whether the hit is on the leading edge of the character. If it is false, it represents the trailing edge.
     */
    HitInfo(int charIndex, int insertionIndex, boolean leading, String text) {
        this.charIndex = charIndex;
        this.leading = leading;
        this.insertionIndex = insertionIndex;
        this.text = text;
    }

    /**
     * The index of the character which this hit information refers to.
     * @return the index of the character which this hit information refers to
     */
    public int getCharIndex() { return charIndex; }

    /**
     * Indicates whether the hit is on the leading edge of the character.
     * If it is false, it represents the trailing edge.
     * @return if true the hit is on the leading edge of the character, otherwise
     * the trailing edge
     */
    public boolean isLeading() { return leading; }

    private static BreakIterator charIterator = BreakIterator.getCharacterInstance();

    /**
     * Returns the index of the insertion position.
     * @return the index of the insertion position
     */
    public int getInsertionIndex() {
        if (insertionIndex == -1) {
            insertionIndex = charIndex;
            if (!leading) {
                if (text != null) {
                    // Skip complex character clusters / ligatures.
                    int next;
                    synchronized(charIterator) {
                        charIterator.setText(text);
                        next = charIterator.following(insertionIndex);
                    }
                    if (next == BreakIterator.DONE) {
                        insertionIndex += 1;
                    } else {
                        insertionIndex = next;
                    }
                } else {
                    insertionIndex += 1;
                }
            }
        }
        return insertionIndex;
    }

    @Override public String toString() {
        return "charIndex: " + charIndex + ", isLeading: " + leading + ", insertionIndex: " + getInsertionIndex();
    }
}
