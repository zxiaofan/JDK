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

/**
 * An applet security exception.
 *
 * @author      Arthur van Hoff
 *
 * @deprecated The Applet API is deprecated. See the
 * <a href="../../java/applet/package-summary.html"> java.applet package
 * documentation</a> for further information.
 */
@SuppressWarnings("serial") // JDK implementation class
@Deprecated(since = "9")
public class AppletIllegalArgumentException extends IllegalArgumentException {
    private String key = null;

    public AppletIllegalArgumentException(String key) {
        super(key);
        this.key = key;

    }

    public String getLocalizedMessage() {
        return amh.getMessage(key);
    }

    private static AppletMessageHandler amh = new AppletMessageHandler("appletillegalargumentexception");
}
