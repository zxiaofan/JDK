/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.java.swing.plaf.gtk;

import sun.swing.SwingUtilities2;
import java.util.*;
import javax.swing.plaf.*;
import javax.swing.plaf.synth.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.lang.reflect.*;
import java.security.*;

import sun.awt.AppContext;
import sun.swing.plaf.synth.*;

/**
 *
 * @author Scott Violet
 */
abstract class GTKStyle extends SynthStyle implements GTKConstants {
    private static final String ICON_PROPERTY_PREFIX = "gtk.icon.";

    static final Color BLACK_COLOR = new ColorUIResource(Color.BLACK);
    static final Color WHITE_COLOR = new ColorUIResource(Color.WHITE);

    static final Font DEFAULT_FONT = new FontUIResource("sansserif", 
                                                        Font.PLAIN, 10  );
    static final Insets BUTTON_DEFAULT_BORDER_INSETS = new Insets(1, 1, 1, 1);
    
    private static final GTKGraphicsUtils GTK_GRAPHICS = new GTKGraphicsUtils();

    /**
     * Maps from a key that is passed to Style.get to the equivalent class
     * specific key.
     */
    private static final Map<String,String> CLASS_SPECIFIC_MAP;

    /**
     * Backing style properties that are used if the style does not
     * defined the property.
     */
    private static final Map<String,GTKStockIcon> ICONS_MAP;

    /**
     * User specific font.
     */
    private Font font;

    GTKStyle(Font font) {
        this.font = font;
    }
    
    Color getGTKColor(int state, ColorType type) {
        return getGTKColor(null, state, type);
    }

    public void installDefaults(SynthContext context) {
        super.installDefaults(context);
        if (!context.getRegion().isSubregion()) {
            context.getComponent().putClientProperty(
                SwingUtilities2.AA_TEXT_PROPERTY_KEY,		
                GTKLookAndFeel.aaTextInfo);
        }        
    }

    public SynthGraphicsUtils getGraphicsUtils(SynthContext context) {
        return GTK_GRAPHICS;
    }

    /**
     * Returns a <code>SynthPainter</code> that will route the appropriate
     * calls to a <code>GTKEngine</code>.
     *
     * @param state SynthContext indentifying requestor
     * @return SynthPainter
     */
    public SynthPainter getPainter(SynthContext state) {
        return GTKPainter.INSTANCE;
    }

    protected Color getColorForState(SynthContext context, ColorType type) {
        if (type == ColorType.FOCUS || type == GTKColorType.BLACK) {
            return BLACK_COLOR;
        }
        else if (type == GTKColorType.WHITE) {
            return WHITE_COLOR;
        }
        
        Region id = context.getRegion();
        int state = context.getComponentState();
        state = GTKLookAndFeel.synthStateToGTKState(id, state);

        if (type == ColorType.TEXT_FOREGROUND && 
               (id == Region.BUTTON || 
                id == Region.CHECK_BOX ||
                id == Region.CHECK_BOX_MENU_ITEM || 
                id == Region.MENU ||
                id == Region.MENU_ITEM || 
                id == Region.RADIO_BUTTON ||
                id == Region.RADIO_BUTTON_MENU_ITEM ||
                id == Region.TABBED_PANE_TAB ||
                id == Region.TOGGLE_BUTTON || 
                id == Region.TOOL_TIP || 
                id == Region.MENU_ITEM_ACCELERATOR ||
                id == Region.TABBED_PANE_TAB)) {
            type = ColorType.FOREGROUND;
        } else if (id == Region.TABLE || 
                   id == Region.LIST ||
                   id == Region.TREE || 
                   id == Region.TREE_CELL) {
            if (type == ColorType.FOREGROUND) {
                type = ColorType.TEXT_FOREGROUND;
                if (state == SynthConstants.PRESSED) {
                    state = SynthConstants.SELECTED;
                }
            }
        }

        return getStyleSpecificColor(context, state, type);
    }

    /**
     * Returns color specific for Native or Default style. This method is 
     * invoked when other variants don't fit.
     *
     */
    abstract Color getStyleSpecificColor(SynthContext context, int state, ColorType type);
    
    /**
     * Returns the color for the specified state.
     *
     * @param context SynthContext identifying requester
     * @param state to get the color for
     * @param type of the color
     * @return Color to render with
     */
    Color getGTKColor(SynthContext context, int state, ColorType type) {
        if (context != null) {
            JComponent c = context.getComponent();
            Region id = context.getRegion();
    
            state = GTKLookAndFeel.synthStateToGTKState(id, state);
            if (!id.isSubregion() &&
                (state & SynthConstants.ENABLED) != 0) {
                if (type == ColorType.BACKGROUND || 
                    type == ColorType.TEXT_BACKGROUND) {
                    Color bg = c.getBackground();
                    if (!(bg instanceof UIResource)) {
                        return bg;
                    }
                }
                else if (type == ColorType.FOREGROUND || 
                         type == ColorType.TEXT_FOREGROUND) {
                    Color fg = c.getForeground();
                    if (!(fg instanceof UIResource)) {
                        return fg;
                    }
                }
            }
        }
        
        return getStyleSpecificColor(context, state, type);
    }

