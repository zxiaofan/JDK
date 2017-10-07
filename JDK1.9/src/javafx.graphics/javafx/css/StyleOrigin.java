/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Enumeration of the possible source or origin of a stylesheet and styles.
 * @since JavaFX 8.0
 */
public enum StyleOrigin {
    /** The stylesheet is a user-agent stylesheet */
    USER_AGENT,
    /** The value of a property was set by the user through a call to a set method */
    USER,
    /** The stylesheet is an external file */
    AUTHOR,
    /** The style is from the Node via setStyle */
    INLINE

}
