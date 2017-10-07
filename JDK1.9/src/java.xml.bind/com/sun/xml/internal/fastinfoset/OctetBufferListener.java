/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset;

/**
 * @author Paul Sandoz
 * @author Alexey Stashok
 */
public interface OctetBufferListener {
    /**
     * Callback method that will be called before the
     * (@link Decoder) octet buffer content is going to be changed.
     * So it will be possible to preserve a read data by
     * cloning, or perform other actions.
     */
    public void onBeforeOctetBufferOverwrite();
}
