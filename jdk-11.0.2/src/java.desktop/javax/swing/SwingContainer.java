/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An annotation used to specify some swing-related information
 * for the automatically generated {@code BeanInfo} classes.
 * This annotation is not used if the annotated class
 * has a corresponding user-defined {@code BeanInfo} class,
 * which does not imply the automatic analysis.
 * <p>
 * The {@code isContainer} {@link java.beans.BeanDescriptor#getValue
 * feature attribute} was introduced primarily for the Swing library.
 * All Swing components extend the {@link java.awt.Container Container}
 * class by design, so the builder tool assumes that all Swing components
 * are containers.  The {@link java.beans.BeanInfo BeanInfo} classes
 * with the {@code isContainer} attribute allow to directly specify
 * whether a Swing component is a container or not.
 *
 * @since 9
 *
 * @author Sergey A. Malenkov
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface SwingContainer {
    /**
     * The value that indicates whether the annotated class can be used
     * as a container for other Swing components or not.
     *
     * @return {@code true} if the annotated class is a Swing container;
     *         {@code false} otherwise.
     */
    boolean value() default true;

    /**
     * The name of the getter method in the annotated class,
     * which returns the corresponding Swing container,
     * if it is not recommended to add subcomponents
     * to the annotated class directly.
     *
     * @return the name of the getter method in the annotated class,
     *         which returns the corresponding Swing container,
     *         or an empty string if the method name is not set.
     */
    String delegate() default "";
}