    public Color getColor(SynthContext context, ColorType type) {
        JComponent c = context.getComponent();
        Region id = context.getRegion();
        int state = context.getComponentState();

        if (c.getName() == "Table.cellRenderer") {
             if (type == ColorType.BACKGROUND) {
                 return c.getBackground();
             } 
             if (type == ColorType.FOREGROUND) {
                 return c.getForeground();
             } 
        }

        if (id == Region.LABEL && type == ColorType.TEXT_FOREGROUND) {
            type = ColorType.FOREGROUND;
        }

        // For the enabled state, prefer the widget's colors
        if (!id.isSubregion() && (state & SynthConstants.ENABLED) != 0) {
            if (type == ColorType.BACKGROUND) {
                return c.getBackground();
            }
            else if (type == ColorType.FOREGROUND) {
                return c.getForeground();
            }
            else if (type == ColorType.TEXT_FOREGROUND) {
                // If getForeground returns a non-UIResource it means the
                // developer has explicitly set the foreground, use it over
                // that of TEXT_FOREGROUND as that is typically the expected
                // behavior.
                Color color = c.getForeground();
                if (color != null && !(color instanceof UIResource)) {
                    return color;
                }
            }
        }
        return getColorForState(context, type);
    }
    
    /**
     * Returns the font for the specified state.
     *
     * @param c JComponent the style is associated with
     * @param id Region identifier
     * @param state State of the region.
     * @return Font to render with
     */
    protected Font getFontForState(JComponent c, Region id, int state) {
        return font != null ? font : DEFAULT_FONT;
    }    
    
    protected Font getFontForState(SynthContext context) {
        return getFontForState(context.getComponent(), context.getRegion(),
                               context.getComponentState());
    }
    
    /**
     * Returns fontname specific for the given WidgetType
     *
     * @param wt WidgetType to return fontname for
     * @return fontname
     */
    String getFontNameForWidgetType(WidgetType wt) {
        return GTKLookAndFeel.DEFAULT_FONT_NAME;
    }
    
    
    /**
     * Returns the X thickness to use for this GTKStyle.
     *
     * @return x thickness.
     */
    abstract int getXThickness();

    /**
     * Returns the Y thickness to use for this GTKStyle.
     *
     * @return x thickness.
     */
    abstract int getYThickness();
    
    /**
     * Returns the value for a class specific property. A class specific value
     * is a value that will be picked up based on class hierarchy.
     *
     * @param context SynthContext indentifying requestor
     * @param key Key identifying class specific value
     * @return Value, or null if one has not been defined.
     */
    abstract Object getClassSpecificValue(Region region, String key);

    /**
     * Returns the Insets. If <code>insets</code> is non-null the resulting
     * insets will be placed in it, otherwise a new Insets object will be
     * created and returned.
     *
     * @param context SynthContext indentifying requestor
     * @param insets Where to place Insets
     * @return Insets.
     */
    public Insets getInsets(SynthContext state, Insets insets) {
        Region id = state.getRegion();
        String name = (id.isSubregion()) ? null :
                                           state.getComponent().getName();

        if (insets == null) {
            insets = new Insets(0, 0, 0, 0);
        } else {
            insets.top = insets.bottom = insets.left = insets.right = 0;
        }
        
        if (id == Region.ARROW_BUTTON || id == Region.BUTTON ||
                id == Region.TOGGLE_BUTTON) {
            if ("Spinner.previousButton" == name ||
                    "Spinner.nextButton" == name) {
                return getSimpleInsets(state, insets, 1);
            } else {
                return getButtonInsets(state, insets);
            }
        }
        else if (id == Region.CHECK_BOX || id == Region.RADIO_BUTTON) {
            return getRadioInsets(state, insets);
        }
        else if (id == Region.MENU_BAR) {
            return getMenuBarInsets(state, insets);
        }
        else if (id == Region.MENU ||
                 id == Region.MENU_ITEM ||
                 id == Region.CHECK_BOX_MENU_ITEM ||
                 id == Region.RADIO_BUTTON_MENU_ITEM) {
            return getMenuItemInsets(state, insets);
        }
        else if (id == Region.FORMATTED_TEXT_FIELD) {
            return getTextFieldInsets(state, insets);
        }
        else if (id == Region.INTERNAL_FRAME) {
            insets = Metacity.INSTANCE.getBorderInsets(state, insets);
        }
        else if (id == Region.LABEL) {
            if ("TableHeader.renderer" == name) {
                return getButtonInsets(state, insets);
            }
            else if ("ComboBox.renderer" == name ||
                     "ComboBox.listRenderer" == name) {
                return getTextFieldInsets(state, insets);
            }
            else if ("Tree.cellRenderer" == name) {
                return getSimpleInsets(state, insets, 1);
            }
        }
        else if (id == Region.OPTION_PANE) {
            return getSimpleInsets(state, insets, 6);
        }
        else if (id == Region.POPUP_MENU) {
            return getSimpleInsets(state, insets, 2);
        }
        else if (id == Region.PROGRESS_BAR || id == Region.SLIDER ||
                 id == Region.TABBED_PANE  || id == Region.TABBED_PANE_CONTENT ||
                 id == Region.TOOL_BAR     ||
                 id == Region.TOOL_BAR_DRAG_WINDOW ||
                 id == Region.TOOL_TIP) {
            return getThicknessInsets(state, insets);
        }
        else if (id == Region.SCROLL_BAR) {
            return getScrollBarInsets(state, insets);
        }
        else if (id == Region.SLIDER_TRACK) {
            return getSliderTrackInsets(state, insets);
        }
        else if (id == Region.TABBED_PANE_TAB) {
            return getTabbedPaneTabInsets(state, insets);
        }
        else if (id == Region.TEXT_FIELD || id == Region.PASSWORD_FIELD) {
            if (name == "Tree.cellEditor") {
                return getSimpleInsets(state, insets, 1);
            }
            return getTextFieldInsets(state, insets);
        }
        else if (id == Region.SEPARATOR ||
                 id == Region.POPUP_MENU_SEPARATOR ||
                 id == Region.TOOL_BAR_SEPARATOR) {
            return getSeparatorInsets(state, insets);
        }
        return insets;
    }

