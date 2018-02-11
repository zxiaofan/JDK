/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javafx.beans;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Annotation that provides information about argument's name.
 *
 * @since JavaFX 8.0
 */
@Retention(RUNTIME)
@Target(PARAMETER)
public @interface NamedArg {
    /**
     * The name of the annotated argument.
     * @return the name of the annotated argument
     */
    public String value();

    /**
     * The default value of the annotated argument.
     * @return the default value of the annotated argument
     */
    public String defaultValue() default "";
}
