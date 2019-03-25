/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.type;

import jdk.vm.ci.meta.Assumptions;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * This class represents a reference to a Java type and whether this reference is referring only to
 * the represented type or also to its sub types in the class hierarchy. When creating a type
 * reference, the following options have to be considered:
 *
 * <ul>
 * <li>The reference should always only refer to the given concrete type. Use
 * {@link #createExactTrusted(ResolvedJavaType)} for this purpose.</li>
 * <li>The reference should be created without assumptions about the class hierarchy. The returned
 * reference is exact only when the type is a leaf type (i.e., it cannot have subclasses). Depending
 * on whether interface types can be trusted for this type reference use
 * {@link #createWithoutAssumptions} or {@link #createTrustedWithoutAssumptions}.</li>
 * <li>The reference should be created using assumptions about the class hierarchy. The returned
 * reference is also exact, when there is only a single concrete sub type for the given type.
 * Depending on whether interface types can be trusted for this type reference use {@link #create}
 * or {@link #createTrusted}.</li>
 * </ul>
 *
 * For the methods with untrusted interface types, a {@code null} reference will be constructed for
 * untrusted interface types. Examples for interface types that cannot be trusted are types for
 * parameters, fields, and return values. They are not checked by the Java verifier.
 *
 */
public final class TypeReference {
    private final ResolvedJavaType type;
    private final boolean exactReference;

    private TypeReference(ResolvedJavaType type, boolean exactReference) {
        this.type = type;
        this.exactReference = exactReference;
    }

    /**
     * Creates an exact type reference using the given type.
     */
    public static TypeReference createExactTrusted(ResolvedJavaType type) {
        if (type == null) {
            return null;
        }
        return new TypeReference(type, true);
    }

    /**
     * Creates a type reference using the given type without assumptions and without trusting
     * interface types.
     */
    public static TypeReference createWithoutAssumptions(ResolvedJavaType type) {
        return create(null, type);
    }

    /**
     * Creates a type reference using the given type without assumptions and trusting interface
     * types.
     */
    public static TypeReference createTrustedWithoutAssumptions(ResolvedJavaType type) {
        return createTrusted(null, type);
    }

    /**
     * Creates a type reference using the given type with assumptions and without trusting interface
     * types.
     */
    public static TypeReference create(Assumptions assumptions, ResolvedJavaType type) {
        return createTrusted(assumptions, filterInterfaceTypesOut(type));
    }

    /**
     * Create a type reference using the given type with assumptions and trusting interface types.
     */
    public static TypeReference createTrusted(Assumptions assumptions, ResolvedJavaType type) {
        if (type == null) {
            return null;
        }
        ResolvedJavaType exactType = type.isLeaf() ? type : null;
        if (exactType == null) {
            Assumptions.AssumptionResult<ResolvedJavaType> leafConcreteSubtype = type.findLeafConcreteSubtype();
            if (leafConcreteSubtype != null && leafConcreteSubtype.canRecordTo(assumptions)) {
                leafConcreteSubtype.recordTo(assumptions);
                exactType = leafConcreteSubtype.getResult();
            }
        }
        if (exactType == null) {
            return new TypeReference(type, false);
        }
        return new TypeReference(exactType, true);
    }

    /**
     * The type this reference refers to.
     */
    public ResolvedJavaType getType() {
        return type;
    }

    /**
     * @return {@code true} if this reference is exact and only refers to the given type and
     *         {@code false} if it also refers to its sub types.
     */
    public boolean isExact() {
        return exactReference;
    }

    /**
     * @return A new reference that is guaranteed to be exact.
     */
    public TypeReference asExactReference() {
        if (isExact()) {
            return this;
        }
        return new TypeReference(type, true);
    }

    private static ResolvedJavaType filterInterfaceTypesOut(ResolvedJavaType type) {
        if (type != null) {
            if (type.isArray()) {
                ResolvedJavaType componentType = filterInterfaceTypesOut(type.getComponentType());
                if (componentType != null) {
                    return componentType.getArrayClass();
                }
                // Returns Object[].class
                return type.getSuperclass().getArrayClass();
            }
            if (type.isInterface()) {
                return null;
            }
        }
        return type;
    }

    @Override
    public String toString() {
        return (isExact() ? "#" : "") + type;
    }
}
