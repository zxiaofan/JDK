/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene;

/**
 * This enum describes the actions that an assistive technology
 * such as a screen reader can request from the scene graph.
 *
 * The {@link AccessibleRole} dictates the set of actions that
 * the screen reader will request for a particular control. For
 * example, a push button normally fires an event to indicate
 * that it was pressed in response to the FIRE action.
 * <p>
 * An action may have any number of parameters, depending on the particular action.
 * </p>
 *
 * @see Node#executeAccessibleAction(AccessibleAction, Object...)
 * @see AccessibleRole
 * @see AccessibleAttribute#ROLE
 *
 * @since JavaFX 8u40
 */
public enum AccessibleAction {

    /**
     * Request that the node be decremented by a large value.
     * A smaller decrement is requested using {@link #DECREMENT}.
     * <p>Used by Slider, ScrollBar, and others </p>
     */
    BLOCK_DECREMENT,

    /**
     * Request that the node be incremented by a large value.
     * A smaller increment is requested using {@link #INCREMENT}.
     * <p>Used by Slider, ScrollBar, and others </p>
     */
    BLOCK_INCREMENT,

    /**
     * Request that the node should become collapsed.
     * <p>Used by TreeItem, TitledPane, and others </p>
     */
    COLLAPSE,

    /**
     * Request that the node be decremented by a small value.
     * A larger decrement is requested using {@link #BLOCK_DECREMENT}.
     * <p>Used by Slider, ScrollBar, and others </p>
     */
    DECREMENT,

    /**
     * Request that the node should become expanded.
     * <p>Used by TreeItem, TitledPane, and others </p>
     */
    EXPAND,

    /**
     * Fires the primary action for the node. For example, a push
     * button will normally send an action event to notify listeners
     * that is has been activated.
     * <p>Used by Button, Hyperlink, and others </p>
     */
    FIRE,

    /**
     * Request that the node be incremented by a small value.
     * A larger increment is requested using {@link #BLOCK_INCREMENT}.
     * <p>Used by Slider, ScrollBar, and others </p>
     */
    INCREMENT,

    /**
     * Request that the node take focus.  By default, a node will
     * request focus using  {@link javafx.scene.Node#requestFocus()}.
     * Both JavaFX and the assisteve technology have the concept of
     * a focus node and most of the time, they are the same.
     * In some cases, a control might want the JavaFX focus to remain
     * on the parent, while the assistive technology focus is on the child.
     * For example, a table may respond to this request by setting focus
     * to a cell inside the table before allowing the default to run.
     * <p>Used by Node, TabItem, TableCell and others </p>
     */
    REQUEST_FOCUS,

    /**
     * Request the node to show an item, scrolling if required.
     * <p>Used by ListView, TreeView, and others </p>
     *
     * Parameters:
     * <ul>
     * <li> {@link Node} the item to show </li>
     * </ul>
     */
    SHOW_ITEM,

    /**
     * Request the node to show a text range, scrolling if required.
     * <p>Used by TextField and TextArea. </p>
     *
     * Parameters:
     * <ul>
     * <li> {@link java.lang.Integer} the start offset </li>
     * <li> {@link java.lang.Integer} the end offset </li>
     * </ul>
     */
    SHOW_TEXT_RANGE,

    /**
     * Request the node to set the selection to a list of items.
     * <p>Used by ListView, TreeView, and others </p>
     *
     * Parameters:
     * <ul>
     * <li> {@link javafx.collections.ObservableList}&lt;{@link Node}&gt; the items to select </li>
     * </ul>
     */
    SET_SELECTED_ITEMS,

    /**
     * Request the node to set the selection to range of text.
     * <p>Used by TextField and TextArea. </p>
     *
     * Parameters:
     * <ul>
     * <li> {@link java.lang.Integer} the start offset </li>
     * <li> {@link java.lang.Integer} the end offset </li>
     * </ul>
     */
    SET_TEXT_SELECTION,

    /**
     * Request the node to set the current text.
     * <p>Used by TextField and TextArea. </p>
     *
     * Parameters:
     * <ul>
     * <li> {@link String} the new text</li>
     * </ul>
     */
    SET_TEXT,

    /**
     * Request the node to set the current value.
     * <p>Used by Slider, Scrollbars, and others </p>
     *
     * Parameters:
     * <ul>
     * <li> {@link java.lang.Double} the new value </li>
     * </ul>
     */
    SET_VALUE,

    /**
     * Request the node to show a menu.  If the node is a control,
     * then the context menu for the control is shown.  If the node
     * is a menu, then the submenu for the menu is shown.
     * <p>Used by Node, Menu</p>
     */
    SHOW_MENU,
}
