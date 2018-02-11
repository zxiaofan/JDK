/*
 * Copyright (c) 1995, 2014, Oracle and/or its affiliates. All rights reserved.
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
 */
@SuppressWarnings("serial") // JDK-implementation class
public
class AppletSecurityException extends SecurityException {
    private String key = null;
    private Object msgobj[] = null;

    public AppletSecurityException(String name) {
        super(name);
        this.key = name;
    }

    public AppletSecurityException(String name, String arg) {
        this(name);
        msgobj = new Object[1];
        msgobj[0] = (Object)arg;
    }

    public AppletSecurityException(String name, String arg1, String arg2) {
        this(name);
        msgobj = new Object[2];
        msgobj[0] = (Object)arg1;
        msgobj[1] = (Object)arg2;
    }

    public String getLocalizedMessage() {
        if( msgobj != null)
            return amh.getMessage(key, msgobj);
        else
            return amh.getMessage(key);
    }

    private static AppletMessageHandler amh = new AppletMessageHandler("appletsecurityexception");

}
