/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.hotspot;

import jdk.vm.ci.meta.Constant;

/**
 * Marker interface for hotspot specific constants.
 */
public interface HotSpotConstant extends Constant {

    boolean isCompressed();

    Constant compress();

    Constant uncompress();
}
