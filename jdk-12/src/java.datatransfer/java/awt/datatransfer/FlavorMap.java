/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.datatransfer;

import java.util.Map;

/**
 * A two-way Map between "natives" (Strings), which correspond to
 * platform-specific data formats, and "flavors" (DataFlavors), which correspond
 * to platform-independent MIME types. FlavorMaps need not be symmetric, but
 * typically are.
 *
 * @since 1.2
 */
public interface FlavorMap {

    /**
     * Returns a {@code Map} of the specified {@code DataFlavor}s to their
     * corresponding {@code String} native. The returned {@code Map} is a
     * modifiable copy of this {@code FlavorMap}'s internal data. Client code is
     * free to modify the {@code Map} without affecting this object.
     *
     * @param  flavors an array of {@code DataFlavor}s which will be the key set
     *         of the returned {@code Map}. If {@code null} is specified, a
     *         mapping of all {@code DataFlavor}s currently known to this
     *         {@code FlavorMap} to their corresponding {@code String} natives
     *         will be returned.
     * @return a {@code java.util.Map} of {@code DataFlavor}s to {@code String}
     *         natives
     */
    Map<DataFlavor, String> getNativesForFlavors(DataFlavor[] flavors);

    /**
     * Returns a {@code Map} of the specified {@code String} natives to their
     * corresponding {@code DataFlavor}. The returned {@code Map} is a
     * modifiable copy of this {@code FlavorMap}'s internal data. Client code is
     * free to modify the {@code Map} without affecting this object.
     *
     * @param  natives an array of {@code String}s which will be the key set of
     *         the returned {@code Map}. If {@code null} is specified, a mapping
     *         of all {@code String} natives currently known to this
     *         {@code FlavorMap} to their corresponding {@code DataFlavor}s will
     *         be returned.
     * @return a {@code java.util.Map} of {@code String} natives to
     *         {@code DataFlavor}s
     */
    Map<String, DataFlavor> getFlavorsForNatives(String[] natives);
}
