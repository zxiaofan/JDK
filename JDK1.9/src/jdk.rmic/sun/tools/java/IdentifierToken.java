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

package sun.tools.java;

/**
 * Information about the occurrence of an identifier.
 * The parser produces these to represent name which cannot yet be
 * bound to field definitions.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 *
 * @see
 */

public
class IdentifierToken {
    long where;
    int modifiers;
    Identifier id;

    public IdentifierToken(long where, Identifier id) {
        this.where = where;
        this.id = id;
    }

    /** Use this constructor when the identifier is synthesized.
     * The location will be 0.
     */
    public IdentifierToken(Identifier id) {
        this.where = 0;
        this.id = id;
    }

    public IdentifierToken(long where, Identifier id, int modifiers) {
        this.where = where;
        this.id = id;
        this.modifiers = modifiers;
    }

    /** The source location of this identifier occurrence. */
    public long getWhere() {
        return where;
    }

    /** The identifier itself (possibly qualified). */
    public Identifier getName() {
        return id;
    }

    /** The modifiers associated with the occurrence, if any. */
    public int getModifiers() {
        return modifiers;
    }

    public String toString() {
        return id.toString();
    }

    /**
     * Return defaultWhere if id is null or id.where is missing (0).
     * Otherwise, return id.where.
     */
    public static long getWhere(IdentifierToken id, long defaultWhere) {
        return (id != null && id.where != 0) ? id.where : defaultWhere;
    }
}