    private Insets getButtonInsets(SynthContext context, Insets insets) {
        // The following calculations are derived from gtkbutton.c
        // (GTK+ version 2.8.20), gtk_button_size_allocate() method.
        int CHILD_SPACING = 1;
        int focusSize = getClassSpecificIntValue(context, "focus-line-width",1);
        int focusPad = getClassSpecificIntValue(context, "focus-padding", 1);
        int xThickness = getXThickness();
        int yThickness = getYThickness();
        int w = focusSize + focusPad + xThickness + CHILD_SPACING;
        int h = focusSize + focusPad + yThickness + CHILD_SPACING;
        insets.left = insets.right = w;
        insets.top = insets.bottom = h;

        Component component = context.getComponent();
        if ((component instanceof JButton) &&
            !(component.getParent() instanceof JToolBar) &&
            ((JButton)component).isDefaultCapable())
        {
            // Include the default border insets, but only for JButtons
            // that are default capable.  Note that
            // JButton.getDefaultCapable() returns true by default, but
            // GtkToolButtons are never default capable, so we skip this
            // step if the button is contained in a toolbar.
            Insets defaultInsets = getClassSpecificInsetsValue(context,
                          "default-border", BUTTON_DEFAULT_BORDER_INSETS);
            insets.left += defaultInsets.left;
            insets.right += defaultInsets.right;
            insets.top += defaultInsets.top;
            insets.bottom += defaultInsets.bottom;
        }

        return insets;
    }

    /*
     * This is used for both RADIO_BUTTON and CHECK_BOX.
     */
    private Insets getRadioInsets(SynthContext context, Insets insets) {
        // The following calculations are derived from gtkcheckbutton.c
        // (GTK+ version 2.8.20), gtk_check_button_size_allocate() method.
        int focusSize =
            getClassSpecificIntValue(context, "focus-line-width", 1);
        int focusPad =
            getClassSpecificIntValue(context, "focus-padding", 1);
        int totalFocus = focusSize + focusPad;

        // Note: GTKIconFactory.DelegateIcon will have already included the
        // "indicator-spacing" value in the size of the indicator icon,
        // which explains why we use zero as the left inset (or right inset
        // in the RTL case); see 6489585 for more details.
        insets.top    = totalFocus;
        insets.bottom = totalFocus;
        if (context.getComponent().getComponentOrientation().isLeftToRight()) {
            insets.left  = 0;
            insets.right = totalFocus;
        } else {
            insets.left  = totalFocus;
            insets.right = 0;
        }

        return insets;
    }

    private Insets getMenuBarInsets(SynthContext context, Insets insets) {
        // The following calculations are derived from gtkmenubar.c
        // (GTK+ version 2.8.20), gtk_menu_bar_size_allocate() method.
        int internalPadding = getClassSpecificIntValue(context,
                                                       "internal-padding", 1);
        int xThickness = getXThickness();
        int yThickness = getYThickness();
        insets.left = insets.right = xThickness + internalPadding;
        insets.top = insets.bottom = yThickness + internalPadding;
        return insets;
    }

    private Insets getMenuItemInsets(SynthContext context, Insets insets) {
        // The following calculations are derived from gtkmenuitem.c
        // (GTK+ version 2.8.20), gtk_menu_item_size_allocate() method.
        int horizPadding = getClassSpecificIntValue(context,
                                                    "horizontal-padding", 3);
        int xThickness = getXThickness();
        int yThickness = getYThickness();
        insets.left = insets.right = xThickness + horizPadding;
        insets.top = insets.bottom = yThickness;
        return insets;
    }

    private Insets getThicknessInsets(SynthContext context, Insets insets) {
        insets.left = insets.right = getXThickness();
        insets.top = insets.bottom = getYThickness();
        return insets;
    }

