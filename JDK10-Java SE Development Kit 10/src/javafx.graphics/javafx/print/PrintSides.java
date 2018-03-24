/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.print;

/**
 * Class to enumerate the possible duplex (two-sided) printing modes.
 * @since JavaFX 8.0
 */
public enum PrintSides {

    /**
     * One sided printing. Duplex printing is off.
     */
    ONE_SIDED,

    /**
     * Two sided printing where the vertical edge of the paper is to be used
     * for binding such as in a book. In PORTAIT mode printing, the
     * vertical edge is usally the long edge but this is reversed if
     * LANDSCAPE printing is requested
     */
    DUPLEX,

    /**
     * Two sided printing where the horizontal edge of the paper is to be used
     * for binding such as in a notepad. In PORTAIT mode printing, the
     * horizontal edge is usally the short edge but this is reversed if
     * LANDSCAPE printing is requested
     */
    TUMBLE
}

