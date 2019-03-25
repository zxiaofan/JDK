/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_UNSET;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_UNSET;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NodeInfo {

    String shortName() default "";

    /**
     * The template used to build the {@link Verbosity#Name} version. Variable part are specified
     * using &#123;i#inputName&#125; or &#123;p#propertyName&#125;.
     */
    String nameTemplate() default "";

    InputType[] allowedUsageTypes() default {};

    /**
     * An estimation of the number of CPU cycles needed to execute this node that can be used to
     * compare its execution cost against other nodes.
     *
     * Implementations of graph cost models based on this value might throw an exception if a node's
     * {@link NodeCycles} value is {@link NodeCycles#CYCLES_UNSET}. As such, it is recommended to
     * specify a value for nodes likely to be inputs to a graph cost model.
     */
    NodeCycles cycles() default CYCLES_UNSET;

    /**
     * A rationale for the chosen {@link NodeInfo#cycles()} value.
     */
    String cyclesRationale() default "";

    /**
     * An estimation of the code size needed to represent this node in machine code that can be used
     * to compare its size cost against other nodes.
     *
     * Implementations of graph cost models based on this value might throw an exception if a node's
     * {@link NodeSize} value is {@link NodeSize#SIZE_UNSET}. As such, it is recommended to specify
     * a value for nodes likely to be inputs to a graph cost model.
     */
    NodeSize size() default SIZE_UNSET;

    /**
     * A rationale for the chosen {@link NodeInfo#size()} value.
     */
    String sizeRationale() default "";
}
