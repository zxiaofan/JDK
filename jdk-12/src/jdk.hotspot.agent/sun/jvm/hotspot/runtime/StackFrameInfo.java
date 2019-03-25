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
 */

package sun.jvm.hotspot.runtime;

import sun.jvm.hotspot.oops.*;

public class StackFrameInfo {
    private Method      method;
    int                 bci;
    Oop                 classHolder;

    public StackFrameInfo(JavaVFrame vf) {
        this.method = vf.getMethod();
        this.bci = vf.getBCI();
    }

    public Method getMethod() {
        return method;
    }

    public int getBCI() {
        return bci;
    }
}
