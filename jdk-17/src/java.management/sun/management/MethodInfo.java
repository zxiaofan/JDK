/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.management;

import sun.management.counter.*;

/**
 */
public class MethodInfo implements java.io.Serializable {
    private String name;
    private long type;
    private int compileSize;

    MethodInfo(String name, long type, int compileSize) {
        this.name = name;
        this.type = type;
        this.compileSize = compileSize;
    }

    /**
     * Returns the name of the compiled method.
     *
     * @return the name of the compiled method.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the compiled method such as normal-compile,
     * osr-compile, and native-compile.
     *
     * @return the type of the compiled method.
     */
    public long getType() {
        return type;
    }

    /**
     * Returns the number of bytes occupied by this compiled method.
     * This method returns -1 if not available.
     *
     * @return the number of bytes occupied by this compiled method.
     */
    public int getCompileSize() {
        return compileSize;
    }

    public String toString() {
        return getName() + " type = " + getType() +
            " compileSize = " + getCompileSize();
    }

    private static final long serialVersionUID = 6992337162326171013L;

}
