/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.reflect;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * A method annotated @CallerSensitive is sensitive to its calling class,
 * via {@link jdk.internal.reflect.Reflection#getCallerClass Reflection.getCallerClass},
 * or via some equivalent.
 *
 * @author John R. Rose
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD})
public @interface CallerSensitive {
}
