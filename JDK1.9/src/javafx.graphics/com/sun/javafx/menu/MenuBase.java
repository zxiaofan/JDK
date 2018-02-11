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

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;


public interface MenuBase extends MenuItemBase {

//    /**
//     * <p>Called when the menu <b>will</b> be shown.
//     * </p>
//     */
//    public static EventType<Event> ON_SHOWING =
//            EventTypeUtil.registerInternalEventType(Event.ANY, "ON_SHOWING");
//
//    /**
//     * <p>Called when the menu is shown.
//     * </p>
//     */
//    public static EventType<Event> ON_SHOWN =
//            EventTypeUtil.registerInternalEventType(Event.ANY, "ON_SHOWN");
//
//    /**
//     * <p>Called when the menu <b>will</b> be hidden.
//     * </p>
//     */
//    public static EventType<Event> ON_HIDING =
//            EventTypeUtil.registerInternalEventType(Event.ANY, "ON_HIDING");
//
//    /**
//     * <p>Called when the menu is hidden.
//     * </p>
//     */
//    public static EventType<Event> ON_HIDDEN =
//            EventTypeUtil.registerInternalEventType(Event.ANY, "ON_HIDDEN");



     /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    /*
     * Indicates whether the menu is currently visible.
     */
    public boolean isShowing();
    public ReadOnlyBooleanProperty showingProperty();

    // --- On Showing
    public ObjectProperty<EventHandler<Event>> onShowingProperty();
    /**
     * Called just prior to the menu being shown, even if the menu has
     * no items to show. Note however that this won't be called if the menu does
     * not have a valid anchor node.
     */
    public void setOnShowing(EventHandler<Event> value);
    public EventHandler<Event> getOnShowing();

    // -- On Shown
    public ObjectProperty<EventHandler<Event>> onShownProperty();
    /**
     * Called just after the menu is shown.
     */
    public void setOnShown(EventHandler<Event> value);
    public EventHandler<Event> getOnShown();


    // --- On Hiding
    public ObjectProperty<EventHandler<Event>> onHidingProperty();
    /**
     * Called just prior to the menu being hidden.
     */
    public void setOnHiding(EventHandler<Event> value);
    public EventHandler<Event> getOnHiding();


    // --- On Hidden
    public ObjectProperty<EventHandler<Event>> onHiddenProperty();
    /**
     * Called just after the menu has been hidden.
     */
    public void setOnHidden(EventHandler<Event> value);
    public EventHandler<Event> getOnHidden();


    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/

    public ObservableList<MenuItemBase> getItemsBase();

    /**
     * If the menu is not disabled and is not already showing,
     * then this will cause the menu to be shown.
     */
    public void show();

    /**
     * Hides the menu if it was previously showing, and any showing
     * submenus. If this menu is not showing, then invoking this function
     * has no effect.
     */
    public void hide();

}
