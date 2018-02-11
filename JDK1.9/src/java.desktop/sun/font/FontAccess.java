/*
 * Copyright (c) 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.font;

import java.awt.Font;
import java.awt.peer.FontPeer;

public abstract class FontAccess {

    private static FontAccess access;
    public static synchronized void setFontAccess(FontAccess acc) {
        if (access != null) {
            throw new InternalError("Attempt to set FontAccessor twice");
        }
        access = acc;
    }

    public static synchronized FontAccess getFontAccess() {
        return access;
    }

    public abstract Font2D getFont2D(Font f);
    public abstract void setFont2D(Font f, Font2DHandle h);
    public abstract void setCreatedFont(Font f);
    public abstract boolean isCreatedFont(Font f);
    public abstract FontPeer getFontPeer(Font f);
}
