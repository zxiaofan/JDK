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

package sun.font.lookup;

import sun.font.SunFontManager;

/**
 * Implementation-class accessed by other JDK modules to
 * locate the JDK-provided fonts.
 */
public final class JDKFontLookup {

    public static final String getJDKFontDir() {
        return SunFontManager.getJDKFontDir();
    }
}
