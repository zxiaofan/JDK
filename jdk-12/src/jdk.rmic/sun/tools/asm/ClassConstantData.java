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
 * This is a class constant pool item.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
final
class ClassConstantData extends ConstantPoolData {
    String name;

    /**
     * Constructor
     */

    ClassConstantData(ConstantPool tab, ClassDeclaration clazz) {
        String sig = clazz.getType().getTypeSignature();
        // sig is like "Lfoo/bar;", name is like "foo/bar".
        // We assume SIG_CLASS and SIG_ENDCLASS are 1 char each.
        name = sig.substring(1, sig.length()-1);
        tab.put(name);
    }

    // REMIND: this case should eventually go away.
    ClassConstantData(ConstantPool tab, Type t) {
        name = t.getTypeSignature();
        tab.put(name);
    }

    /**
     * Write the constant to the output stream
     */
    void write(Environment env, DataOutputStream out, ConstantPool tab) throws IOException {
        out.writeByte(CONSTANT_CLASS);
        out.writeShort(tab.index(name));
    }

    /**
     * Return the order of the constant
     */
    int order() {
        return 1;
    }

    public String toString() {
        return "ClassConstantData[" + name + "]";
    }
}
