/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl;

import com.sun.scenario.effect.Filterable;

public interface PoolFilterable extends Filterable {
    public void setImagePool(ImagePool pool);
    public ImagePool getImagePool();
}
