/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javafx.animation;

import com.sun.scenario.animation.shared.AnimationAccessor;

final class AnimationAccessorImpl extends AnimationAccessor{

    @Override
    public void setCurrentRate(Animation animation, double currentRate) {
        animation.setCurrentRate(currentRate);
    }

    @Override
    public void playTo(Animation animation, long pos, long cycleTicks) {
        animation.doPlayTo(pos, cycleTicks);
    }

    @Override
    public void jumpTo(Animation animation, long pos, long cycleTicks, boolean forceJump) {
        animation.doJumpTo(pos, cycleTicks, forceJump);
    }

    @Override
    public void finished(Animation animation) {
        animation.finished();
    }

    @Override
    public void setCurrentTicks(Animation animation, long ticks) {
        animation.setCurrentTicks(ticks);
    }


}
