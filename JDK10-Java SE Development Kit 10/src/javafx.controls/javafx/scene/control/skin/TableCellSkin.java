/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.*;

import com.sun.javafx.scene.control.behavior.TableCellBehavior;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;

/**
 * Default skin implementation for the {@link TableCell} control.
 *
 * @param <S> The type of the UI control (e.g. the type of the 'row').
 * @param <T> The type of the content in the cell, based on its {@link TableColumn}.
 * @see TableCell
 * @since 9
 */
public class TableCellSkin<S,T> extends TableCellSkinBase<S, T, TableCell<S,T>> {

    /***************************************************************************
     *                                                                         *
     * Private Fields                                                          *
     *                                                                         *
     **************************************************************************/

    private final BehaviorBase<TableCell<S,T>> behavior;



    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new TableCellSkin instance, installing the necessary child
     * nodes into the Control {@link Control#getChildren() children} list, as
     * well as the necessary input mappings for handling key, mouse, etc events.
     *
     * @param control The control that this skin should be installed onto.
     */
    public TableCellSkin(TableCell<S,T> control) {
        super(control);

        // install default input map for the TableCell control
        behavior = new TableCellBehavior<>(control);
//        control.setInputMap(behavior.getInputMap());
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
    @Override public ReadOnlyObjectProperty<TableColumn<S,T>> tableColumnProperty() {
        return getSkinnable().tableColumnProperty();
    }
}