    private Insets getSeparatorInsets(SynthContext context, Insets insets) {
        int horizPadding = 0;
        if (context.getRegion() == Region.POPUP_MENU_SEPARATOR) {
            horizPadding =
                getClassSpecificIntValue(context, "horizontal-padding", 3);
        }
        insets.right = insets.left = getXThickness() + horizPadding;
        insets.top = insets.bottom = getYThickness();
        return insets;
    }

    private Insets getSliderTrackInsets(SynthContext context, Insets insets) {
        int focusSize = getClassSpecificIntValue(context, "focus-line-width", 1);
        int focusPad = getClassSpecificIntValue(context, "focus-padding", 1);
        insets.top = insets.bottom =
                insets.left = insets.right = focusSize + focusPad;
        return insets;
    }

    private Insets getSimpleInsets(SynthContext context, Insets insets, int n) {
        insets.top = insets.bottom = insets.right = insets.left = n;
        return insets;
    }
    
    private Insets getTabbedPaneTabInsets(SynthContext context, Insets insets) {
        int xThickness = getXThickness();
        int yThickness = getYThickness();
        int focusSize = getClassSpecificIntValue(context, "focus-line-width",1);
        int pad = 2;
        
        insets.left = insets.right = focusSize + pad + xThickness;
        insets.top = insets.bottom = focusSize + pad + yThickness;
        return insets;
    }
    
    // NOTE: this is called for ComboBox, and FormattedTextField. too.
    private Insets getTextFieldInsets(SynthContext context, Insets insets) {
        int xThickness = getXThickness();
        int yThickness = getYThickness();
        boolean interiorFocus =
                getClassSpecificBoolValue(context, "interior-focus", true);
        int focusSize = 0;

        if (!interiorFocus) {
            focusSize = getClassSpecificIntValue(context, "focus-line-width",1);
        }
        
        insets.left = insets.right = focusSize + xThickness + 2;
        insets.top = insets.bottom = focusSize + yThickness + 2;
        return insets;
    }

    private Insets getScrollBarInsets(SynthContext context, Insets insets) {
        int troughBorder = 
            getClassSpecificIntValue(context, "trough-border", 1); 
        insets.left = insets.right = insets.top = insets.bottom = troughBorder; 
 
        JComponent c = context.getComponent(); 
        if (c.getParent() instanceof JScrollPane) { 
            // This scrollbar is part of a scrollpane; use only the 
            // "scrollbar-spacing" style property to determine the padding 
            // between the scrollbar and its parent scrollpane. 
            int spacing = 
                getClassSpecificIntValue(WidgetType.SCROLL_PANE, 
                                         "scrollbar-spacing", 3); 
            if (((JScrollBar)c).getOrientation() == JScrollBar.HORIZONTAL) { 
                insets.top += spacing; 
            } else { 
                if (c.getComponentOrientation().isLeftToRight()) { 
                    insets.left += spacing; 
                } else { 
                    insets.right += spacing; 
                } 
            } 
        } else { 
            // This is a standalone scrollbar; leave enough room for the 
            // focus line in addition to the trough border. 
            if (c.isFocusable()) { 
                int focusSize = 
                    getClassSpecificIntValue(context, "focus-line-width", 1); 
                int focusPad = 
                    getClassSpecificIntValue(context, "focus-padding", 1);
                int totalFocus = focusSize + focusPad; 
                insets.left   += totalFocus; 
                insets.right  += totalFocus; 
                insets.top    += totalFocus; 
                insets.bottom += totalFocus; 
            }
        }
        return insets;
    }
   
    /**
     * Returns the value for a class specific property for a particular
     * WidgetType.  This method is useful in those cases where we need to
     * fetch a value for a Region that is not associated with the component
     * currently in use (e.g. we need to figure out the insets for a
     * SCROLL_BAR, but certain values can only be extracted from a
     * SCROLL_PANE region).
     *
     * @param wt WidgetType for which to fetch the value
     * @param key Key identifying class specific value
     * @return Value, or null if one has not been defined
     */
    Object getClassSpecificValue(WidgetType wt, String key) {
        return null;
    }

    /**
     * Convenience method to get a class specific integer value for
     * a particular WidgetType.
     *
     * @param wt WidgetType for which to fetch the value
     * @param key Key identifying class specific value
     * @param defaultValue Returned if there is no value for the specified
     *        type
     * @return Value, or defaultValue if <code>key</code> is not defined
     */
    int getClassSpecificIntValue(WidgetType wt, String key,
                                                int defaultValue)
    {
        Object value = getClassSpecificValue(wt, key);
        if (value instanceof Number) {
            return ((Number)value).intValue();
        }
        return defaultValue;
    }

    /**
     * Returns the value for a class specific property. A class specific value
     * is a value that will be picked up based on class hierarchy.
     *
     * @param context SynthContext indentifying requestor
     * @param key Key identifying class specific value
     * @return Value, or null if one has not been defined.
     */
    Object getClassSpecificValue(SynthContext context, String key) {
        return getClassSpecificValue(context.getRegion(), key);
    }


