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

import sun.jvm.hotspot.oops.TypeArray;

/**
   This is JavaScript wrapper for Java Primitive Array.
*/

public class JSJavaTypeArray extends JSJavaArray {
    public JSJavaTypeArray(TypeArray array, JSJavaFactory fac) {
        super(array, fac);
    }

    public final TypeArray getTypeArray() {
        return (TypeArray) getArray();
    }
}
