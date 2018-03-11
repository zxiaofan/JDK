/*
 * GTKDefaultStyle.java
 *
 * @(#)GTKDefaultStyle.java	1.1 05/08/05
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.java.swing.plaf.gtk;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.synth.*;

/**
 *
 * @version 1.1, 08/05/05
 * @author Kirill Kirichenko
 */
class GTKDefaultStyle extends GTKStyle {
    
    private static final int DEFAULT_XTHICKNESS = 2;
    private static final int DEFAULT_YTHICKNESS = 2;
    
    private static final Color[][] DEFAULT_COLORS;
    /**
     * State the color array at an particular index in DEFAULT_COLORS
     * represents.
     */
    private static final int[] DEFAULT_COLOR_MAP;
    
    static {
        DEFAULT_COLOR_MAP = new int[] {
            SynthConstants.PRESSED, SynthConstants.SELECTED,
            SynthConstants.ENABLED, SynthConstants.MOUSE_OVER,
            SynthConstants.DISABLED
        };

        DEFAULT_COLORS = new Color[5][];

        // 2.0 colors
        // 
        if (!GTKLookAndFeel.is2_2()) {
            DEFAULT_COLORS[0] = getColorsFrom(
                    new ColorUIResource(195, 195, 195), BLACK_COLOR);
            DEFAULT_COLORS[1] = getColorsFrom(
                    new ColorUIResource(0, 0, 156), WHITE_COLOR);
            DEFAULT_COLORS[2] = getColorsFrom(
                    new ColorUIResource(214, 214, 214), BLACK_COLOR);
            DEFAULT_COLORS[3] = getColorsFrom(
                    new ColorUIResource(233, 233, 233), BLACK_COLOR);
            DEFAULT_COLORS[4] = getColorsFrom(
                    new ColorUIResource(214, 214, 214),
                    new ColorUIResource(117, 117, 117));
            DEFAULT_COLORS[0][GTKColorType.TEXT_BACKGROUND.getID()] = new
                    ColorUIResource(188, 210, 238);
            DEFAULT_COLORS[1][GTKColorType.TEXT_BACKGROUND.getID()] = new
                    ColorUIResource(164, 223, 255);
            DEFAULT_COLORS[1][GTKColorType.TEXT_FOREGROUND.getID()] =
                    BLACK_COLOR;
            DEFAULT_COLORS[2][GTKColorType.TEXT_FOREGROUND.getID()] =
                    BLACK_COLOR;
            DEFAULT_COLORS[4][GTKColorType.TEXT_FOREGROUND.getID()] =
                DEFAULT_COLORS[2][GTKColorType.TEXT_FOREGROUND.getID()];
        }
        else {
            // 2.2 colors
            DEFAULT_COLORS[0] = getColorsFrom(
                    new ColorUIResource(186, 181, 171), BLACK_COLOR);
            DEFAULT_COLORS[1] = getColorsFrom(
                    new ColorUIResource(75, 105, 131), WHITE_COLOR);
            DEFAULT_COLORS[2] = getColorsFrom(
                    new ColorUIResource(220, 218, 213), BLACK_COLOR);
            DEFAULT_COLORS[3] = getColorsFrom(
                    new ColorUIResource(238, 235, 231), BLACK_COLOR);
            DEFAULT_COLORS[4] = getColorsFrom(
                    new ColorUIResource(220, 218, 213),
                    new ColorUIResource(117, 117, 117));
            DEFAULT_COLORS[0][GTKColorType.TEXT_BACKGROUND.getID()] = new
                    ColorUIResource(128, 125, 116);
            DEFAULT_COLORS[1][GTKColorType.TEXT_BACKGROUND.getID()] = new
                    ColorUIResource(75, 105, 131);
            DEFAULT_COLORS[2][GTKColorType.TEXT_BACKGROUND.getID()] =
                    WHITE_COLOR;
            DEFAULT_COLORS[3][GTKColorType.TEXT_BACKGROUND.getID()] =
                    WHITE_COLOR;
            DEFAULT_COLORS[4][GTKColorType.TEXT_BACKGROUND.getID()] = new
                    ColorUIResource(238, 235, 231);
            DEFAULT_COLORS[0][GTKColorType.TEXT_FOREGROUND.getID()] =
                    WHITE_COLOR;
            DEFAULT_COLORS[1][GTKColorType.TEXT_FOREGROUND.getID()] =
                    WHITE_COLOR;
            DEFAULT_COLORS[2][GTKColorType.TEXT_FOREGROUND.getID()] =
                    BLACK_COLOR;
            DEFAULT_COLORS[3][GTKColorType.TEXT_FOREGROUND.getID()] =
                    BLACK_COLOR;
            DEFAULT_COLORS[4][GTKColorType.TEXT_FOREGROUND.getID()] = new
                    ColorUIResource(117, 117, 117);
        }
    }
    
    GTKDefaultStyle(Font font) {
        super(font);
    }
    
