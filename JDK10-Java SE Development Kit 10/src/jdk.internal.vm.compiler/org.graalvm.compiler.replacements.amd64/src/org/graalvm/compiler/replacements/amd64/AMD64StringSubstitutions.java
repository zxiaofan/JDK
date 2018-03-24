/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.replacements.amd64;

import org.graalvm.compiler.api.replacements.ClassSubstitution;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.graph.Node.ConstantNodeParameter;
import org.graalvm.compiler.word.Word;
import org.graalvm.word.Pointer;

import sun.misc.Unsafe;

// JaCoCo Exclude

/**
 * Substitutions for {@link java.lang.String} methods.
 */
@ClassSubstitution(String.class)
public class AMD64StringSubstitutions {

    // Only exists in JDK <= 8
    @MethodSubstitution(isStatic = true, optional = true)
    public static int indexOf(char[] source, int sourceOffset, int sourceCount,
                    @ConstantNodeParameter char[] target, int targetOffset, int targetCount,
                    int origFromIndex) {
        int fromIndex = origFromIndex;
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            // The empty string is in every string.
            return fromIndex;
        }

        int totalOffset = sourceOffset + fromIndex;
        if (sourceCount - fromIndex < targetCount) {
            // The empty string contains nothing except the empty string.
            return -1;
        }
        assert sourceCount - fromIndex > 0 && targetCount > 0;

        Pointer sourcePointer = Word.objectToTrackedPointer(source).add(Unsafe.ARRAY_CHAR_BASE_OFFSET).add(totalOffset * Unsafe.ARRAY_CHAR_INDEX_SCALE);
        Pointer targetPointer = Word.objectToTrackedPointer(target).add(Unsafe.ARRAY_CHAR_BASE_OFFSET).add(targetOffset * Unsafe.ARRAY_CHAR_INDEX_SCALE);
        int result = AMD64StringIndexOfNode.optimizedStringIndexPointer(sourcePointer, sourceCount - fromIndex, targetPointer, targetCount);
        if (result >= 0) {
            return result + totalOffset;
        }
        return result;
    }
}
