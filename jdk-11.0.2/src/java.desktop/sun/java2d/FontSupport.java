/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d;

import sun.awt.FontConfiguration;

/**
 * Font support for graphics environment
 */
public interface FontSupport {

    /**
     * Returns the current font configuration.
     */
    public FontConfiguration getFontConfiguration();
}