    /**
     * Convenience method to get a class specific integer value.
     *
     * @param context SynthContext indentifying requestor
     * @param key Key identifying class specific value
     * @param defaultValue Returned if there is no value for the specified
     *        type
     * @return Value, or defaultValue if <code>key</code> is not defined
     */
    public int getClassSpecificIntValue(SynthContext context, String key,
                                           int defaultValue) {
        Object value = getClassSpecificValue(context, key);

        if (value instanceof Number) {
            return ((Number)value).intValue();
        }
        return defaultValue;
    }

    /**
     * Convenience method to get a class specific Insets value.
     *
     * @param context SynthContext indentifying requestor
     * @param key Key identifying class specific value
     * @param defaultValue Returned if there is no value for the specified
     *        type
     * @return Value, or defaultValue if <code>key</code> is not defined
     */
    Insets getClassSpecificInsetsValue(SynthContext context, String key,
                                              Insets defaultValue) {
        Object value = getClassSpecificValue(context, key);

        if (value instanceof Insets) {
            return (Insets)value;
        }
        return defaultValue;
    }

    /**
     * Convenience method to get a class specific Boolean value.
     *
     * @param context SynthContext indentifying requestor
     * @param key Key identifying class specific value
     * @param defaultValue Returned if there is no value for the specified
     *        type
     * @return Value, or defaultValue if <code>key</code> is not defined
     */
    boolean getClassSpecificBoolValue(SynthContext context, String key,
                                             boolean defaultValue) {
        Object value = getClassSpecificValue(context, key);

        if (value instanceof Boolean) {
            return ((Boolean)value).booleanValue();
        }
        return defaultValue;
    }

    /**
     * Returns the value to initialize the opacity property of the Component
     * to. A Style should NOT assume the opacity will remain this value, the
     * developer may reset it or override it.
     *
     * @param context SynthContext indentifying requestor
     * @return opaque Whether or not the JComponent is opaque.
     */
    public boolean isOpaque(SynthContext context) {
        Region region = context.getRegion();
        if (region == Region.COMBO_BOX ||
              region == Region.DESKTOP_PANE ||
              region == Region.DESKTOP_ICON ||
              region == Region.EDITOR_PANE ||
              region == Region.FORMATTED_TEXT_FIELD ||
              region == Region.INTERNAL_FRAME ||
              region == Region.LIST ||
              region == Region.MENU_BAR ||
              region == Region.PANEL ||
              region == Region.PASSWORD_FIELD || 
              region == Region.POPUP_MENU ||
              region == Region.PROGRESS_BAR ||
              region == Region.ROOT_PANE ||
              region == Region.SCROLL_PANE ||
              region == Region.SPINNER ||
              region == Region.SPLIT_PANE_DIVIDER ||
              region == Region.TABLE ||
              region == Region.TEXT_AREA ||
              region == Region.TEXT_FIELD ||
              region == Region.TEXT_PANE ||
              region == Region.TOOL_BAR_DRAG_WINDOW ||
              region == Region.TOOL_TIP ||
              region == Region.TREE ||
              region == Region.VIEWPORT) {
            return true;
        }
        Component c = context.getComponent();
        String name = c.getName();
        if (name == "ComboBox.renderer" || name == "ComboBox.listRenderer") {
            return true;
        }
        return false;
    }
    
