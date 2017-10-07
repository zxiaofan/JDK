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

package com.sun.javafx.font;


public interface CompositeFontResource extends FontResource {

    public FontResource getSlotResource(int slot);

    public int getNumSlots();

    /**
     * Returns the slot for the given font name.
     * Adds fontName as a new fallback font if needed.
     */
    public int getSlotForFont(String fontName);

}
