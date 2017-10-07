/*
 * Copyright (c) 2012, 2017, Oracle and/or its affiliates. All rights reserved.
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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.control.skin.ColorPickerSkin;

/**
 * <p>ColorPicker control allows the user to select a color from either a standard
 * palette of colors with a simple one click selection OR define their own custom color.
 *
 * <p>The {@link #valueProperty() value} is the currently selected {@link javafx.scene.paint.Color}.
 * An initial color can be set by calling setColor or via the constructor. If nothing
 * is specified, a default initial color is used.
 *
 * <p>The ColorPicker control provides a color palette with a predefined set of colors. If
 * the user does not want to choose from the predefined set, they can create a custom
 * color by interacting with a custom color dialog. This dialog provides RGB,
 * HSB and Web modes of interaction, to create new colors. It also lets the opacity
 * of the color to be modified.
 *
 * <p>Once a new color is defined, users can choose whether they want to save it
 * or just use it. If the new color is saved, this color will then appear in the
 * custom colors area on the color palette. Also {@link #getCustomColors() getCustomColors}
 * returns the list of saved custom colors.
 *
 * <p>The {@link #promptTextProperty() promptText} is not supported and hence is a no-op.
 * But it may be supported in the future.
 *
 * <pre><code>
 * final ColorPicker colorPicker = new ColorPicker();
 * colorPicker.setOnAction(new EventHandler() {
 *     public void handle(Event t) {
 *         Color c = colorPicker.getValue();
 *         System.out.println("New Color's RGB = "+c.getRed()+" "+c.getGreen()+" "+c.getBlue());
 *     }
 * });
 * </code></pre>
 *
 * <p>The ColorPicker control's appearance can be styled in three ways: a simple Button mode,
 * MenuButton mode or SplitMenuButton mode. The default is MenuButton mode.
 * For a Button like appearance the style class to use is {@link #STYLE_CLASS_BUTTON STYLE_CLASS_BUTTON}
 * and for SplitMenuButton appearance and behavior, the style class to use is
 * {@link #STYLE_CLASS_SPLIT_BUTTON STYLE_CLASS_SPLIT_BUTTON}.
 *
 * <pre><code>
 * colorPicker.getStyleClass().add("button");
 * </code></pre>
 * or
 * <pre><code>
 * colorPicker.getStyleClass().add("split-button");
 * </code></pre>
 * @since JavaFX 2.2
 */
public class ColorPicker extends ComboBoxBase<Color> {

    /**
     * The style class to specify a Button like appearance of ColorPicker control.
     */
    public static final String STYLE_CLASS_BUTTON = "button";

    /**
     * The style class to specify a SplitMenuButton like appearance of ColorPicker control.
     */
    public static final String STYLE_CLASS_SPLIT_BUTTON = "split-button";

    /**
     * The custom colors added to the Color Palette by the user.
     */
    private ObservableList<Color> customColors = FXCollections.<Color>observableArrayList();
    /**
     * Gets the list of custom colors added to the Color Palette by the user.
     * @return the list of custom colors
     */
    public final ObservableList<Color>  getCustomColors() {
        return customColors;
    }

    /**
     * Creates a default ColorPicker instance with a selected color set to white.
     */
    public ColorPicker() {
        this(Color.WHITE);
    }

    /**
     * Creates a ColorPicker instance and sets the selected color to the given color.
     * @param color to be set as the currently selected color of the ColorPicker.
     */
    public ColorPicker(Color color) {
        setValue(color);
        getStyleClass().add(DEFAULT_STYLE_CLASS);
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override protected Skin<?> createDefaultSkin() {
        return new ColorPickerSkin(this);
    }

    /***************************************************************************
     *                                                                         *
     * Stylesheet Handling                                                     *
     *                                                                         *
     **************************************************************************/

    private static final String DEFAULT_STYLE_CLASS = "color-picker";
}
