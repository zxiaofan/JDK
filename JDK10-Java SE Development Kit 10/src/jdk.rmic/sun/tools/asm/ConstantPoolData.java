/*
 * Copyright (c) 1994, 2003, Oracle and/or its affiliates. All rights reserved.
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
import java.io.IOException;
import java.io.DataOutputStream;

/**
 * Base constant data class. Every constant pool data item
 * is derived from this class.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */

abstract class  ConstantPoolData implements RuntimeConstants {
    int index;

    /**
     * Write the constant to the output stream
     */
    abstract void write(Environment env, DataOutputStream out, ConstantPool tab) throws IOException;

    /**
     * Return the order of the constant
     */
    int order() {
        return 0;
    }

    /**
     * Return the number of entries that it takes up in the constant pool
     */
    int width() {
        return 1;
    }
}
