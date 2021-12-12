/*
 * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jdk.vm.ci.common.JVMCIError;
import jdk.vm.ci.runtime.JVMCIBackend;

public interface HotSpotJVMCIBackendFactory {

    JVMCIBackend createJVMCIBackend(HotSpotJVMCIRuntime runtime, JVMCIBackend host);

    /**
     * Gets the CPU architecture of this backend.
     */
    String getArchitecture();

    /**
     * Converts a bit mask of CPU features to enum constants.
     *
     * @param <CPUFeatureType> CPU feature enum type
     * @param enumType the class of {@code CPUFeatureType}
     * @param constants VM constants. Each entry whose key starts with {@code "VM_Version::CPU_"}
     *            specifies a CPU feature and its value is a mask for a bit in {@code features}
     * @param features bits specifying CPU features
     * @param renaming maps from VM feature names to enum constant names where the two differ
     * @throws IllegalArgumentException if any VM CPU feature constant cannot be converted to an
     *             enum value
     * @return the set of converted values
     */
    static <CPUFeatureType extends Enum<CPUFeatureType>> EnumSet<CPUFeatureType> convertFeatures(
                    Class<CPUFeatureType> enumType,
                    Map<String, Long> constants,
                    long features,
                    Map<String, String> renaming) {
        EnumSet<CPUFeatureType> outFeatures = EnumSet.noneOf(enumType);
        List<String> missing = new ArrayList<>();
        for (Entry<String, Long> e : constants.entrySet()) {
            long bitMask = e.getValue();
            String key = e.getKey();
            if (key.startsWith("VM_Version::CPU_")) {
                String name = key.substring("VM_Version::CPU_".length());
                try {
                    CPUFeatureType feature = Enum.valueOf(enumType, renaming.getOrDefault(name, name));
                    if ((features & bitMask) != 0) {
                        outFeatures.add(feature);
                    }
                } catch (IllegalArgumentException iae) {
                    missing.add(name);
                }
            }
        }
        if (!missing.isEmpty()) {
            throw new JVMCIError("Missing CPU feature constants: %s", missing);
        }
        return outFeatures;
    }
}
