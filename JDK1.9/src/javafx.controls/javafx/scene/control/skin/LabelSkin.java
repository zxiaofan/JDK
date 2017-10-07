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

package javafx.scene.control.skin;

import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;

/**
 * Default skin implementation for the {@link Label} control.
 *
 * @see Label
 * @since 9
 */
public class LabelSkin extends LabeledSkinBase<Label> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new LabelSkin instance, installing the necessary child
     * nodes into the Control {@link Control#getChildren() children} list.
     *
     * @param control The control that this skin should be installed onto.
     */
    public LabelSkin(final Label control) {
        super(control);

        // Labels do not block the mouse by default, unlike most other UI Controls.
        consumeMouseEvents(false);

        registerChangeListener(control.labelForProperty(), e -> mnemonicTargetChanged());
    }
}
