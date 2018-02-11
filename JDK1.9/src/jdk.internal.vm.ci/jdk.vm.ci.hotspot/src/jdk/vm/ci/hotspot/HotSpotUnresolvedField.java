/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.hotspot;

import jdk.vm.ci.meta.JavaField;
import jdk.vm.ci.meta.JavaType;

/**
 * A implementation of {@link JavaField} for an unresolved field.
 */
class HotSpotUnresolvedField implements JavaField {

    private final String name;
    private final JavaType holder;
    private final JavaType type;

    HotSpotUnresolvedField(JavaType holder, String name, JavaType type) {
        this.name = name;
        this.type = type;
        this.holder = holder;
    }

    public String getName() {
        return name;
    }

    public JavaType getType() {
        return type;
    }

    public JavaType getDeclaringClass() {
        return holder;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof HotSpotUnresolvedField)) {
            return false;
        }
        HotSpotUnresolvedField that = (HotSpotUnresolvedField) obj;
        return this.holder.equals(that.holder) && this.name.equals(that.name) && this.type.equals(that.type);
    }

    /**
     * Converts this compiler interface field to a string.
     */
    @Override
    public String toString() {
        return format("HotSpotField<%H.%n %t, unresolved>");
    }
}
