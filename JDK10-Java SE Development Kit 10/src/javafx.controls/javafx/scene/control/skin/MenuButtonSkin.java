/*
 * Copyright (c) 2010, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.scene.control.ContextMenuContent;
import javafx.scene.AccessibleAttribute;
import javafx.scene.control.Control;
import javafx.scene.control.MenuButton;

import com.sun.javafx.scene.control.behavior.MenuButtonBehavior;

/**
 * Default skin implementation for the {@link MenuButton} control.
 *
 * @see MenuButton
 * @since 9
 */
public class MenuButtonSkin extends MenuButtonSkinBase<MenuButton> {

    /***************************************************************************
     *                                                                         *
     * Static fields                                                           *
     *                                                                         *
     **************************************************************************/

    static final String AUTOHIDE = "autoHide";



    /***************************************************************************
     *                                                                         *
     * Private fields                                                          *
     *                                                                         *
     **************************************************************************/

    private final MenuButtonBehavior behavior;



    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new MenuButtonSkin instance, installing the necessary child
     * nodes into the Control {@link Control#getChildren() children} list, as
     * well as the necessary input mappings for handling key, mouse, etc events.
     *
     * @param control The control that this skin should be installed onto.
     */
    public MenuButtonSkin(final MenuButton control) {
        super(control);

        // install default input map for the MenuButton-like controls
        this.behavior = new MenuButtonBehavior(control);
//        control.setInputMap(behavior.getInputMap());

        // MenuButton's showing does not get updated when autoHide happens,
        // as that hide happens under the covers. So we add to the menuButton's
        // properties map to which the MenuButton can react and update accordingly..
        popup.setOnAutoHide(e -> {
            MenuButton menuButton = getSkinnable();
            // work around for the fact autohide happens twice
            // remove this check when that is fixed.
            if (!menuButton.getProperties().containsKey(AUTOHIDE)) {
                menuButton.getProperties().put(AUTOHIDE, Boolean.TRUE);
            }
        });

        // request focus on content when the popup is shown
        popup.setOnShown(event -> {
            if (requestFocusOnFirstMenuItem) {
                requestFocusOnFirstMenuItem();
                requestFocusOnFirstMenuItem = false;
            } else {
                ContextMenuContent cmContent = (ContextMenuContent) popup.getSkin().getNode();
                if (cmContent != null) {
                    cmContent.requestFocus();
                }
            }
        });

        if (control.getOnAction() == null) {
            control.setOnAction(e -> control.show());
        }

        label.setLabelFor(control);
    }



    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override public void dispose() {
        super.dispose();

        if (behavior != null) {
            behavior.dispose();
        }
    }



    /***************************************************************************
     *                                                                         *
     * Private implementation                                                  *
     *                                                                         *
     **************************************************************************/

    @Override MenuButtonBehavior getBehavior() {
        return behavior;
    }



    /***************************************************************************
     *                                                                         *
     * Accessibility handling                                                  *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override
    public Object queryAccessibleAttribute(AccessibleAttribute attribute, Object... parameters) {
        switch (attribute) {
            case MNEMONIC: return label.queryAccessibleAttribute(AccessibleAttribute.MNEMONIC);
            default: return super.queryAccessibleAttribute(attribute, parameters);
        }
    }
}
