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

package com.sun.javafx.menu;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCombination;
import javafx.scene.Node;


public interface MenuItemBase {

    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    public void setId(String value);
    public String getId();
    public StringProperty idProperty();

    /**
     * The text to display in the menu item.
     */
    public void setText(String value);
    public String getText();
    public StringProperty textProperty();

    /**
     * An optional graphic for the menu item This will normally be
     * an {@link javafx.scene.image.ImageView} node, but there is no requirement for this to be
     * the case.
     */
    public void setGraphic(Node value);
    public Node getGraphic();
    public ObjectProperty<Node> graphicProperty();

    /**
     * The action, which is invoked whenever the MenuItemBase is fired. This
     * may be due to the user clicking on the button with the mouse, or by
     * a touch event, or by a key press, or if the developer programatically
     * invokes the {@link #fire()} method.
     */
    public void setOnAction(EventHandler<ActionEvent> value);
    public EventHandler<ActionEvent> getOnAction();
    public ObjectProperty<EventHandler<ActionEvent>> onActionProperty();


    // --- Disable
    public void setDisable(boolean value);
    public boolean isDisable();
    public BooleanProperty disableProperty();

    // --- Visible
    public void setVisible(boolean value);
    public boolean isVisible();
    public BooleanProperty visibleProperty();


    // --- Accelerator
    public void setAccelerator(KeyCombination value);
    public KeyCombination getAccelerator();
    public ObjectProperty<KeyCombination> acceleratorProperty();

    /**
     * MnemonicParsing property to enable/disable text parsing.
     * If this is set to true, then the MenuItemBase text will be
     * parsed to see if it contains the mnemonic parsing character '_'.
     * When a mnemonic is detected the key combination will
     * be determined based on the succeeding character, and the mnemonic
     * added.
     *
     * <p>
     * The default value for MenuItemBase is true.
     * </p>
     */
    public void setMnemonicParsing(boolean value);
    public boolean isMnemonicParsing();
    public BooleanProperty mnemonicParsingProperty();


    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/

    /**
     * Fires a new ActionEvent.
     */
    public void fire();

    /**
     * Fires when the accelerator for this MenuItem is invoked.
     */
    public void fireValidation();

}
