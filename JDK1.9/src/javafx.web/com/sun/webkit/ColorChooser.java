/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit;

import com.sun.javafx.scene.control.CustomColorDialog;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class ColorChooser {
    /**
     * Color conversion from double (0.0 to 1.0) to uchar (0 to 255)
     */
    private static final double COLOR_DOUBLE_TO_UCHAR_FACTOR = 255.0;

    /**
     * Color chooser dialog
     */
    private final CustomColorDialog colorChooserDialog;

    /**
     * Handle / pointer to native object
     */
    private final long pdata;

    private ColorChooser(WebPage webPage, Color color, long data) {
        this.pdata = data;

        WebPageClient<WebView> client = webPage.getPageClient();
        assert (client != null);
        colorChooserDialog = new CustomColorDialog(client.getContainer().getScene().getWindow());
        colorChooserDialog.setSaveBtnToOk();
        colorChooserDialog.setShowUseBtn(false);
        colorChooserDialog.setShowOpacitySlider(false);

        colorChooserDialog.setOnSave(() -> {
            twkSetSelectedColor(pdata,
                    (int) Math.round(colorChooserDialog.getCustomColor().getRed() * COLOR_DOUBLE_TO_UCHAR_FACTOR),
                    (int) Math.round(colorChooserDialog.getCustomColor().getGreen() * COLOR_DOUBLE_TO_UCHAR_FACTOR),
                    (int) Math.round(colorChooserDialog.getCustomColor().getBlue() * COLOR_DOUBLE_TO_UCHAR_FACTOR));
        });

        colorChooserDialog.setCurrentColor(color);
        colorChooserDialog.show();
    }

    private static ColorChooser fwkCreateAndShowColorChooser(WebPage webPage, int r, int g, int b, long pdata) {
        return new ColorChooser(webPage, Color.rgb(r,g,b), pdata);
    }

    private void fwkShowColorChooser(int r, int g, int b) {
        colorChooserDialog.setCurrentColor(Color.rgb(r,g,b));
        colorChooserDialog.show();
    }

    private void fwkHideColorChooser() {
        colorChooserDialog.hide();
    }

    private native void twkSetSelectedColor(long data, int r, int g, int b);
}
