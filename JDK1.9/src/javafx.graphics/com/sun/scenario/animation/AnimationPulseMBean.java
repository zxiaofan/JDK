/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

public interface AnimationPulseMBean {
    public boolean getEnabled();

    public void setEnabled(boolean enabled);

    // we are using millis as time units here

    public long getPULSE_DURATION();

    public long getSkippedPulses();

    public long getSkippedPulsesIn1Sec();

    // from the scheduled time
    public long getStartMax();

    public long getStartMaxIn1Sec();

    public long getStartAv();

    public long getStartAvIn100Millis();

    public long getEndMax();

    public long getEndMaxIn1Sec();

    public long getEndAv();

    public long getEndAvIn100Millis();

    public long getAnimationDurationMax();

    public long getAnimationMaxIn1Sec();

    public long getAnimationDurationAv();

    public long getAnimationDurationAvIn100Millis();

    public long getPaintingDurationMax();

    public long getPaintingDurationMaxIn1Sec();

    public long getPaintingDurationAv();

    public long getPaintingDurationAvIn100Millis();

    public long getScenePaintingDurationMaxIn1Sec();

    public long getPaintingPreparationDurationMaxIn1Sec();

    public long getPaintingFinalizationDurationMaxIn1Sec();

    public long getPulseDurationMax();

    public long getPulseDurationMaxIn1Sec();

    public long getPulseDurationAv();

    public long getPulseDurationAvIn100Millis();
}
