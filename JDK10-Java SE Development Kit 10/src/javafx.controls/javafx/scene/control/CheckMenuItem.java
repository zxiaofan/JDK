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

package javafx.scene.control;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.scene.Node;

/**
 * <p>
 * A {@link MenuItem} that can be toggled between selected and unselected states.
 * It is intended that CheckMenuItem be used in conjunction with the
 * {@link Menu} or {@link ContextMenu} controls.
 * <p>
 * Creating and inserting a CheckMenuItem into a Menu is shown below.
<pre><code>
final subsystem1 = new CheckMenuItem("Enabled");
subsystem1.setOnAction(new EventHandler&lt;ActionEvent&gt;() {
    public void handle(ActionEvent e) {
        System.out.println("subsystem1 #1 Enabled!");
    }
});

Menu subsystemsMenu = new Menu("Subsystems");
subsystemsMenu.add(subsystem1);
</code></pre>
 * <p>
 * Of course, the approach shown above separates out the definition of the
 * CheckMenuItem from the Menu, but this needn't be so.
 * <p>
 * To ascertain the current state of the CheckMenuItem, you should refer to the
 * {@link #selectedProperty() selected} boolean. An example use case may be the following example:
<pre><code>
final checkMenuItem = new CheckMenuItem("Show Widget");
subsystem1.setOnAction(new EventHandler&lt;ActionEvent&gt;() {
    public void handle(ActionEvent e) {
        System.out.println("Show the widget!");
    }
});
private final BooleanProperty widgetShowing();
public final boolean isWidgetShowing() { return widgetShowing.get(); )
public final void setWidgetShowing(boolean value) {
    widgetShowingProperty().set(value);
}
public final BooleanProperty widgetShowingProperty() {
    if (widgetShowing == null) {
        widgetShowing = new SimpleBooleanProperty(this, "widgetShowing", true);
    }
    return widgetShowing;
}

widgetShowing.bind(checkMenuItem.selected);
</code></pre>
 * <p>
 * Typically a CheckMenuItem will be rendered such that, when selected, it shows
 * a check (or tick) mark in the area normally reserved for the MenuItem
 * graphic. Of course, this will vary depending on the skin and styling specified.
 *
 * @see Menu
 * @see MenuItem
 * @see RadioMenuItem
 *
 * @since JavaFX 2.0
 */
public class CheckMenuItem extends MenuItem {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    public CheckMenuItem() {
        this(null,null);
    }

    /**
     * Constructs a CheckMenuItem and sets the display text with the specified text.
     * @param text the display text
     */
    public CheckMenuItem(String text) {
        this(text,null);
    }

    /**
     * Constructs a CheckMenuItem and sets the display text with the specified text
     * and sets the graphic {@link Node} to the given node.
     * @param text the display text
     * @param graphic the graphic Node
     */
    public CheckMenuItem(String text, Node graphic) {
        super(text,graphic);
        getStyleClass().add(DEFAULT_STYLE_CLASS);
    }



    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/
    /**
     * Represents the current state of this CheckMenuItem. Bind to this to be
     * informed whenever the user interacts with the CheckMenuItem (and causes the
     * selected state to be toggled).
     *
     * @defaultValue false
     */
    private BooleanProperty selected;
    public final void setSelected(boolean value) {
        selectedProperty().set(value);
    }

    public final boolean isSelected() {
        return selected == null ? false : selected.get();
    }

    public final BooleanProperty selectedProperty() {
        if (selected == null) {
            selected = new BooleanPropertyBase() {
                @Override protected void invalidated() {
                    // force validation
                    get();

                    // update the styleclass
                    if (isSelected()) {
                        getStyleClass().add(STYLE_CLASS_SELECTED);
                    } else {
                        getStyleClass().remove(STYLE_CLASS_SELECTED);
                    }
                }

                @Override
                public Object getBean() {
                    return CheckMenuItem.this;
                }

                @Override
                public String getName() {
                    return "selected";
                }
            };
        }
        return selected;
    }

    /***************************************************************************
     *                                                                         *
     * Stylesheet Handling                                                     *
     *                                                                         *
     **************************************************************************/

    private static final String DEFAULT_STYLE_CLASS = "check-menu-item";
    private static final String STYLE_CLASS_SELECTED = "selected";
}
