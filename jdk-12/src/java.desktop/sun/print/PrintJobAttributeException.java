/*
 * Copyright (c) 2000, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javax.print.AttributeException;
import javax.print.PrintException;
import javax.print.attribute.Attribute;

@SuppressWarnings("serial") // JDK-implementation class
class PrintJobAttributeException extends PrintException
    implements AttributeException {

    private Attribute attr;
    private Class<?> category;

    PrintJobAttributeException(String s, Class<?> cat, Attribute attrval) {
        super(s);
        attr = attrval;
        category = cat;
    }

    public Class<?>[] getUnsupportedAttributes() {
        if (category == null) {
            return null;
        } else {
            Class<?>[] cats = { category};
            return cats;
        }
    }

    public Attribute[] getUnsupportedValues() {
        if (attr == null) {
            return null;
        } else {
            Attribute [] attrs = { attr};
            return attrs;
        }
    }
}