    public Object get(SynthContext context, Object key) {
        // See if this is a class specific value.
        String classKey = CLASS_SPECIFIC_MAP.get(key);
        if (classKey != null) {
            Object value = getClassSpecificValue(context, classKey);
            if (value != null) {
                return value;
            }
        }
        
        // Is it a specific value ?
        if (key == "ScrollPane.viewportBorderInsets") {
            return getThicknessInsets(context, new Insets(0, 0, 0, 0));
        }
        else if (key == "Slider.tickColor") {
            return getColorForState(context, ColorType.FOREGROUND);
        }
        else if (key == "Separator.thickness") {
            JSeparator sep = (JSeparator)context.getComponent();
            if (sep.getOrientation() == JSeparator.HORIZONTAL) {
                return getYThickness();
            } else {
                return getXThickness();
            }
        }
        else if (key == "ToolBar.separatorSize") {
            int size = getClassSpecificIntValue(WidgetType.TOOL_BAR, 
                                                "space-size", 12);
            return new DimensionUIResource(size, size);
        }
        else if ("CheckBox.iconTextGap".equals(key) ||
                 "RadioButton.iconTextGap".equals(key))
        {
            // The iconTextGap value needs to include "indicator-spacing"
            // and it also needs to leave enough space for the focus line,
            // which falls between the indicator icon and the text.
            // See getRadioInsets() and 6489585 for more details.
            int indicatorSpacing =
                getClassSpecificIntValue(context, "indicator-spacing", 2);
            int focusSize =
                getClassSpecificIntValue(context, "focus-line-width", 1);
            int focusPad =
                getClassSpecificIntValue(context, "focus-padding", 1);
            return indicatorSpacing + focusSize + focusPad;
        } else if (key == "ScrollBar.minimumThumbSize") {
            int len = getClassSpecificIntValue(context, "min-slider-length", 21);
            JScrollBar sb = (JScrollBar)context.getComponent();
            if (sb.getOrientation() == JScrollBar.HORIZONTAL) {
                return new DimensionUIResource(len, 0);
            } else {
                return new DimensionUIResource(0, len);
            }
        } else if (key == "ScrollBar.buttonSize") {
            JScrollBar sb = (JScrollBar)context.getComponent().getParent();
            boolean horiz = (sb.getOrientation() == JScrollBar.HORIZONTAL);
            WidgetType wt = horiz ?
                WidgetType.HSCROLL_BAR : WidgetType.VSCROLL_BAR;
            int sliderWidth = getClassSpecificIntValue(wt, "slider-width", 14);
            int stepperSize = getClassSpecificIntValue(wt, "stepper-size", 14);
            return horiz ?
                new DimensionUIResource(stepperSize, sliderWidth) :
                new DimensionUIResource(sliderWidth, stepperSize);
        } else if (key == "ArrowButton.size") {
            String name = context.getComponent().getName();
            if (name != null && name.startsWith("Spinner")) {
                // Believe it or not, the size of a spinner arrow button is
                // dependent upon the size of the spinner's font.  These
                // calculations come from gtkspinbutton.c (version 2.8.20),
                // spin_button_get_arrow_size() method.
                String pangoFontName = getFontNameForWidgetType(WidgetType.SPINNER);
                int arrowSize = (pangoFontName != null) ?
                    PangoFonts.getFontSize(pangoFontName) : 10;
                return (arrowSize + (getXThickness() * 2));
            }
            // For all other kinds of arrow buttons (e.g. combobox arrow
            // buttons), we will simply fall back on the value of
            // ArrowButton.size as defined in the UIDefaults for
            // GTKLookAndFeel when we call UIManager.get() below...
        }
        
        // Is it a stock icon ?
        GTKStockIcon stockIcon = null;
        synchronized (ICONS_MAP) {
            stockIcon = ICONS_MAP.get(key);
        }
        
        if (stockIcon != null) {
            return stockIcon;
        }
        
        // Is it another kind of value ?
        if (key != "engine") {
            // For backward compatability we'll fallback to the UIManager.
            // We don't go to the UIManager for engine as the engine is GTK
            // specific.
            Object value = UIManager.get(key);
            if (key == "Table.rowHeight") {
                int focusLineWidth = getClassSpecificIntValue(context, 
                        "focus-line-width", 0);
                if (value == null && focusLineWidth > 0) {
                    value = new Integer(16 + 2 * focusLineWidth);
                }
            }
            return value;
        }
        
        // Don't call super, we don't want to pick up defaults from
        // SynthStyle.
        return null;
    }

    /**
     * Returns true if the style should fill in the background of the
     * specified context for the specified state.
     */
    boolean fillBackground(SynthContext context, int state) {
        return true;
    }

    /**
     * Returns the Icon to fill the background in with for the specified
     * context and state.
     */
    Image getBackgroundImage(SynthContext context, int state) {
        return null;
    }

    private Icon getStockIcon(SynthContext context, String key, int type) {
        Icon icon = null;
        TextDirection direction = TextDirection.LTR;
        
        if (context != null) {
            ComponentOrientation co = context.getComponent().
                                              getComponentOrientation();

            if (co != null && !co.isLeftToRight()) {
                direction = TextDirection.RTL;
            }
        }
        
        icon = getStyleSpecificIcon(key, direction, type);
        // Native GTK does resizing for us.
        if (icon != null) {
            return icon;
        }
        
        // Use a default icon
        String propName = ICON_PROPERTY_PREFIX + key + '.' + type + '.' +
                          (direction == TextDirection.RTL ? "rtl" : "ltr"); 
            Image img = (Image)Toolkit.getDefaultToolkit().
                                       getDesktopProperty(propName);
                    if (img != null) {
                        icon = new ImageIcon(img);
                        return icon;
        } else {
            icon = (Icon)((UIDefaults.LazyValue)LookAndFeel.makeIcon(
                          GTKStyle.class, "resources/" + key + "-" + type +
                          ".png")).createValue(null);
        }
        
        if (icon == null) {
            return null;
        }

        BufferedImage image = null; 
        Dimension iconSize = GTKStockIconInfo.getIconSize(type); 

        if (iconSize != null && (icon.getIconWidth() != iconSize.width || 
                icon.getIconHeight() != iconSize.height)) { 
            image = new BufferedImage(iconSize.width, iconSize.height, 
                    BufferedImage.TYPE_INT_ARGB); 

            Graphics2D g2d = (Graphics2D)image.getGraphics(); 

            // for nicer scaling 
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR); 

            Image oldImage = getImageFromIcon(icon, false); 
            g2d.drawImage(oldImage, 0, 0, iconSize.width, iconSize.height, null); 
            g2d.dispose(); 
        }

