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

package javafx.stage;

import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * A Popup is a special window-like container for a scene graph. It is typically
 * used for tooltip like notification, drop down boxes, menus, and so forth.
 * The popup has no decorations, and essentially acts as a specialized
 * scene/window which has no decorations, is transparent, and with a null fill.
 *
 * @since JavaFX 2.0
 */
public class Popup extends PopupWindow {

    /**
     * The ObservableList of {@code Node}s to be rendered on this
     * {@code Popup}. The content forms the complete visual representation of
     * the Popup. Popups have no intrinsic visuals.
     */
    @Override public final ObservableList<Node> getContent() {
        return super.getContent();
    }
}
