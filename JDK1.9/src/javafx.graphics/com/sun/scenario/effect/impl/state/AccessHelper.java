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

package com.sun.scenario.effect.impl.state;

import com.sun.scenario.effect.Effect;

public class AccessHelper {

    /**
     * Provides access to implementation details in
     * com.sun.scenario.effect package.
     */
    public interface StateAccessor {
        public Object getState(Effect effect);
    }

    private static StateAccessor theStateAccessor;

    public static void setStateAccessor(StateAccessor accessor) {
        if (theStateAccessor != null) {
            throw new InternalError("EffectAccessor already initialized");
        }
        theStateAccessor = accessor;
    }

    public static Object getState(Effect effect) {
        if (effect == null) {
            return null;
        }
        return theStateAccessor.getState(effect);
    }
}
