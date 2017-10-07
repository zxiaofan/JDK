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

package com.sun.javafx.webkit.theme;

import com.sun.webkit.graphics.ScrollBarTheme;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;

public final class ScrollBarWidget extends ScrollBar implements RenderThemeImpl.Widget {
    static {
        ScrollBarWidgetHelper.setScrollBarWidgetAccessor(new ScrollBarWidgetHelper.ScrollBarWidgetAccessor() {
            @Override
            public void doUpdatePeer(Node node) {
                ((ScrollBarWidget) node).doUpdatePeer();
            }
        });
    }

    private ScrollBarThemeImpl sbtImpl;

    {
        // To initialize the class helper at the begining each constructor of this class
        ScrollBarWidgetHelper.initHelper(this);
    }

    public ScrollBarWidget(ScrollBarThemeImpl sbtImpl) {
        this.sbtImpl = sbtImpl;
        setOrientation(Orientation.VERTICAL);
        setMin(0);
        setManaged(false);
    }

    /*
     * Note: This method MUST only be called via its accessor method.
     */
    private void doUpdatePeer() {
        initializeThickness();
    }

    @Override
    public RenderThemeImpl.WidgetType getType() {
        return RenderThemeImpl.WidgetType.SCROLLBAR;
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        initializeThickness();
    }

    private boolean thicknessInitialized = false;
    private void initializeThickness() {
        if (!thicknessInitialized) {
            ScrollBar testSB = sbtImpl.getTestSBRef();
            if (testSB == null) {
                return;
            }
            int thickness = (int) testSB.prefWidth(-1);
            if (thickness != 0 && ScrollBarTheme.getThickness() != thickness) {
                ScrollBarTheme.setThickness(thickness);
            }
            thicknessInitialized = true;
        }
    }
}
