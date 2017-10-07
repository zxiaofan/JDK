/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.HashMap;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.beans.value.WritableValue;
import javafx.util.Duration;

/**
 * Simplified implementation of ClipCore, which is used for timelines with
 * exactly two keyframes.
 */

class SimpleClipInterpolator extends ClipInterpolator {

    private static final KeyFrame ZERO_FRAME = new KeyFrame(Duration.ZERO);

    // The list of all targets in this clip
    private KeyFrame startKeyFrame;
    private KeyFrame endKeyFrame;
    private long endTicks;
    private InterpolationInterval[] interval;
    private int undefinedStartValueCount;
    private long ticks;

    // Is internal representation uptodate?
    private boolean invalid = true;

    SimpleClipInterpolator(KeyFrame startKeyFrame, KeyFrame endKeyFrame, long ticks) {
        this.startKeyFrame = startKeyFrame;
        this.endKeyFrame = endKeyFrame;
        this.endTicks = ticks;
    }

    SimpleClipInterpolator(KeyFrame endKeyFrame, long ticks) {
        this.startKeyFrame = ZERO_FRAME;
        this.endKeyFrame = endKeyFrame;
        this.endTicks = ticks;
    }

    // See comment in ClipInterpolator
    @Override
    ClipInterpolator setKeyFrames(KeyFrame[] keyFrames, long[] keyFrameTicks) {
        if (ClipInterpolator.getRealKeyFrameCount(keyFrames) != 2) {
            return ClipInterpolator.create(keyFrames, keyFrameTicks);
        }
        if (keyFrames.length == 1) {
            startKeyFrame = ZERO_FRAME;
            endKeyFrame = keyFrames[0];
            endTicks = keyFrameTicks[0];
        } else {
            startKeyFrame = keyFrames[0];
            endKeyFrame = keyFrames[1];
            endTicks = keyFrameTicks[1];
        }
        invalid = true;
        return this;
    }

    @Override
    void validate(boolean forceSync) {
        if (invalid) {
            ticks = endTicks;

            final Map<WritableValue<?>, KeyValue> map = new HashMap<>();
            // create a map from target => keyValues of endFrame
            for (final KeyValue keyValue : endKeyFrame.getValues()) {
                map.put(keyValue.getTarget(), keyValue);
            }

            final int valueCount = map.size();
            interval = new InterpolationInterval[valueCount];

            // iterate through keyValues in startFrame and generate intervals
            // if we find a matching keyValue in the startFrame, the entry is
            // removed from the map
            int i = 0;
            for (final KeyValue startKeyValue : startKeyFrame.getValues()) {
                final WritableValue<?> target = startKeyValue.getTarget();
                final KeyValue endKeyValue = map.get(target);
                if (endKeyValue != null) {
                    interval[i++] = InterpolationInterval.create(endKeyValue,
                            ticks, startKeyValue, ticks);
                    map.remove(target);
                }
            }

            // remaining entries in the map have no start value defined
            undefinedStartValueCount = map.values().size();
            for (final KeyValue endKeyValue : map.values()) {
                interval[i++] = InterpolationInterval.create(endKeyValue,
                        ticks);
            }

            invalid = false;
        } else if (forceSync) {
            // iterate through keyValues with undefined start value
            final int n = interval.length;
            for (int i = n - undefinedStartValueCount; i < n; i++) {
                interval[i].recalculateStartValue();
            }
        }
    }

    @Override
    void interpolate(long ticks) {
        final double frac = ((double)ticks / this.ticks);
        final int n = interval.length;
        for (int i = 0; i < n; i++) {
            interval[i].interpolate(frac);
        }
    }
}
