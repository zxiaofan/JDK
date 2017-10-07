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

package com.sun.scenario.animation.shared;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.util.Duration;

public class SingleLoopClipEnvelope extends ClipEnvelope {

    private int cycleCount;

    @Override
    public void setRate(double rate) {
        final Status status = animation.getStatus();
        if (status != Status.STOPPED) {
            if (status == Status.RUNNING) {
                setCurrentRate((Math.abs(currentRate - this.rate) < EPSILON) ? rate : -rate);
            }
            deltaTicks = ticks - Math.round((ticks - deltaTicks) * rate / this.rate);
            abortCurrentPulse();
        }
        this.rate = rate;
    }

    @Override
    public void setAutoReverse(boolean autoReverse) {
        // ignore autoReverse
    }

    @Override
    protected double calculateCurrentRate() {
        return rate;
    }

    protected SingleLoopClipEnvelope(Animation animation) {
        super(animation);
        if (animation != null) {
            cycleCount = animation.getCycleCount();
        }
    }

    @Override
    public boolean wasSynched() {
        return super.wasSynched() && cycleCount != 0;
    }

    @Override
    public ClipEnvelope setCycleDuration(Duration cycleDuration) {
        if ((cycleCount != 1) && !cycleDuration.isIndefinite()) {
            return create(animation);
        }
        updateCycleTicks(cycleDuration);
        return this;
    }

    @Override
    public ClipEnvelope setCycleCount(int cycleCount) {
        if ((cycleCount != 1) && (cycleTicks != ClipEnvelope.INDEFINITE)) {
            return create(animation);
        }
        this.cycleCount = cycleCount;
        return this;
    }

    @Override
    public void timePulse(long currentTick) {
        if (cycleTicks == 0L) {
            return;
        }
        aborted = false;
        inTimePulse = true;

        try {
            ticks = ClipEnvelope.checkBounds(deltaTicks + Math.round(currentTick * currentRate), cycleTicks);
            AnimationAccessor.getDefault().playTo(animation, ticks, cycleTicks);

            final boolean reachedEnd = (currentRate > 0)? (ticks == cycleTicks) : (ticks == 0);
            if(reachedEnd && !aborted) {
                AnimationAccessor.getDefault().finished(animation);
            }
        } finally {
            inTimePulse = false;
        }
    }

    @Override
    public void jumpTo(long ticks) {
        if (cycleTicks == 0L) {
            return;
        }
        final long newTicks = ClipEnvelope.checkBounds(ticks, cycleTicks);
        deltaTicks += (newTicks - this.ticks);
        this.ticks = newTicks;

        AnimationAccessor.getDefault().jumpTo(animation, newTicks, cycleTicks, false);

        abortCurrentPulse();
    }

}
