/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jar;

import java.io.IOException;

public
class JarException extends IOException {

    static final long serialVersionUID = -4351820108009811497L;

    public JarException() {
        super();
    }

    public JarException(String s) {
        super(s);
    }
}
