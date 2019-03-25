/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.invoke;

import java.lang.invoke.MethodHandle;

/**
 * Private API used inside of java.lang.invoke.MethodHandles.
 * Interface implemented by every object which is produced by
 * {@link java.lang.invoke.MethodHandleProxies#asInterfaceInstance MethodHandleProxies.asInterfaceInstance}.
 * The methods of this interface allow a caller to recover the parameters
 * to {@code asInstance}.
 * This allows applications to repeatedly convert between method handles
 * and SAM objects, without the risk of creating unbounded delegation chains.
 */
public interface WrapperInstance {
    /** Produce or recover a target method handle which is behaviorally
     *  equivalent to the SAM method of this object.
     */
    public MethodHandle getWrapperInstanceTarget();
    /** Recover the SAM type for which this object was created.
     */
    public Class<?> getWrapperInstanceType();
}

