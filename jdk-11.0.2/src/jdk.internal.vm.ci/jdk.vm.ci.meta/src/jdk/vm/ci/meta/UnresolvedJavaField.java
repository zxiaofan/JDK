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
package jdk.vm.ci.meta;

/**
 * A implementation of {@link JavaField} for an unresolved field.
 */
public final class UnresolvedJavaField implements JavaField {

    private final String name;
    private final JavaType holder;
    private final JavaType type;

    public UnresolvedJavaField(JavaType holder, String name, JavaType type) {
        this.name = name;
        this.type = type;
        this.holder = holder;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public JavaType getType() {
        return type;
    }

    @Override
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
        if (obj == null || !(obj instanceof UnresolvedJavaField)) {
            return false;
        }
        UnresolvedJavaField that = (UnresolvedJavaField) obj;
        return this.holder.equals(that.holder) && this.name.equals(that.name) && this.type.equals(that.type);
    }

    /**
     * Converts this compiler interface field to a string.
     */
    @Override
    public String toString() {
        return format("UnresolvedJavaField<%H.%n %t>");
    }

    public ResolvedJavaField resolve(ResolvedJavaType accessingClass) {
        ResolvedJavaType resolvedHolder = holder.resolve(accessingClass);
        return resolvedHolder.resolveField(this, accessingClass);
    }
}
