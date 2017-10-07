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

package javafx.scene.effect;

import javafx.beans.value.ObservableValue;

import com.sun.javafx.beans.event.AbstractNotifyListener;

abstract class EffectChangeListener extends AbstractNotifyListener {
    protected ObservableValue registredOn;

    public void register(ObservableValue value) {
        if (registredOn == value)
            return;

        if (registredOn != null) {
            registredOn.removeListener(getWeakListener());
        }
        registredOn = value;
        if (registredOn != null) {
            registredOn.addListener(getWeakListener());
        }
    }
}
