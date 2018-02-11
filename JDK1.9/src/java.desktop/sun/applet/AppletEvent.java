/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.util.EventObject;


/**
 * AppletEvent class.
 *
 * @author  Sunita Mani
 *
 * @deprecated The Applet API is deprecated. See the
 * <a href="../../java/applet/package-summary.html"> java.applet package
 * documentation</a> for further information.
 */
@SuppressWarnings("serial") // JDK-implementation class
@Deprecated(since = "9")
public class AppletEvent extends EventObject {

    private Object arg;
    private int id;


    public AppletEvent(Object source, int id, Object argument) {
        super(source);
        this.arg = argument;
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public Object getArgument() {
        return arg;
    }

    public String toString() {
        String str = getClass().getName() + "[source=" + source + " + id="+ id;
        if (arg != null) {
            str += " + arg=" + arg;
        }
        str += " ]";
        return str;
    }
}
