/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

/**
 * Abstraction of an input device and its capabilities
 */
interface InputDevice {

    /**
     * @return true if the device provides touch input for at least one touch
     * point.
     */
    boolean isTouch();

    /**
     * @return true if the device provides touch input for more than one touch
     * point.
     */
    boolean isMultiTouch();

    /**
     * @return true if the device provides relative pointing events. Relative
     * pointing events are those received from devices where the event signifies
     * a relative change in cursor position on the screen. For example, a mouse,
     * trackball, trackpad or joystick is a relative pointing device. A touch
     * screen is an sbsolute pointing device.
     */
    boolean isRelative();

    /**
     * @return true if the device provides direction arrow keys (UP, DOWN, LEFT
     * and RIGHT) and a selection key.
     */
    boolean is5Way();

    /**
     * @return true if the device provides keys for the letters 'A' through 'Z',
     * the digits '0' through '9' and also SPACE, SHIFT and TAB keys in addition
     * to directional arrows and a selection key.
     */
    boolean isFullKeyboard();

}
