/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An annotation used to specify some property-related information for the
 * automatically generated {@link BeanInfo} classes. This annotation is not used
 * if the annotated class has a corresponding user-defined {@code BeanInfo}
 * class, which does not imply the automatic analysis. If both the read and the
 * write methods of the property are annotated, then the read method annotation
 * will have more priority and replace the write method annotation.
 *
 * @author Sergey A. Malenkov
 * @see BeanInfo#getPropertyDescriptors
 * @since 9
 */
@Documented
@Target({METHOD})
@Retention(RUNTIME)
public @interface BeanProperty {
    /**
     * The value that indicates whether the annotated property can be
     * a {@link PropertyDescriptor#isBound bound} property or not.
     * This value applies only to the beans that have the
     * {@link PropertyChangeListener propertyChange} event set.
     *
     * @return {@code true} if the annotated property can be a bound property;
     *         {@code false} otherwise.
     */
    boolean bound() default true;

    /**
     * The value that indicates whether the annotated property is
     * an {@link PropertyDescriptor#isExpert expert} property or not.
     *
     * @return {@code true} if the annotated property is an expert property;
     *         {@code false} otherwise.
     */
    boolean expert() default false;

    /**
     * The value that indicates whether the annotated property is
     * a {@link PropertyDescriptor#isHidden hidden} property or not.
     *
     * @return {@code true} if the annotated property is a hidden property;
     *         {@code false} otherwise.
     */
    boolean hidden() default false;

    /**
     * The value that indicates whether the annotated property is
     * a {@link PropertyDescriptor#isPreferred preferred} property or not.
     *
     * @return {@code true} if the annotated property is a preferred property;
     *         {@code false} otherwise.
     */
    boolean preferred() default false;

    /**
     * The value that indicates whether the annotated property is
     * a required property or not.
     *
     * @return {@code true} if the annotated property is a required property;
     *         {@code false} otherwise.
     */
    boolean required() default false;

    /**
     * The value that indicates whether the corresponding component
     * is repainted after the annotated property got changed or not.
     *
     * @return {@code true} if the corresponding component is repainted;
     *         {@code false} otherwise.
     */
    boolean visualUpdate() default false;

    /**
     * The {@link PropertyDescriptor#getShortDescription short description}
     * for the {@link BeanInfo#getPropertyDescriptors descriptor}
     * of the annotated property.
     *
     * @return the property description,
     *         or an empty string if the description is not set.
     */
    String description() default "";

    /**
     * The array of names for the public static fields
     * that contains the valid values of the annotated property.
     * These names are used to generate the {@code enumerationValues}
     * {@link java.beans.BeanDescriptor#getValue feature attribute}
     * that must contain the following items per each property value:
     * a displayable name for the property value, the actual property value,
     * and a Java code piece used for the code generator.
     *
     * @return the names of the valid values of the annotated property,
     *         or an empty array if the names are not provided.
     */
    String[] enumerationValues() default {};
}
