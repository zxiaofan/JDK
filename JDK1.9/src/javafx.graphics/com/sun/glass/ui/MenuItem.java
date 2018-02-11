/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui;

import com.sun.glass.events.KeyEvent;
import com.sun.glass.ui.delegate.MenuItemDelegate;

public final class MenuItem {

    public interface Callback {
        public void action();

        public void validate();
    }

    public static final MenuItem Separator = null;

    private final MenuItemDelegate delegate;

    private String title;
    private Callback callback;
    private boolean enabled;
    private boolean checked;
    private int shortcutKey;
    private int shortcutModifiers;

    protected MenuItem(String title) {
        this(title, null);
    }

    protected MenuItem(String title, Callback callback) {
        this(title, callback, KeyEvent.VK_UNDEFINED, KeyEvent.MODIFIER_NONE);
    }

    protected MenuItem(String title, Callback callback,
            int shortcutKey, int shortcutModifiers) {
        this(title, callback, shortcutKey, shortcutModifiers, null);
    }

    protected MenuItem(String title, Callback callback,
            int shortcutKey, int shortcutModifiers, Pixels pixels) {
        Application.checkEventThread();
        this.title = title;
        this.callback = callback;
        this.shortcutKey = shortcutKey;
        this.shortcutModifiers = shortcutModifiers;
        enabled = true;
        checked = false;
        delegate = PlatformFactory.getPlatformFactory().createMenuItemDelegate(this);
        if (!delegate.createMenuItem(title, callback,
                shortcutKey, shortcutModifiers, pixels, enabled, checked)) {
            throw new RuntimeException("MenuItem creation error.");
        }
    }

    public String getTitle() {
        Application.checkEventThread();
        return title;
    }

    public void setTitle(String title) {
        Application.checkEventThread();
        if (delegate.setTitle(title)) {
            this.title = title;
        }
    }

    public Callback getCallback() {
        Application.checkEventThread();
        return callback;
    }

    public void setCallback(Callback callback) {
        Application.checkEventThread();
        if (delegate.setCallback(callback)) {
            this.callback = callback;
        }
    }

    public boolean isEnabled() {
        Application.checkEventThread();
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        Application.checkEventThread();
        if (delegate.setEnabled(enabled)) {
            this.enabled = enabled;
        }
    }

    public boolean isChecked() {
        Application.checkEventThread();
        return checked;
    }

    public void setChecked(boolean checked) {
        Application.checkEventThread();
        if (delegate.setChecked(checked)) {
            this.checked = checked;
        }
    }

    /**
     * returns KeyEvent.VK_UNDEFINED if the shortcut is not assigned
     */
    public int getShortcutKey() {
        Application.checkEventThread();
        return shortcutKey;
    }

    /**
     * returns KeyEvent.MODIFIER_NONE if the shortcut is not assigned
     */
    public int getShortcutModifiers() {
        Application.checkEventThread();
        return shortcutModifiers;
    }

    public void setShortcut(int shortcutKey, int shortcutModifiers) {
        Application.checkEventThread();
        if (delegate.setShortcut(shortcutKey, shortcutModifiers)) {
            this.shortcutKey = shortcutKey;
            this.shortcutModifiers = shortcutModifiers;
        }
    }

    public boolean setPixels(Pixels pixels) {
        Application.checkEventThread();
        return (delegate.setPixels(pixels));
    }

    // package private
    MenuItemDelegate getDelegate() {
        return delegate;
    }
}