    Color getStyleSpecificColor(SynthContext context, int state, ColorType type) {
        Region id = (context != null) ? context.getRegion() : null;
        Color color = null;
        
        if (id == Region.TOOL_TIP) {
            color = getToolTipColor(state, type);
        } else if (id == Region.PROGRESS_BAR && GTKLookAndFeel.is2_2()) {
            color = getProgressBarColor(state, type);
        } else if ((id == Region.MENU || id == Region.MENU_ITEM ||
                    id == Region.POPUP_MENU_SEPARATOR ||
                    id == Region.CHECK_BOX_MENU_ITEM ||
                    id == Region.RADIO_BUTTON_MENU_ITEM ||
                    id == Region.MENU_ITEM_ACCELERATOR) &&
                    GTKLookAndFeel.is2_2()) {
            color = getMenuItemColor(state, type);
        }
        
        if (color != null) {
            return color;
        }
        
        for (int counter = DEFAULT_COLOR_MAP.length - 1;
                     counter >= 0; counter--) {
            if ((DEFAULT_COLOR_MAP[counter] & state) != 0) {
                if (type.getID() < DEFAULT_COLORS[counter].length) {
                    return DEFAULT_COLORS[counter][type.getID()];
                }
            }
        }
        if (type.getID() < DEFAULT_COLORS[2].length) {
            return DEFAULT_COLORS[2][type.getID()];
        }

        return null;
    }

    private Color getToolTipColor(int state, ColorType type) {
        if (state == SynthConstants.ENABLED) {
            if(type == GTKColorType.BACKGROUND) {
                 return(GTKLookAndFeel.is2_2() ?
                        new ColorUIResource(0xEEE1B3) :
                        new ColorUIResource(0xFFFFC0));
            }
    
            if(type == GTKColorType.FOREGROUND) {
                return new ColorUIResource(0x000000);
            }
        }
        return null;
    }

    private Color getProgressBarColor(int state, ColorType type) {
        if (state == SynthConstants.ENABLED) {
            if(type == GTKColorType.BACKGROUND) {
                 return new ColorUIResource(0xBAB5AB);
            }
        } else if (state == SynthConstants.MOUSE_OVER) {
            if(type == GTKColorType.BACKGROUND) {
                 return new ColorUIResource(0x4B6983);
            }
        }
        return null;
    }

    private Color getMenuItemColor(int state, ColorType type) {
        if (state == SynthConstants.SELECTED) {
            if(type == GTKColorType.TEXT_FOREGROUND ||
               type == GTKColorType.FOREGROUND) {
                 return new ColorUIResource(0xFFFFFF);
            }
        } else if (state == SynthConstants.MOUSE_OVER) {
            if(type == GTKColorType.BACKGROUND) {
                 return new ColorUIResource(0x9db8d2);
            }
            if(type == GTKColorType.FOREGROUND) {
                 return GTKStyle.WHITE_COLOR;
            }
            if(type == GTKColorType.TEXT_FOREGROUND) {
                 return new ColorUIResource(0xFFFFFF);
            }
        }

        return null;
    }
    
    /**
     * Returns the X thickness to use for this GTKStyle.
     *
     * @return x thickness.
     */
    int getXThickness() {
        return DEFAULT_XTHICKNESS;
    }

    /**
     * Returns the Y thickness to use for this GTKStyle.
     *
     * @return x thickness.
     */
    int getYThickness() {
        return DEFAULT_YTHICKNESS;
    }
    
    /**
     * Returns the value for a class specific property. A class specific value
     * is a value that will be picked up based on class hierarchy.
     *
     * @param context SynthContext indentifying requestor
     * @param key Key identifying class specific value
     * @return Value, or null if one has not been defined.
     */
    Object getClassSpecificValue(Region region, String key) {
        return null;
    }

    /**
     * Creates an array of colors populated based on the passed in
     * the background color. Specifically this sets the
     * BACKGROUND, LIGHT, DARK, MID, BLACK, WHITE and FOCUS colors
     * from that of color, which is assumed to be the background.
     */
    private static Color[] getColorsFrom(Color bg, Color fg) {
        Color lightColor = calculateLightColor(bg);
        Color darkColor = calculateDarkColor(bg);
        Color midColor = calculateMidColor(lightColor, darkColor);
        Color[] colors = new Color[GTKColorType.MAX_COUNT];
        colors[GTKColorType.BACKGROUND.getID()] = bg;
        colors[GTKColorType.LIGHT.getID()] = lightColor;
        colors[GTKColorType.DARK.getID()] = darkColor;
        colors[GTKColorType.MID.getID()] = midColor;
        colors[GTKColorType.BLACK.getID()] = BLACK_COLOR;
        colors[GTKColorType.WHITE.getID()] = WHITE_COLOR;
        colors[GTKColorType.FOCUS.getID()] = BLACK_COLOR;
        colors[GTKColorType.FOREGROUND.getID()] = fg;
        colors[GTKColorType.TEXT_FOREGROUND.getID()] = fg;
        colors[GTKColorType.TEXT_BACKGROUND.getID()] = WHITE_COLOR;
        return colors;
    }

    /**
     * Calculates the LIGHT color from the background color.
     */
    private static Color calculateLightColor(Color bg) {
        return GTKColorType.adjustColor(bg, 1.0f, 1.3f, 1.3f);
    }

    /**
     * Calculates the DARK color from the background color.
     */
    private static Color calculateDarkColor(Color bg) {
        return GTKColorType.adjustColor(bg, 1.0f, .7f, .7f);
    }

    /**
     * Calculates the MID color from the light and dark colors.
     */
    private static Color calculateMidColor(Color lightColor, Color darkColor) {
        int light = lightColor.getRGB();
        int dark = darkColor.getRGB();
        int rLight = (light & 0xFF0000) >> 16;
        int rDark = (dark & 0xFF0000) >> 16;
        int gLight = (light & 0x00FF00) >> 8;
        int gDark = (dark & 0x00FF00) >> 8;
        int bLight = (light & 0xFF);
        int bDark = (dark & 0xFF);
        return new ColorUIResource((((rLight + rDark) / 2) << 16) |
                                   (((gLight + gDark) / 2) << 8) |
                                   ((bLight + bDark) / 2));
    }
}
