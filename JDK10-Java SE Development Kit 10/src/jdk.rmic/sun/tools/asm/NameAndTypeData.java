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

/**
 * An object to represent a name and type constant pool data item.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
final
class NameAndTypeData {
    MemberDefinition field;

    /**
     * Constructor
     */
    NameAndTypeData(MemberDefinition field) {
        this.field = field;
    }

    /**
     * Hashcode
     */
    public int hashCode() {
        return field.getName().hashCode() * field.getType().hashCode();
    }

    /**
     * Equality
     */
    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof NameAndTypeData)) {
            NameAndTypeData nt = (NameAndTypeData)obj;
            return field.getName().equals(nt.field.getName()) &&
                field.getType().equals(nt.field.getType());
        }
        return false;
    }

    /**
     * Convert to string
     */
    public String toString() {
        return "%%" + field.toString() + "%%";
    }
}
