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

package com.sun.prism.paint;

import com.sun.javafx.geom.transform.BaseTransform;
import java.util.List;

public abstract class Gradient extends Paint {

    public static final int PAD = 0;
    public static final int REFLECT = 1;
    public static final int REPEAT = 2;

    private final int numStops;
    private final List<Stop> stops;
    private final BaseTransform gradientTransform;
    private final int spreadMethod;
    private long cacheOffset = -1;

    protected Gradient(Type type,
                       BaseTransform gradientTransform,
                       boolean proportional,
                       int spreadMethod,
                       List<Stop> stops)
    {
        super(type, proportional, false);
        if (gradientTransform != null) {
            this.gradientTransform = gradientTransform.copy();
        } else {
            this.gradientTransform = BaseTransform.IDENTITY_TRANSFORM;
        }
        this.spreadMethod = spreadMethod;
        this.numStops = stops.size();
        this.stops = stops;
    }


    public int getSpreadMethod() {
        return spreadMethod;
    }

    public BaseTransform getGradientTransformNoClone() {
        return gradientTransform;
    }

    public int getNumStops() {
        return numStops;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setGradientOffset(long offset) {
        this.cacheOffset = offset;
    }

    public long getGradientOffset() {
        return cacheOffset;
    }

    @Override
    public boolean isOpaque() {
        for (int i = 0; i < numStops; i++) {
            if (!stops.get(i).getColor().isOpaque()) {
                return false;
            }
        }
        return true;
    }
}
