/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.tools.jlink.internal;

/**
* Added strings are stored in the jimage strings table.
*/
public interface StringTable {
    /**
     * Add a string to the jimage strings table.
     * @param str The string to add.
     * @return a String identifier.
     */
    public int addString(String str);

    /**
     * Retrieve a string from the passed id.
     * @param id The string id.
     * @return The string referenced by the passed id.
     */
    public String getString(int id);
}
