/*
 * Copyright (c) 2004, 2007, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.utilities.soql;

import java.util.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.utilities.*;

public class JSJavaClass extends JSJavaInstance {
    public JSJavaClass(Instance instance, JSJavaKlass jk,  JSJavaFactory fac) {
        super(instance, fac);
        this.jklass = jk;
    }

    public JSJavaKlass getJSJavaKlass() {
        return jklass;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("Class (address=");
        buf.append(getOop().getHandle());
        buf.append(", name=");
        buf.append(jklass.getName());
        buf.append(')');
        return buf.toString();
    }

    protected Object getFieldValue(String name) {
        return jklass.getMetaClassFieldValue(name);
    }

    protected String[] getFieldNames() {
        return jklass.getMetaClassFieldNames();
    }

    protected boolean hasField(String name) {
        return jklass.hasMetaClassField(name);
    }

    private JSJavaKlass jklass;
}
