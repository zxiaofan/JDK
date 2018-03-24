/*
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.applet;

import java.io.IOException;

/**
 * An applet IO exception.
 *
 * @author      Koji Uno
 *
 * @deprecated The Applet API is deprecated. See the
 * <a href="../../java/applet/package-summary.html"> java.applet package
 * documentation</a> for further information.
 */
@SuppressWarnings("serial") // JDK implementation class
@Deprecated(since = "9")
public class AppletIOException extends IOException {
    private String key = null;
    private Object msgobj = null;

    public AppletIOException(String key) {
        super(key);
        this.key = key;

    }
    public AppletIOException(String key, Object arg) {
        this(key);
        msgobj = arg;
    }

    public String getLocalizedMessage() {
        if( msgobj != null)
            return amh.getMessage(key, msgobj);
        else
            return amh.getMessage(key);
    }

    private static AppletMessageHandler amh = new AppletMessageHandler("appletioexception");

}
