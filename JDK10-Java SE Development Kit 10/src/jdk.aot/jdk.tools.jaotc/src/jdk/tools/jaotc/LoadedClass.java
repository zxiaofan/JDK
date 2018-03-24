/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc;

public class LoadedClass {
    private final String name;
    private final Class<?> clz;

    public LoadedClass(String name, Class<?> clz) {
        this.name = name;
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public Class<?> getLoadedClass() {
        return clz;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LoadedClass)) {
            return false;
        }
        LoadedClass that = (LoadedClass) o;

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return clz != null ? clz.equals(that.clz) : that.clz == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (clz != null ? clz.hashCode() : 0);
        return result;
    }
}
