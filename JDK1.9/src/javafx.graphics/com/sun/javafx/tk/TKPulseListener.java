/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;

/**
 * TKPulseListener - Listener for those intrested in toolkit repaint pulses
 *
 */
public interface TKPulseListener {

    /**
     * This is called by the toolkit on every repaint pulse
     */
    public void pulse();
}
