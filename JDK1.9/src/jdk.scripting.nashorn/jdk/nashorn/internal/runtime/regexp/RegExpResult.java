/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime.regexp;

/**
 * Match tuple to keep track of ongoing regexp match.
 */
public final class RegExpResult {
    final Object[] groups;
    final int      index;
    final String   input;

    /**
     * Constructor
     *
     * @param input  regexp input
     * @param index  index of match
     * @param groups groups vector
     */
    public RegExpResult(final String input, final int index, final Object[] groups) {
        this.input  = input;
        this.index  = index;
        this.groups = groups;
    }

    /**
     * Get the groups for the match
     * @return group vector
     */
    public Object[] getGroups() {
        return groups;
    }

    /**
     * Get the input for the map
     * @return input
     */
    public String getInput() {
        return input;
    }

    /**
     * Get the index for the match
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the length of the match
     * @return length
     */
    public int length() {
        return ((String)groups[0]).length();
    }

    /**
     * Get the group with the given index or the empty string if group index is not valid.
     * @param groupIndex the group index
     * @return the group or ""
     */
    public Object getGroup(final int groupIndex) {
        return groupIndex >= 0 && groupIndex < groups.length ? groups[groupIndex] : "";
    }

    /**
     * Get the last parenthesis group, or the empty string if none exists.
     * @return the last group or ""
     */
    public Object getLastParen() {
        return groups.length > 1 ? groups[groups.length - 1] : "";
    }

}
