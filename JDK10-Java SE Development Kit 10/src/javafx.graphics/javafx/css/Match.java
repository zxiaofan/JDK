/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.css;

import com.sun.javafx.css.PseudoClassState;

import static javafx.geometry.NodeOrientation.INHERIT;


/**
 * Used by {@link Rule} to determine whether or not the selector applies to a
 * given object.
 *
 * Returned by {@link Selector} matches in the event of a match.
 *
 * @since 9
 */
public final class Match implements Comparable<Match> {

    final Selector selector;
    final PseudoClassState pseudoClasses;
    final int idCount;
    final int styleClassCount;

    // CSS3 spec gives weight to id count, then style class count,
    // then pseudoclass count, and finally matching types (i.e., java name count)
    final int specificity;

    Match(final Selector selector, PseudoClassState pseudoClasses, int idCount, int styleClassCount) {
        assert selector != null;
        this.selector = selector;
        this.idCount = idCount;
        this.styleClassCount = styleClassCount;
        this.pseudoClasses = pseudoClasses;
        int nPseudoClasses = pseudoClasses != null ? pseudoClasses.size() : 0;
        if (selector instanceof SimpleSelector) {
            final SimpleSelector simple = (SimpleSelector)selector;
            if (simple.getNodeOrientation() != INHERIT) {
                nPseudoClasses += 1;
            }
        }
        specificity = (idCount << 8) | (styleClassCount << 4) | nPseudoClasses;
    }

    public Selector getSelector() {
        return selector;
    }

    public PseudoClassState getPseudoClasses() {
        return pseudoClasses;
    }

    public int getSpecificity() {
        return specificity;
    }

    @Override public int compareTo(Match o) {
        return specificity - o.specificity;
    }

}
