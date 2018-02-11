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

package sun.tools.java;

/**
 * This class represents an Java class type.
 * It overrides the relevant methods in class Type.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 *
 * @author      Arthur van Hoff
 */
public final
class ClassType extends Type {
    /**
     * The fully qualified class name.
     */
    Identifier className;

    /**
     * Construct a class type. Use Type.tClass to create
     * a new class type.
     */
    ClassType(String typeSig, Identifier className) {
        super(TC_CLASS, typeSig);
        this.className = className;
    }

    public Identifier getClassName() {
        return className;
    }

    public String typeString(String id, boolean abbrev, boolean ret) {
        String s = (abbrev ? getClassName().getFlatName() :
                                Identifier.lookup(getClassName().getQualifier(),
                                                                  getClassName().getFlatName())).toString();
        return (id.length() > 0) ? s + " " + id : s;
    }
}
