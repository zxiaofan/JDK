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

package com.sun.scenario.animation;

import com.sun.javafx.animation.TickCalculation;
import javafx.animation.Interpolator;
import javafx.util.Duration;

public class NumberTangentInterpolator extends Interpolator {

    private final double inValue, outValue;
    private final long inTicks, outTicks;

    public double getInValue() { return inValue; }

    public double getOutValue() { return outValue; }

    public double getInTicks() { return inTicks; }

    public double getOutTicks() { return outTicks; }

    public NumberTangentInterpolator(Duration inDuration, double inValue, Duration outDuration, double outValue) {
        this.inTicks = TickCalculation.fromDuration(inDuration);
        this.inValue = inValue;
        this.outTicks = TickCalculation.fromDuration(outDuration);
        this.outValue = outValue;
    }

    public NumberTangentInterpolator(Duration duration, double value) {
        this.outTicks = this.inTicks = TickCalculation.fromDuration(duration);
        this.inValue = this.outValue = value;
    }

    @Override
    public String toString() {
        return "NumberTangentInterpolator [inValue=" + inValue
                + ", inDuration=" + TickCalculation.toDuration(inTicks) + ", outValue="
                + outValue + ", outDuration=" + TickCalculation.toDuration(outTicks) + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.inValue) ^ (Double.doubleToLongBits(this.inValue) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.outValue) ^ (Double.doubleToLongBits(this.outValue) >>> 32));
        hash = 59 * hash + (int) (this.inTicks ^ (this.inTicks >>> 32));
        hash = 59 * hash + (int) (this.outTicks ^ (this.outTicks >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NumberTangentInterpolator other = (NumberTangentInterpolator) obj;
        if (Double.doubleToLongBits(this.inValue) != Double.doubleToLongBits(other.inValue)) {
            return false;
        }
        if (Double.doubleToLongBits(this.outValue) != Double.doubleToLongBits(other.outValue)) {
            return false;
        }
        if (this.inTicks != other.inTicks) {
            return false;
        }
        if (this.outTicks != other.outTicks) {
            return false;
        }
        return true;
    }

    @Override
    protected double curve(double t) {
        // Fallback: If NumberTangentInterpolator is used with a target, that is
        // not a number,
        // it behaves like linear interpolation.
        return t;
    }
}
