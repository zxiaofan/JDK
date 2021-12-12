/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
package java.lang.constant;

import java.lang.invoke.MethodHandles;

import sun.invoke.util.Wrapper;

import static java.util.Objects.requireNonNull;

/**
 * A <a href="package-summary.html#nominal">nominal descriptor</a> for the class
 * constant corresponding to a primitive type (e.g., {@code int.class}).
 */
final class PrimitiveClassDescImpl
        extends DynamicConstantDesc<Class<?>> implements ClassDesc {

    private final String descriptor;

    /**
     * Creates a {@linkplain ClassDesc} given a descriptor string for a primitive
     * type.
     *
     * @param descriptor the descriptor string, which must be a one-character
     * string corresponding to one of the nine base types
     * @throws IllegalArgumentException if the descriptor string does not
     * describe a valid primitive type
     * @jvms 4.3 Descriptors
     */
    PrimitiveClassDescImpl(String descriptor) {
        super(ConstantDescs.BSM_PRIMITIVE_CLASS, requireNonNull(descriptor), ConstantDescs.CD_Class);
        if (descriptor.length() != 1
            || "VIJCSBFDZ".indexOf(descriptor.charAt(0)) < 0)
            throw new IllegalArgumentException(String.format("not a valid primitive type descriptor: %s", descriptor));
        this.descriptor = descriptor;
    }

    @Override
    public String descriptorString() {
        return descriptor;
    }

    @Override
    public Class<?> resolveConstantDesc(MethodHandles.Lookup lookup) {
        return Wrapper.forBasicType(descriptorString().charAt(0)).primitiveType();
    }

    @Override
    public String toString() {
        return String.format("PrimitiveClassDesc[%s]", displayName());
    }
}
