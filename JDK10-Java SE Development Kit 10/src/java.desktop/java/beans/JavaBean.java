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
package java.beans;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An annotation used to specify some class-related information
 * for the automatically generated {@link BeanInfo} classes.
 * This annotation is not used if the annotated class
 * has a corresponding user-defined {@code BeanInfo} class,
 * which does not imply the automatic analysis.
 *
 * @see BeanInfo#getBeanDescriptor
 * @since 9
 *
 * @author Sergey A. Malenkov
 */
@Documented
@Target({TYPE})
@Retention(RUNTIME)
public @interface JavaBean {
    /**
     * The {@link BeanDescriptor#getShortDescription short description}
     * for the {@link BeanInfo#getBeanDescriptor bean descriptor}
     * of the annotated class.
     *
     * @return the bean description,
     *         or an empty string if the description is not set.
     */
    String description() default "";

    /**
     * The name of the default property is used to calculate its
     * {@link BeanInfo#getDefaultPropertyIndex index} in the
     * {@link BeanInfo#getPropertyDescriptors array} of properties
     * defined in the annotated class. If the name is not set or
     * the annotated class does not define a property
     * with the specified name, the default property index
     * will be calculated automatically by the
     * {@link Introspector} depending on its state.
     *
     * @return the name of the default property,
     *         or an empty string if the name is not set.
     */
    String defaultProperty() default "";

    /**
     * The name of the default event set is used to calculate its
     * {@link BeanInfo#getDefaultEventIndex index} in the
     * {@link BeanInfo#getEventSetDescriptors array} of event sets
     * defined in the annotated class. If the name is not set or
     * the annotated class does not define an event set
     * with the specified name, the default event set index
     * will be calculated automatically by the
     * {@link Introspector} depending on its state.
     *
     * @return the name of the default event set,
     *         or an empty string if the name is not set.
     */
    String defaultEventSet() default "";
}
