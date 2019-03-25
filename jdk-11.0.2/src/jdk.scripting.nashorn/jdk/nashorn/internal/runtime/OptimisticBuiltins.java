/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime;

import jdk.nashorn.internal.objects.annotations.SpecializedFunction;
import jdk.nashorn.internal.objects.annotations.SpecializedFunction.LinkLogic;

/**
 * This is an interface for classes that need custom linkage logic. This means Native objects
 * that contain optimistic native methods, that need special/extra rules for linking, guards and
 * SwitchPointing, known and internal to the Native object for its linkage
 */
public interface OptimisticBuiltins {

    /**
     * Return an instance of the linking logic we need for a particular LinkLogic
     * subclass, gotten from the compile time annotation of a specialized builtin method
     * No assumptions can be made about the lifetime of the instance. The receiver may
     * keep it as a perpetual final instance field or create new linking logic depending
     * on its current state for each call, depending on if the global state has changed
     * or other factors
     *
     * @param clazz linking logic class
     * @return linking logic instance for this class
     */
    public SpecializedFunction.LinkLogic getLinkLogic(final Class<? extends LinkLogic> clazz);

    /**
     * Does this link logic vary depending on which instance we are working with.
     * Then we have to sort out certain primitives, as they are created as new
     * objects in the wrapFilter by JavaScript semantics. An example of instance only
     * assumptions are switchPoints per instance, as in NativeArray. NativeString is
     * fine, as it's only static.
     *
     * TODO: finer granularity on this, on the function level so certain functions
     * are forbidden only. Currently we don't have enough specialization to bump into this
     *
     * @return true if there are per instance assumptions for the optimism
     */
    public boolean hasPerInstanceAssumptions();

}
