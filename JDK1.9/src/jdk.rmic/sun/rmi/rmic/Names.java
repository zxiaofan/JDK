/*
 * Copyright (c) 1996, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.rmi.rmic;

import sun.tools.java.Identifier;

/**
 * Names provides static utility methods used by other rmic classes
 * for dealing with identifiers.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public class Names {

    /**
     * Return stub class name for impl class name.
     */
    static final public Identifier stubFor(Identifier name) {
        return Identifier.lookup(name + "_Stub");
    }

    /**
     * Return skeleton class name for impl class name.
     */
    static final public Identifier skeletonFor(Identifier name) {
        return Identifier.lookup(name + "_Skel");
    }

    /**
     * If necessary, convert a class name to its mangled form, i.e. the
     * non-inner class name used in the binary representation of
     * inner classes.  This is necessary to be able to name inner
     * classes in the generated source code in places where the language
     * does not permit it, such as when synthetically defining an inner
     * class outside of its outer class, and for generating file names
     * corresponding to inner classes.
     *
     * Currently this mangling involves modifying the internal names of
     * inner classes by converting occurrences of ". " into "$".
     *
     * This code is taken from the "mangleInnerType" method of
     * the "sun.tools.java.Type" class; this method cannot be accessed
     * itself because it is package protected.
     */
    static final public Identifier mangleClass(Identifier className) {
        if (!className.isInner())
            return className;

        /*
         * Get '.' qualified inner class name (with outer class
         * qualification and no package qualification) and replace
         * each '.' with '$'.
         */
        Identifier mangled = Identifier.lookup(
                                               className.getFlatName().toString()
                                               .replace('.', sun.tools.java.Constants.SIGC_INNERCLASS));
        if (mangled.isInner())
            throw new Error("failed to mangle inner class name");

        // prepend package qualifier back for returned identifier
        return Identifier.lookup(className.getQualifier(), mangled);
    }
}
