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
package sun.awt.www.content;

import sun.awt.www.content.audio.wav;
import sun.awt.www.content.audio.x_aiff;
import sun.awt.www.content.image.gif;
import sun.awt.www.content.audio.aiff;
import sun.awt.www.content.audio.basic;
import sun.awt.www.content.audio.x_wav;
import sun.awt.www.content.image.jpeg;
import sun.awt.www.content.image.png;
import sun.awt.www.content.image.x_xbitmap;
import sun.awt.www.content.image.x_xpixmap;

import java.net.ContentHandler;
import java.net.ContentHandlerFactory;

public final class MultimediaContentHandlers implements ContentHandlerFactory {

    @Override
    public ContentHandler createContentHandler(String mimetype) {
        switch (mimetype) {
            case "audio/aiff":      return new aiff();
            case "audio/basic":     return new basic();
            case "audio/wav":       return new wav();
            case "audio/x-aiff":    return new x_aiff();
            case "audio/x-wav":     return new x_wav();
            case "image/gif":       return new gif();
            case "image/jpeg":      return new jpeg();
            case "image/png":       return new png();
            case "image/x-xbitmap": return new x_xbitmap();
            case "image/x-xpixmap": return new x_xpixmap();
            default:                return null;
        }
    }
}
