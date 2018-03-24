/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.org.jvnet.fastinfoset;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A canonical representation of a vocabulary.
 * <p>
 * Each vocabulary table is represented as a Set. A vocabulary table entry is
 * represented as an item in the Set.
 * <p>
 * The 1st item contained in a Set is assigned the smallest index value,
 * n say (where n >= 0). The 2nd item is assigned an index value of n + 1. The kth
 * item is assigned an index value of n + (k - 1).
 * <p>
 * A Fast Infoset parser/serializer implementation will tranform the canonical
 * representation of a Vocabulary instance into a more optimal form suitable
 * for the efficient usage according to the API implemented by the parsers and
 * serialziers.
 */
public class Vocabulary {
    /**
     * The restricted alphabet table, containing String objects.
     */
    public final Set restrictedAlphabets = new LinkedHashSet();

    /**
     * The encoding algorithm table, containing String objects.
     */
    public final Set encodingAlgorithms = new LinkedHashSet();

    /**
     * The prefix table, containing String objects.
     */
    public final Set prefixes = new LinkedHashSet();

    /**
     * The namespace name table, containing String objects.
     */
    public final Set namespaceNames = new LinkedHashSet();

    /**
     * The local name table, containing String objects.
     */
    public final Set localNames = new LinkedHashSet();

    /**
     * The "other NCName" table, containing String objects.
     */
    public final Set otherNCNames = new LinkedHashSet();

    /**
     * The "other URI" table, containing String objects.
     */
    public final Set otherURIs = new LinkedHashSet();

    /**
     * The "attribute value" table, containing String objects.
     */
    public final Set attributeValues = new LinkedHashSet();

    /**
     * The "other string" table, containing String objects.
     */
    public final Set otherStrings = new LinkedHashSet();

    /**
     * The "character content chunk" table, containing String objects.
     */
    public final Set characterContentChunks = new LinkedHashSet();

    /**
     * The element table, containing QName objects.
     */
    public final Set elements = new LinkedHashSet();

    /**
     * The attribute table, containing QName objects.
     */
    public final Set attributes = new LinkedHashSet();
}
