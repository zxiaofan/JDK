/*
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.asm;

import sun.tools.java.*;
import java.util.Vector;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public final
class TryData {
    Vector<CatchData> catches = new Vector<>();
    Label endLabel = new Label();

    /**
     * Add a label
     */
    public CatchData add(Object type) {
        CatchData cd = new CatchData(type);
        catches.addElement(cd);
        return cd;
    }

    /**
     * Get a label
     */
    public CatchData getCatch(int n) {
        return catches.elementAt(n);
    }

    /**
     * Get the default label
     */
    public Label getEndLabel() {
        return endLabel;
    }
}
