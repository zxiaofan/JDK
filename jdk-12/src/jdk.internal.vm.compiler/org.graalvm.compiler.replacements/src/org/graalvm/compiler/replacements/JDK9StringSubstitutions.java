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
 */


package org.graalvm.compiler.replacements;

import org.graalvm.compiler.api.replacements.ClassSubstitution;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.core.common.SuppressFBWarnings;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.java.LoadFieldNode;
import org.graalvm.compiler.replacements.nodes.ArrayEqualsNode;

// JaCoCo Exclude

/**
 * Substitutions for {@link String} methods for JDK9 and later.
 *
 * {@link String} changed in JDK9 to contain a byte array instead of a char array. We therefore need
 * new substitutions for the related methods.
 */
@ClassSubstitution(String.class)
public class JDK9StringSubstitutions {

    @MethodSubstitution(isStatic = false)
    @SuppressFBWarnings(value = "ES_COMPARING_PARAMETER_STRING_WITH_EQ", justification = "reference equality on the receiver is what we want")
    public static boolean equals(final String thisString, Object obj) {
        if (thisString == obj) {
            return true;
        }
        if (!(obj instanceof String)) {
            return false;
        }
        String thatString = (String) obj;
        if (thisString.length() != thatString.length()) {
            return false;
        }

        if (thisString.length() == 0) {
            return true;
        }
        if (getCoder(thisString) != getCoder(thatString)) {
            return false;
        }

        final byte[] array1 = getValue(thisString);
        final byte[] array2 = getValue(thatString);

        return ArrayEqualsNode.equals(array1, array2, array1.length);
    }

    /**
     * Will be intrinsified with an {@link InvocationPlugin} to a {@link LoadFieldNode}.
     */
    public static native byte[] getValue(String s);

    public static native int getCoder(String s);

    public static boolean isCompactString(String s) {
        return getCoder(s) == 0;
    }
}
