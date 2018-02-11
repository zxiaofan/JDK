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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.css.StyleableDoubleProperty;
import javafx.css.CssMetaData;
import javafx.css.StyleOrigin;

import javafx.css.converter.SizeConverter;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.WritableValue;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.scene.control.Control;
import javafx.scene.control.SkinBase;

/**
 * Default skin implementation for the {@link Cell} control, and subclasses such
 * as {@link javafx.scene.control.ListCell}, {@link javafx.scene.control.TreeCell},
 * etc.
 *
 * @see Cell
 * @since 9
 */
public class CellSkinBase<C extends Cell> extends LabeledSkinBase<C> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new CellSkinBase instance, installing the necessary child
     * nodes into the Control {@link Control#getChildren() children} list, as
     * well as the necessary input mappings for handling key, mouse, etc events.
     *
     * @param control The control that this skin should be installed onto.
     */
    public CellSkinBase(final C control) {
        super (control);

        /**
         * The Cell does not typically want to block mouse events from going down
         * to the virtualized controls holding the cell. For example mouse clicks
         * on cells should also pass down to the ListView holding the cells.
         */
        consumeMouseEvents(false);
    }



    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    /**
     * The default cell size. For vertical ListView or a TreeView or TableView
     * this is the height, for a horizontal ListView this is the width. This
     * is settable from CSS
     */
    private DoubleProperty cellSize;

    public final double getCellSize() {
        return cellSize == null ? DEFAULT_CELL_SIZE : cellSize.get();
    }

    public final ReadOnlyDoubleProperty cellSizeProperty() {
        return cellSizePropertyImpl();
    }

    private DoubleProperty cellSizePropertyImpl() {
        if (cellSize == null) {
            cellSize = new StyleableDoubleProperty(DEFAULT_CELL_SIZE) {

                @Override
                public void applyStyle(StyleOrigin origin, Number value) {
                    double size = value == null ? DEFAULT_CELL_SIZE : value.doubleValue();
                    // guard against a 0 or negative size
                    super.applyStyle(origin, size <= 0 ? DEFAULT_CELL_SIZE : size);
                }


                @Override public void set(double value) {
//                    // Commented this out due to RT-19794, because otherwise
//                    // cellSizeSet would be false when the default caspian.css
//                    // cell size was set. This would lead to
//                    // ListCellSkin.computePrefHeight computing the pref height
//                    // of the cell (which is about 22px), rather than use the
//                    // value provided by caspian.css (which is 24px).
//                    // cellSizeSet = true;//value != DEFAULT_CELL_SIZE;
                    super.set(value);
                    getSkinnable().requestLayout();
                }

                @Override public Object getBean() {
                    return CellSkinBase.this;
                }

                @Override public String getName() {
                    return "cellSize";
                }

                @Override public CssMetaData<Cell<?>, Number> getCssMetaData() {
                    return StyleableProperties.CELL_SIZE;
                }
            };
        }
        return cellSize;
    }



    /***************************************************************************
     *                                                                         *
     *                         Stylesheet Handling                             *
     *                                                                         *
     **************************************************************************/

    static final double DEFAULT_CELL_SIZE = 24.0;

     /*
      * Super-lazy instantiation pattern from Bill Pugh.
      */
     private static class StyleableProperties {
         private final static CssMetaData<Cell<?>,Number> CELL_SIZE =
                new CssMetaData<Cell<?>,Number>("-fx-cell-size",
                 SizeConverter.getInstance(), DEFAULT_CELL_SIZE) {

            @Override
            public boolean isSettable(Cell<?> n) {
                final CellSkinBase<?> skin = (CellSkinBase<?>) n.getSkin();
                return skin.cellSize == null || !skin.cellSize.isBound();
            }

            @Override
            public StyleableProperty<Number> getStyleableProperty(Cell<?> n) {
                final CellSkinBase<?> skin = (CellSkinBase<?>) n.getSkin();
                return (StyleableProperty<Number>)(WritableValue<Number>)skin.cellSizePropertyImpl();
            }
        };

         private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;
         static {

            final List<CssMetaData<? extends Styleable, ?>> styleables =
                new ArrayList<CssMetaData<? extends Styleable, ?>>(SkinBase.getClassCssMetaData());
            styleables.add(CELL_SIZE);
            STYLEABLES = Collections.unmodifiableList(styleables);

         }
    }

    /**
     * Returns the CssMetaData associated with this class, which may include the
     * CssMetaData of its superclasses.
     * @return the CssMetaData associated with this class, which may include the
     * CssMetaData of its superclasses
     */
    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }

    /** {@inheritDoc} */
    @Override public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return getClassCssMetaData();
    }

}
