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

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import com.sun.javafx.scene.control.behavior.ListCellBehavior;

/**
 * Default skin implementation for the {@link ListCell} control.
 *
 * @see ListCell
 * @since 9
 */
public class ListCellSkin<T> extends CellSkinBase<ListCell<T>> {

    /***************************************************************************
     *                                                                         *
     * Private fields                                                          *
     *                                                                         *
     **************************************************************************/

    private double fixedCellSize;
    private boolean fixedCellSizeEnabled;
    private final BehaviorBase<ListCell<T>> behavior;



    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new ListCellSkin instance, installing the necessary child
     * nodes into the Control {@link Control#getChildren() children} list, as
     * well as the necessary input mappings for handling key, mouse, etc events.
     *
     * @param control The control that this skin should be installed onto.
     */
    public ListCellSkin(ListCell<T> control) {
        super(control);

        // install default input map for the ListCell control
        behavior = new ListCellBehavior<>(control);
//        control.setInputMap(behavior.getInputMap());

        setupListeners();
    }

    private void setupListeners() {
        ListView listView = getSkinnable().getListView();
        if (listView == null) {
            getSkinnable().listViewProperty().addListener(new InvalidationListener() {
                @Override public void invalidated(Observable observable) {
                    getSkinnable().listViewProperty().removeListener(this);
                    setupListeners();
                }
            });
        } else {
            this.fixedCellSize = listView.getFixedCellSize();
            this.fixedCellSizeEnabled = fixedCellSize > 0;
            registerChangeListener(listView.fixedCellSizeProperty(), e -> {
                this.fixedCellSize = getSkinnable().getListView().getFixedCellSize();
                this.fixedCellSizeEnabled = fixedCellSize > 0;
            });
        }
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

    /** {@inheritDoc} */
    @Override protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        double pref = super.computePrefWidth(height, topInset, rightInset, bottomInset, leftInset);
        ListView<T> listView = getSkinnable().getListView();
        return listView == null ? 0 :
            listView.getOrientation() == Orientation.VERTICAL ? pref : Math.max(pref, getCellSize());
    }

    /** {@inheritDoc} */
    @Override protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        if (fixedCellSizeEnabled) {
            return fixedCellSize;
        }

        // Added the comparison between the default cell size and the requested
        // cell size to prevent the issue identified in RT-19873.
        final double cellSize = getCellSize();
        final double prefHeight = cellSize == DEFAULT_CELL_SIZE ? super.computePrefHeight(width, topInset, rightInset, bottomInset, leftInset) : cellSize;
        return prefHeight;
    }

    /** {@inheritDoc} */
    @Override protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        if (fixedCellSizeEnabled) {
            return fixedCellSize;
        }

        return super.computeMinHeight(width, topInset, rightInset, bottomInset, leftInset);
    }

    /** {@inheritDoc} */
    @Override protected double computeMaxHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        if (fixedCellSizeEnabled) {
            return fixedCellSize;
        }

        return super.computeMaxHeight(width, topInset, rightInset, bottomInset, leftInset);
    }
}
