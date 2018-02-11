/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Basic .au and .snd audio handler.
 * @author  Jeff Nisewanger
 */
package sun.awt.www.content.audio;

import java.net.*;
import java.io.IOException;
import sun.applet.AppletAudioClip;

/**
 * Returns an AppletAudioClip object.
 * This provides backwards compatibility with the behavior
 * of ClassLoader.getResource().getContent() on JDK1.1.
 */
public class basic extends ContentHandler {
    public Object getContent(URLConnection uc) throws IOException {
        return new AppletAudioClip(uc);
    }
}
