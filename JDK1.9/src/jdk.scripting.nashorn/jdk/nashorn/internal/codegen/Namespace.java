/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.codegen;

import static jdk.nashorn.internal.codegen.MethodEmitter.LARGE_STRING_THRESHOLD;

import java.util.HashMap;

/**
 * A name space hierarchy, where each level holds a name directory with
 * names that may be unique for each level.
 */

public class Namespace {
    /** Parent namespace. */
    private final Namespace parent;

    /** Name directory - version count for each name */
    private final HashMap<String, Integer> directory;

    /**
     * Constructor
     */
    public Namespace() {
        this(null);
    }

    /**
     * Constructor
     *
     * @param parent parent name space
     */
    public Namespace(final Namespace parent) {
        this.parent    = parent;
        this.directory = new HashMap<>();
    }

    /**
     * Return the parent Namespace of this space.
     *
     * @return parent name space
     */
    public Namespace getParent() {
        return parent;
    }

    /**
     * Create a uniqueName name in the namespace in the form base-n where n varies.
     * Also truncates very long names that would otherwise break ASM.
     *
     * @param base Base of name.  Base will be returned if uniqueName.
     * @return Generated uniqueName name.
     */
    public String uniqueName(final String base) {
        final String truncatedBase = base.length() > LARGE_STRING_THRESHOLD ? base.substring(0, LARGE_STRING_THRESHOLD) : base;
        for (Namespace namespace = this; namespace != null; namespace = namespace.getParent()) {
            final HashMap<String, Integer> namespaceDirectory = namespace.directory;
            final Integer                  counter            = namespaceDirectory.get(truncatedBase);

            if (counter != null) {
                final int count = counter + 1;
                namespaceDirectory.put(truncatedBase, count);
                return truncatedBase + CompilerConstants.ID_FUNCTION_SEPARATOR.symbolName() + count;
            }
        }

        directory.put(truncatedBase, 0);

        return truncatedBase;
    }

    @Override
    public String toString() {
        return directory.toString();
    }
}
