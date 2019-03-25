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


package org.graalvm.compiler.hotspot.replacements;

import static org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.INJECTED_VMCONFIG;
import static org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.CLASS_ARRAY_KLASS_LOCATION;
import static org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.arrayKlassOffset;
import static org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.loadKlassFromObject;

import java.lang.reflect.Array;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.api.replacements.ClassSubstitution;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.nodes.java.DynamicNewArrayNode;

// JaCoCo Exclude

/**
 * Substitutions for {@link Array} methods.
 */
@ClassSubstitution(Array.class)
public class HotSpotArraySubstitutions {

    @MethodSubstitution
    public static Object newInstance(Class<?> componentType, int length) {
        if (componentType == null || loadKlassFromObject(componentType, arrayKlassOffset(INJECTED_VMCONFIG), CLASS_ARRAY_KLASS_LOCATION).isNull()) {
            // Exit the intrinsic here for the case where the array class does not exist
            return newInstance(componentType, length);
        }
        return DynamicNewArrayNode.newArray(GraalDirectives.guardingNonNull(componentType), length);
    }

}
