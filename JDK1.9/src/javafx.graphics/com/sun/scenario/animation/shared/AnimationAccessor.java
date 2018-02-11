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

public abstract class AnimationAccessor {
 public static AnimationAccessor DEFAULT;

    public static AnimationAccessor getDefault() {
        if (DEFAULT != null) {
            return DEFAULT;
        }

        // invokes static initializer of Animation.class
        // that will assign value to the DEFAULT field above
        Class c = Animation.class;
        try {
            Class.forName(c.getName());
        } catch (ClassNotFoundException ex) {
            assert false : ex;
        }
        assert DEFAULT != null : "The DEFAULT field must be initialized";
        return DEFAULT;
    }

    public abstract void setCurrentRate(Animation animation, double currentRate);

    public abstract void setCurrentTicks(Animation animation, long ticks);

    public abstract void playTo(Animation animation, long pos, long cycleTicks);

    public abstract void jumpTo(Animation animation, long pos, long cycleTicks, boolean forceJump);

    public abstract void finished(Animation animation);


}
