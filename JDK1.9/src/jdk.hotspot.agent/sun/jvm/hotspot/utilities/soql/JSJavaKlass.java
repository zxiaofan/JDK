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

/**
   This is JavaScript wrapper for Klass.
*/
public abstract class JSJavaKlass {
    private static final int FIELD_SUPER_CLASS    = 0;
    private static final int FIELD_NAME           = 1;
    private static final int FIELD_IS_ARRAY_CLASS = 2;
    private static final int FIELD_UNDEFINED      = -1;

    public JSJavaKlass(Klass klass, JSJavaFactory factory) {
        this.factory = factory;
        this.klass = klass;
    }

    public final Klass getKlass() {
        return klass;
    }

    public JSJavaClass getJSJavaClass() {
        return (JSJavaClass) factory.newJSJavaObject(getKlass().getJavaMirror());
    }

    public Object getMetaClassFieldValue(String name) {
        int fieldID = getFieldID(name);
        switch (fieldID) {
        case FIELD_SUPER_CLASS: {
            JSJavaKlass jk = factory.newJSJavaKlass(getKlass().getSuper());
            return (jk != null) ? jk.getJSJavaClass() : null;
        }
        case FIELD_NAME:
            return getName();
        case FIELD_IS_ARRAY_CLASS:
            return Boolean.valueOf(isArray());
        case FIELD_UNDEFINED:
        default:
            return ScriptObject.UNDEFINED;
        }
    }

    public boolean hasMetaClassField(String name) {
        return getFieldID(name) != FIELD_UNDEFINED;
    }


    public String[] getMetaClassFieldNames() {
        String[] res = { "name", "superClass", "isArrayClass" };
        return res;
    }

    public abstract String getName();
    public abstract boolean isArray();

    //-- Internals only below this point
    private static Map fields = new HashMap();
    private static void addField(String name, int fieldId) {
        fields.put(name, new Integer(fieldId));
    }

    private static int getFieldID(String name) {
        Integer res = (Integer) fields.get(name);
        return (res != null)? res.intValue() : FIELD_UNDEFINED;
    }

    static {
        addField("base", FIELD_SUPER_CLASS);
        addField("baseClass", FIELD_SUPER_CLASS);
        addField("superClass", FIELD_SUPER_CLASS);
        addField("name", FIELD_NAME);
        addField("isArrayClass", FIELD_IS_ARRAY_CLASS);
    }

    protected final JSJavaFactory factory;
    private final Klass klass;
}
