/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

import sun.font.FcFontConfiguration;
import sun.font.FontConfigManager;
import sun.font.SunFontManager;

/**
 * A {@link sun.font.FontManager} that uses fontconfig to find system fonts.
 */
public class FcFontManager extends SunFontManager {

    private FontConfigManager fcManager = null;

    public synchronized FontConfigManager getFontConfigManager() {

        if (fcManager == null) {
            fcManager = new FontConfigManager();
        }

        return fcManager;
    }

    @Override
    protected FontConfiguration createFontConfiguration() {
        FcFontConfiguration fcFontConfig = new FcFontConfiguration(this);
        if (fcFontConfig.init()) {
            return fcFontConfig;
        } else {
            throw new InternalError("failed to initialize fontconfig");
        }
    }

    @Override
    public FontConfiguration createFontConfiguration(boolean preferLocaleFonts,
                                                     boolean preferPropFonts) {
        FcFontConfiguration fcFontConfig =
            new FcFontConfiguration(this, preferLocaleFonts, preferPropFonts);
        if (fcFontConfig.init()) {
            return fcFontConfig;
        } else {
            throw new InternalError("failed to initialize fontconfig");
        }
    }

    @Override
    protected String[] getDefaultPlatformFont() {
        final String[] info = new String[2];
        getFontConfigManager().initFontConfigFonts(false);
        FontConfigManager.FcCompFont[] fontConfigFonts =
            getFontConfigManager().getFontConfigFonts();
        if (fontConfigFonts != null) {
            for (int i=0; i<fontConfigFonts.length; i++) {
                if ("sans".equals(fontConfigFonts[i].fcFamily) &&
                    0 == fontConfigFonts[i].style) {
                    info[0] = fontConfigFonts[i].firstFont.familyName;
                    info[1] = fontConfigFonts[i].firstFont.fontFile;
                    break;
                }
            }
        }
        /* Absolute last ditch attempt in the face of fontconfig problems.
         * If we didn't match, pick the first, or just make something
         * up so we don't NPE.
         */
        if (info[0] == null) {
            if (fontConfigFonts != null && fontConfigFonts.length > 0 &&
                fontConfigFonts[0].firstFont.fontFile != null) {
                info[0] = fontConfigFonts[0].firstFont.familyName;
                info[1] = fontConfigFonts[0].firstFont.fontFile;
            } else {
                info[0] = "Dialog";
                info[1] = "/dialog.ttf";
            }
        }
        return info;
    }

    native String getFontPathNative(boolean noType1Fonts, boolean isX11GE);

    protected synchronized String getFontPath(boolean noType1Fonts) {
        return getFontPathNative(noType1Fonts, false);
    }

}
