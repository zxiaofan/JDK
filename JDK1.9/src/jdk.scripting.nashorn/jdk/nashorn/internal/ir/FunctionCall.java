/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.ir;

import jdk.nashorn.internal.runtime.linker.NashornCallSiteDescriptor;

/**
 * Interface used by AccessNodes, IndexNodes and IdentNodes to signal that when evaluated, their value will be treated
 * as a function and immediately invoked, e.g. {@code foo()}, {@code foo.bar()} or {@code foo[bar]()}. Used to customize
 * the priority of composite dynamic operations when emitting {@code INVOKEDYNAMIC} instructions that implement them,
 * namely prioritize {@code getMethod} over {@code getElem} or {@code getProp}. An access or ident node with isFunction
 * set to true will be emitted as {@link NashornCallSiteDescriptor#GET_METHOD_PROPERTY} while one with it set to false will be emitted
 * as {@link NashornCallSiteDescriptor#GET_PROPERTY}. Similarly, an index node with isFunction set to true will be emitted as
 * {@link NashornCallSiteDescriptor#GET_METHOD_ELEMENT} while the one set to false will be emitted as {@link NashornCallSiteDescriptor#GET_ELEMENT}.
 */
public interface FunctionCall {
    /**
     * Returns true if the value of this expression will be treated as a function and immediately invoked.
     * @return true if the value of this expression will be treated as a function and immediately invoked.
     */
    public boolean isFunction();
}
