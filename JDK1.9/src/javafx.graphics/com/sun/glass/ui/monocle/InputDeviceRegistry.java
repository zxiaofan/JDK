/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

/**
 * InputDeviceRegistry maintains an observable set of input devices. The
 * InputDeviceRegistry is responsible for detecting what input devices are
 * attached and for generating input events from these devices.
 */
class InputDeviceRegistry {
    protected ObservableSet<InputDevice> devices =
            FXCollections.observableSet();

    /** Returns the set of currently available input devices.
     *
     * @return an ObservableSet of input devices. This set should not be modified.
     */
    ObservableSet<InputDevice> getInputDevices() {
        return devices;
    }

}
