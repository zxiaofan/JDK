/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package jdk.tools.jaotc.collect;

public final class SearchFor {
    private final String name;
    private final String type;

    public SearchFor(String name) {
        this(name, "");
    }

    public SearchFor(String name, String type) {
        this.name = name;
        this.type = type;
    }

    boolean isUnknown() {
        return "".equals(type);
    }

    String getType() {
        return this.type;
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return type + ": " + name;
    }
}
