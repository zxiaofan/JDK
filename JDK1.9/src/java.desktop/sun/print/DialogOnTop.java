/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import javax.print.attribute.Attribute;
import javax.print.attribute.PrintRequestAttribute;

/*
 * An implementation class used to request the dialog be set always-on-top.
 * It needs to be read and honoured by the dialog code which will use
 * java.awt.Window.setAlwaysOnTop(true) in cases where it is supported.
 */
public class DialogOnTop implements PrintRequestAttribute {

    private static final long serialVersionUID = -1901909867156076547L;

    long id;

    public DialogOnTop() {
    }

    public DialogOnTop(long id) {
        this.id = id;
    }

    public final Class<? extends Attribute> getCategory() {
        return DialogOnTop.class;
    }

    public long getID() {
        return id;
    }

    public final String getName() {
        return "dialog-on-top";
    }

    public String toString() {
       return "dialog-on-top";
    }
}
