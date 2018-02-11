/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.vm.annotation;

import java.lang.annotation.*;

/**
 * A method or constructor may be annotated as "don't inline" if the inlining of
 * this method should not be performed by the HotSpot VM.
 * <p>
 * This annotation must be used sparingly.  It is useful when the only
 * reasonable alternative is to bind the name of a specific method or
 * constructor into the HotSpot VM for special handling by the inlining policy.
 * This annotation must not be relied on as an alternative to avoid tuning the
 * VM's inlining policy.  In a few cases, it may act as a temporary workaround
 * until the profiling and inlining performed by the HotSpot VM is sufficiently
 * improved.
 *
 * @implNote
 * This annotation only takes effect for methods or constructors of classes
 * loaded by the boot loader.  Annotations on methods or constructors of classes
 * loaded outside of the boot loader are ignored.
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface DontInline {
}
