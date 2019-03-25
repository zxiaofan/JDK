/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodeinfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker type for describing node inputs in snippets that are not of type {@link InputType#Value}.
 */
public abstract class StructuralInput {

    private StructuralInput() {
        throw new Error("Illegal instance of StructuralInput. This class should be used in snippets only.");
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    public @interface MarkerType {
        InputType value();
    }

    /**
     * Marker type for {@link InputType#Memory} edges in snippets.
     */
    @MarkerType(InputType.Memory)
    public abstract static class Memory extends StructuralInput {
    }

    /**
     * Marker type for {@link InputType#Condition} edges in snippets.
     */
    @MarkerType(InputType.Condition)
    public abstract static class Condition extends StructuralInput {
    }

    /**
     * Marker type for {@link InputType#State} edges in snippets.
     */
    @MarkerType(InputType.State)
    public abstract static class State extends StructuralInput {
    }

    /**
     * Marker type for {@link InputType#Guard} edges in snippets.
     */
    @MarkerType(InputType.Guard)
    public abstract static class Guard extends StructuralInput {
    }

    /**
     * Marker type for {@link InputType#Anchor} edges in snippets.
     */
    @MarkerType(InputType.Anchor)
    public abstract static class Anchor extends StructuralInput {
    }

    /**
     * Marker type for {@link InputType#Association} edges in snippets.
     */
    @MarkerType(InputType.Association)
    public abstract static class Association extends StructuralInput {
    }

    /**
     * Marker type for {@link InputType#Extension} edges in snippets.
     */
    @MarkerType(InputType.Extension)
    public abstract static class Extension extends StructuralInput {
    }
}
