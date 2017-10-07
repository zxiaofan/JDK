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

import sun.jvm.hotspot.oops.ObjArray;

/**
   This is JavaScript wrapper for Java Object Array.
*/

public class JSJavaObjArray extends JSJavaArray {
    public JSJavaObjArray(ObjArray array, JSJavaFactory fac) {
        super(array, fac);
    }

    public final ObjArray getObjArray() {
        return (ObjArray) getArray();
    }
}
