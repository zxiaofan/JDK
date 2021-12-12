/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

/**
 * {@code SoftControl} are the basic controls
 * used for control-rate processing.
 *
 * @author Karl Helgason
 */
public interface SoftControl {

    double[] get(int instance, String name);
}
