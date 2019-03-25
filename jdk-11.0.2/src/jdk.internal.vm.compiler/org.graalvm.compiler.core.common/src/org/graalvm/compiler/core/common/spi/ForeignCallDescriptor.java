/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.spi;

import java.util.Arrays;

/**
 * The name and signature of a foreign call. A foreign call differs from a normal compiled Java call
 * in at least one of these aspects:
 * <ul>
 * <li>The call is to C/C++/assembler code.</li>
 * <li>The call uses different conventions for passing parameters or returning values.</li>
 * <li>The callee has different register saving semantics. For example, the callee may save all
 * registers (apart from some specified temporaries) in which case the register allocator doesn't
 * not need to spill all live registers around the call site.</li>
 * <li>The call does not occur at an INVOKE* bytecode. Such a call could be transformed into a
 * standard Java call if the foreign routine is a normal Java method and the runtime supports
 * linking Java calls at arbitrary bytecodes.</li>
 * </ul>
 */
public class ForeignCallDescriptor {

    private final String name;
    private final Class<?> resultType;
    private final Class<?>[] argumentTypes;

    public ForeignCallDescriptor(String name, Class<?> resultType, Class<?>... argumentTypes) {
        this.name = name;
        this.resultType = resultType;
        this.argumentTypes = argumentTypes;
    }

    /**
     * Gets the name of this foreign call.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the return type of this foreign call.
     */
    public Class<?> getResultType() {
        return resultType;
    }

    /**
     * Gets the argument types of this foreign call.
     */
    public Class<?>[] getArgumentTypes() {
        return argumentTypes.clone();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ForeignCallDescriptor) {
            ForeignCallDescriptor other = (ForeignCallDescriptor) obj;
            return other.name.equals(name) && other.resultType.equals(resultType) && Arrays.equals(other.argumentTypes, argumentTypes);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append('(');
        String sep = "";
        for (Class<?> arg : argumentTypes) {
            sb.append(sep).append(arg.getSimpleName());
            sep = ",";
        }
        return sb.append(')').append(resultType.getSimpleName()).toString();
    }
}