        if (image != null) {
            icon = new ImageIcon(image);
        }
        return icon;
    }

    private Image getImageFromIcon(Icon icon, boolean requireBufferedImage) {
        Image img = null;
        
        if (icon instanceof ImageIcon) { 
            img = ((ImageIcon)icon).getImage();
            if (requireBufferedImage && !(img instanceof BufferedImage)) {
                img = null;
            }
        }
        if (img == null) { 
            img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
                                    BufferedImage.TYPE_INT_ARGB);                             
            Graphics g = img.getGraphics(); 
            icon.paintIcon(null, g, 0, 0); 
            g.dispose(); 
        } 
        return img;
    }

    Icon getStyleSpecificIcon(String key, TextDirection direction, int type) {
        return null;
    }

    static class GTKStockIconInfo {
        private static Map<String,Integer> ICON_TYPE_MAP;
        private static final Object ICON_SIZE_KEY = new Object(); // IconSize

        private static Dimension[] getIconSizesMap() {
            AppContext appContext = AppContext.getAppContext(); 
            Dimension[] iconSizes = (Dimension[])appContext.get(ICON_SIZE_KEY); 

            if (iconSizes == null) { 
                iconSizes = new Dimension[7];
                iconSizes[0] = null;                  // GTK_ICON_SIZE_INVALID
                iconSizes[1] = new Dimension(16, 16); // GTK_ICON_SIZE_MENU
                iconSizes[2] = new Dimension(18, 18); // GTK_ICON_SIZE_SMALL_TOOLBAR
                iconSizes[3] = new Dimension(24, 24); // GTK_ICON_SIZE_LARGE_TOOLBAR
                iconSizes[4] = new Dimension(20, 20); // GTK_ICON_SIZE_BUTTON
                iconSizes[5] = new Dimension(32, 32); // GTK_ICON_SIZE_DND
                iconSizes[6] = new Dimension(48, 48); // GTK_ICON_SIZE_DIALOG
                appContext.put(ICON_SIZE_KEY, iconSizes);
            }
            return iconSizes;
        }

        /** 
         * Return the size of a particular icon type (logical size)
         * 
         * @param type icon type (GtkIconSize value)
         * @return a Dimension object, or null if lsize is invalid
         */
        public static Dimension getIconSize(int type) {
            Dimension[] iconSizes = getIconSizesMap();
            return type >= 0 && type < iconSizes.length ?
                iconSizes[type] : null;  
        }

        /**
         * Change icon size in a type to size mapping. This is called by code
         * that parses the gtk-icon-sizes setting
         *  
         * @param type icon type (GtkIconSize value)
         * @param w the new icon width
         * @param h the new icon height
         */ 
        public static void setIconSize(int type, int w, int h) {
            Dimension[] iconSizes = getIconSizesMap();
            if (type >= 0 && type < iconSizes.length) {
                iconSizes[type] = new Dimension(w, h);
            }
        }

        /**
         * Return icon type (GtkIconSize value) given a symbolic name which can
         * occur in a theme file.
         * 
         * @param size symbolic name, e.g. gtk-button
         * @return icon type. Valid types are 1 to 6 
         */ 
        public static int getIconType(String size) {
            if (size == null) {
                return UNDEFINED;
            }
            if (ICON_TYPE_MAP == null) {
                initIconTypeMap();
            }
            Integer n = ICON_TYPE_MAP.get(size);
            return n != null ? n.intValue() : UNDEFINED;
        }

        private static void initIconTypeMap() {
            ICON_TYPE_MAP = new HashMap<String,Integer>();
            ICON_TYPE_MAP.put("gtk-menu", new Integer(1));
            ICON_TYPE_MAP.put("gtk-small-toolbar", new Integer(2));
            ICON_TYPE_MAP.put("gtk-large-toolbar", new Integer(3));
            ICON_TYPE_MAP.put("gtk-button", new Integer(4));
            ICON_TYPE_MAP.put("gtk-dnd", new Integer(5));
            ICON_TYPE_MAP.put("gtk-dialog", new Integer(6));
        }
        
    }
    
    /**
     * An Icon that is fetched using getStockIcon.
     */
    private static class GTKStockIcon extends SynthIcon {
        private String key;
        private int size;
        private boolean loadedLTR;
        private boolean loadedRTL;
        private Icon ltrIcon;
        private Icon rtlIcon;
        private SynthStyle style;

        GTKStockIcon(String key, int size) {
            this.key = key;
            this.size = size;
        }
        
        public void paintIcon(SynthContext context, Graphics g, int x,
                              int y, int w, int h) {
            Icon icon = getIcon(context);

            if (icon != null) {
                if (context == null) {
                    icon.paintIcon(null, g, x, y);
                }
                else {
                    icon.paintIcon(context.getComponent(), g, x, y);
                }
            }
        }

        public int getIconWidth(SynthContext context) {
            Icon icon = getIcon(context);

            if (icon != null) {
                return icon.getIconWidth();
            }
            return 0;
        }

        public int getIconHeight(SynthContext context) {
            Icon icon = getIcon(context);

            if (icon != null) {
                return icon.getIconHeight();
            }
            return 0;
        }

        private Icon getIcon(SynthContext context) {
            if (context != null) {
                ComponentOrientation co = context.getComponent().
                                                  getComponentOrientation();
                SynthStyle style = context.getStyle();

                if (style != this.style) {
                    this.style = style;
                    loadedLTR = loadedRTL = false;
                }
                if (co == null || co.isLeftToRight()) {
                    if (!loadedLTR) {
                        loadedLTR = true;
                        ltrIcon = ((GTKStyle)context.getStyle()).
                                  getStockIcon(context, key, size);
                    }
                    return ltrIcon;
                }
                else if (!loadedRTL) {
                    loadedRTL = true;
                    rtlIcon = ((GTKStyle)context.getStyle()).
                              getStockIcon(context, key,size);
                }
                return rtlIcon;
            }
            return ltrIcon;
        }
    }

    /**
     * GTKLazyValue is a slimmed down version of <code>ProxyLaxyValue</code>.
     * The code is duplicate so that it can get at the package private
     * classes in gtk.
     */
    static class GTKLazyValue implements UIDefaults.LazyValue {
        /**
         * Name of the class to create.
         */
        private String className;
        private String methodName;

        GTKLazyValue(String name) {
            this(name, null);
        }

        GTKLazyValue(String name, String methodName) {
            this.className = name;
            this.methodName = methodName;
        }

        public Object createValue(UIDefaults table) {
            try {
                Class c = Class.forName(className, true,Thread.currentThread().
                                        getContextClassLoader());

                if (methodName == null) {
                    return c.newInstance();
                }
                Method m = c.getMethod(methodName, (Class[])null);

                return m.invoke(c, (Object[])null);
            } catch (ClassNotFoundException cnfe) {
            } catch (IllegalAccessException iae) {
            } catch (InvocationTargetException ite) {
            } catch (NoSuchMethodException nsme) {
            } catch (InstantiationException ie) {
            }
            return null;
        }
    }

    static {
        CLASS_SPECIFIC_MAP = new HashMap<String,String>();
        CLASS_SPECIFIC_MAP.put("Slider.thumbHeight", "slider-width");
        CLASS_SPECIFIC_MAP.put("Slider.trackBorder", "trough-border");
        CLASS_SPECIFIC_MAP.put("SplitPane.size", "handle-size");
        CLASS_SPECIFIC_MAP.put("Tree.expanderSize", "expander-size");
        CLASS_SPECIFIC_MAP.put("ScrollBar.thumbHeight", "slider-width");
        CLASS_SPECIFIC_MAP.put("ScrollBar.width", "slider-width");
        CLASS_SPECIFIC_MAP.put("TextArea.caretForeground", "cursor-color");
        CLASS_SPECIFIC_MAP.put("TextArea.caretAspectRatio", "cursor-aspect-ratio");
        CLASS_SPECIFIC_MAP.put("TextField.caretForeground", "cursor-color");
        CLASS_SPECIFIC_MAP.put("TextField.caretAspectRatio", "cursor-aspect-ratio");
        CLASS_SPECIFIC_MAP.put("PasswordField.caretForeground", "cursor-color");
        CLASS_SPECIFIC_MAP.put("PasswordField.caretAspectRatio", "cursor-aspect-ratio");
        CLASS_SPECIFIC_MAP.put("FormattedTextField.caretForeground", "cursor-color");
        CLASS_SPECIFIC_MAP.put("FormattedTextField.caretAspectRatio", "cursor-aspect-");
        CLASS_SPECIFIC_MAP.put("TextPane.caretForeground", "cursor-color");
        CLASS_SPECIFIC_MAP.put("TextPane.caretAspectRatio", "cursor-aspect-ratio");
        CLASS_SPECIFIC_MAP.put("EditorPane.caretForeground", "cursor-color");
        CLASS_SPECIFIC_MAP.put("EditorPane.caretAspectRatio", "cursor-aspect-ratio");
        
        ICONS_MAP = new HashMap<String, GTKStockIcon>();
        ICONS_MAP.put("FileChooser.cancelIcon", new GTKStockIcon("gtk-cancel", 4));
        ICONS_MAP.put("FileChooser.okIcon",     new GTKStockIcon("gtk-ok",     4));
        ICONS_MAP.put("OptionPane.errorIcon", new GTKStockIcon("gtk-dialog-error", 6));
        ICONS_MAP.put("OptionPane.informationIcon", new GTKStockIcon("gtk-dialog-info", 6));
        ICONS_MAP.put("OptionPane.warningIcon", new GTKStockIcon("gtk-dialog-warning", 6));
        ICONS_MAP.put("OptionPane.questionIcon", new GTKStockIcon("gtk-dialog-question", 6));
        ICONS_MAP.put("OptionPane.yesIcon", new GTKStockIcon("gtk-yes", 4));
        ICONS_MAP.put("OptionPane.noIcon", new GTKStockIcon("gtk-no", 4));
        ICONS_MAP.put("OptionPane.cancelIcon", new GTKStockIcon("gtk-cancel", 4));
        ICONS_MAP.put("OptionPane.okIcon", new GTKStockIcon("gtk-ok", 4));
    }
}
