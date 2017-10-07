/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.scene.control.Properties;
import javafx.beans.InvalidationListener;
import javafx.beans.WeakInvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Control;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.TableColumnBase;
import javafx.scene.shape.Rectangle;

/**
 * Base skin for table cell controls, for example:
 * {@link javafx.scene.control.TableCell} and {@link javafx.scene.control.TreeTableCell}.
 *
 * @param <S> The type of the UI control (e.g. the type of the 'row').
 * @param <T> The type of the content in the cell, based on its {@link TableColumnBase}.
 * @see javafx.scene.control.TableCell
 * @see javafx.scene.control.TreeTableCell
 * @since 9
 */
public abstract class TableCellSkinBase<S, T, C extends IndexedCell<T>> extends CellSkinBase<C> {

    /***************************************************************************
     *                                                                         *
     * Private Fields                                                          *
     *                                                                         *
     **************************************************************************/

    boolean isDeferToParentForPrefWidth = false;



    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new TableCellSkinBase instance, installing the necessary child
     * nodes into the Control {@link Control#getChildren() children} list, as
     * well as the necessary input mappings for handling key, mouse, etc events.
     *
     * @param control The control that this skin should be installed onto.
     */
    public TableCellSkinBase(final C control) {
        super(control);

        // RT-22038
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(control.widthProperty());
        clip.heightProperty().bind(control.heightProperty());
        getSkinnable().setClip(clip);
        // --- end of RT-22038

        TableColumnBase<?,?> tableColumn = getTableColumn();
        if (tableColumn != null) {
            tableColumn.widthProperty().addListener(weakColumnWidthListener);
        }

        if (control.getProperties().containsKey(Properties.DEFER_TO_PARENT_PREF_WIDTH)) {
            isDeferToParentForPrefWidth = true;
        }
    }



    /***************************************************************************
     *                                                                         *
     * Listeners                                                               *
     *                                                                         *
     **************************************************************************/

    private InvalidationListener columnWidthListener = valueModel -> getSkinnable().requestLayout();

    private WeakInvalidationListener weakColumnWidthListener =
            new WeakInvalidationListener(columnWidthListener);



    /***************************************************************************
     *                                                                         *
     * Abstract Methods                                                        *
     *                                                                         *
     **************************************************************************/

    /**
     * The TableColumnBase instance that is responsible for this Cell.
     * @return the TableColumnBase instance that is responsible for this Cell
     */
    public abstract ReadOnlyObjectProperty<? extends TableColumnBase<S,T>> tableColumnProperty();
    public final TableColumnBase<S,T> getTableColumn() {
        return tableColumnProperty().get();
    }



    /***************************************************************************
     *                                                                         *
     * Public Methods                                                          *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override public void dispose() {
        TableColumnBase<?,T> tableColumn = getTableColumn();
        if (tableColumn != null) {
            tableColumn.widthProperty().removeListener(weakColumnWidthListener);
        }

        super.dispose();
    }

    /** {@inheritDoc} */
    @Override protected void layoutChildren(final double x, final double y,
            final double w, final double h) {
        // fit the cell within this space
        // FIXME the subtraction of bottom padding isn't right here - but it
        // results in better visuals, so I'm leaving it in place for now.
        layoutLabelInArea(x, y, w, h - getSkinnable().getPadding().getBottom());
    }

    /** {@inheritDoc} */
    @Override protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        if (isDeferToParentForPrefWidth) {
            return super.computePrefWidth(height, topInset, rightInset, bottomInset, leftInset);
        }

        TableColumnBase<?,?> tableColumn = getTableColumn();
        return tableColumn == null ? 0 : snapSizeX(tableColumn.getWidth());
    }
}
