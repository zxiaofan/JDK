/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes;

import java.util.EnumMap;

import jdk.internal.vm.compiler.collections.EconomicSet;
import jdk.internal.vm.compiler.collections.Equivalence;
import jdk.internal.vm.compiler.word.LocationIdentity;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.JavaKind.FormatWithToString;

/**
 * A {@link LocationIdentity} with a name.
 */
public class NamedLocationIdentity extends LocationIdentity implements FormatWithToString {

    /**
     * Map for asserting all {@link NamedLocationIdentity} instances have a unique name.
     */
    static class DB {
        private static final EconomicSet<String> map = EconomicSet.create(Equivalence.DEFAULT);

        static boolean checkUnique(String name) {
            if (!map.add(name)) {
                throw new AssertionError("identity " + name + " already exists");
            }
            return true;
        }
    }

    /**
     * Denotes the location of a value that is guaranteed to be unchanging.
     */
    public static final LocationIdentity FINAL_LOCATION = NamedLocationIdentity.immutable("FINAL_LOCATION");

    /**
     * Denotes the location of the length field of a Java array.
     */
    public static final LocationIdentity ARRAY_LENGTH_LOCATION = NamedLocationIdentity.immutable("[].length");

    /**
     * Denotes an off-heap address.
     */
    public static final LocationIdentity OFF_HEAP_LOCATION = NamedLocationIdentity.mutable("OFF_HEAP_LOCATION");

    private final String name;
    private final boolean immutable;

    protected NamedLocationIdentity(String name, boolean immutable) {
        this.name = name;
        this.immutable = immutable;
        assert DB.checkUnique(name);
    }

    /**
     * Creates a named unique location identity for read and write operations against mutable
     * memory.
     *
     * @param name the name of the new location identity
     */
    public static NamedLocationIdentity mutable(String name) {
        return create(name, false);
    }

    /**
     * Creates a named unique location identity for read operations against immutable memory.
     * Immutable memory will never have a visible write in the graph, which is more restrictive than
     * Java final.
     *
     * @param name the name of the new location identity
     */
    public static NamedLocationIdentity immutable(String name) {
        return create(name, true);
    }

    /**
     * Creates a named unique location identity for read and write operations.
     *
     * @param name the name of the new location identity
     * @param immutable true if the location is immutable
     */
    private static NamedLocationIdentity create(String name, boolean immutable) {
        return new NamedLocationIdentity(name, immutable);
    }

    @Override
    public boolean isImmutable() {
        return immutable;
    }

    @Override
    public String toString() {
        return name + (isImmutable() ? ":final" : "");
    }

    /**
     * Returns the named location identity for an array of the given element kind. Array accesses of
     * the same kind must have the same location identity unless an alias analysis guarantees that
     * two distinct arrays are accessed.
     */
    public static LocationIdentity getArrayLocation(JavaKind elementKind) {
        return ARRAY_LOCATIONS.get(elementKind);
    }

    private static final EnumMap<JavaKind, LocationIdentity> ARRAY_LOCATIONS = initArrayLocations();

    private static EnumMap<JavaKind, LocationIdentity> initArrayLocations() {
        EnumMap<JavaKind, LocationIdentity> result = new EnumMap<>(JavaKind.class);
        for (JavaKind kind : JavaKind.values()) {
            result.put(kind, NamedLocationIdentity.mutable("Array: " + kind.getJavaName()));
        }
        return result;
    }
}
