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

package com.sun.javafx.geom.transform;

import com.sun.javafx.geom.Vec3d;

/**
 *
 */
public interface CanTransformVec3d {

    public Vec3d transform(Vec3d point, Vec3d pointOut);

}
