/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.monocle.TouchState.Point;
import java.security.AllPermission;
import javafx.application.Platform;


public class AndroidInputDeviceRegistry extends InputDeviceRegistry {

    private static AndroidInputDeviceRegistry instance = new AndroidInputDeviceRegistry();
    private AndroidInputDevice androidDevice;
    private AndroidInputProcessor processor;
    private final KeyState keyState = new KeyState();

    static AndroidInputDeviceRegistry getInstance() {
        return instance;
    }

    public static void registerDevice() {
        Platform.runLater(() -> instance.createDevice());
    }

    public static void gotTouchEventFromNative(int count, int[] actions, int[] ids, int[] x, int[] y, int primary) {
        TouchState touchState = new TouchState();

        if (primary == -1) {
           System.out.println("don't add points, primary = -1");
        }
        else {
            for (int i = 0; i < count; i++) {
                Point p = new Point();
                p.id = ids[i];
                p.x = x[i];
                p.y = y[i];
                touchState.addPoint(p);
            }
        }
        instance.gotTouchEvent(touchState);
    }

    private void gotTouchEvent(TouchState touchState) {
        if (androidDevice == null) {
            System.out.println("[MON] got touch event, but no registered device yet");
            Thread.dumpStack();
            return;
        }
        if (processor == null) {
            System.out.println("[MON] got touch event, but processor not yet initialized");
            Thread.dumpStack();
            return;
        }
        processor.pushEvent(touchState);
    }


    public static void gotKeyEventFromNative(int action, int linuxKey) {
        instance.gotKeyEvent (action, linuxKey);
    }

    private void gotKeyEvent(int action, int lk) {
        int vk = LinuxKeyProcessor.getVirtualKeyCode(lk);
        if (action == 0) {
            keyState.pressKey(vk);
        }
        else if (action ==1) {
            keyState.releaseKey(vk);
        }
        else {
            System.out.println("[JVDBG] ERROR, what action is this? "+action);
        }
        instance.gotKeyEvent(keyState);
    }

    private void gotKeyEvent(KeyState keyState) {
        processor.pushKeyEvent(keyState);
    }

    private AndroidInputDeviceRegistry() {
    }

    private void createDevice() {
        System.out.println("[MON] Create device");
        AndroidInputDevice device = new AndroidInputDevice();
        androidDevice = addDeviceInternal(device, "Android Touch Input");
        System.out.println("[MON] Create device done, add done");
    }

    private AndroidInputDevice addDeviceInternal(AndroidInputDevice device, String name) {
        processor = createInputProcessor(device);

        device.setInputProcessor(processor);
        Thread thread = new Thread(device);
        thread.setName(name);
        thread.setDaemon(true);
        thread.start();
        devices.add(device);

        return device;

    }

    void removeDevice(AndroidInputDevice device) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(new AllPermission());
        }
        devices.remove(device);
    }

    private AndroidInputProcessor createInputProcessor(AndroidInputDevice device) {
        return new AndroidInputProcessor(device);
    }

}
