/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.stage;

import com.sun.javafx.util.Utils;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

/**
 * Used to access internal window methods.
 */
public class PopupWindowHelper extends WindowHelper {
    private static final PopupWindowHelper theInstance;
    private static PopupWindowAccessor popupWindowAccessor;

    static {
        theInstance = new PopupWindowHelper();
        Utils.forceInit(PopupWindow.class);
    }

    private static WindowHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(PopupWindow popupWindow) {
        setHelper(popupWindow, getInstance());
    }

    @Override
    protected void visibleChangingImpl(Window window, boolean visible) {
        super.visibleChangingImpl(window, visible);
        popupWindowAccessor.doVisibleChanging(window, visible);
    }

    @Override
    protected void visibleChangedImpl(Window window, boolean visible) {
        super.visibleChangedImpl(window, visible);
        popupWindowAccessor.doVisibleChanged(window, visible);
    }

    public static ObservableList<Node> getContent(PopupWindow popupWindow) {
        return popupWindowAccessor.getContent(popupWindow);
    }

    public static void setPopupWindowAccessor(PopupWindowAccessor newAccessor) {
        if (popupWindowAccessor != null) {
            throw new IllegalStateException();
        }

        popupWindowAccessor = newAccessor;
    }

    public interface PopupWindowAccessor {
        ObservableList<Node> getContent(PopupWindow popupWindow);
        void doVisibleChanging(Window window, boolean visible);
        void doVisibleChanged(Window window, boolean visible);
    }
}
