/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang.annotation;

/**
 * Indicates the kinds of program element to which an annotation type
 * is applicable.  If a Target meta-annotation is not present on an
 * annotation type declaration, the declared type may be used on any
 * program element.  If such a meta-annotation is present, the compiler
 * will enforce the specified usage restriction.
 *
 * For example, this meta-annotation indicates that the declared type is
 * itself a meta-annotation type.  It can only be used on annotation type
 * declarations:
 * <pre>
 *    &#064;Target(ElementType.ANNOTATION_TYPE)
 *    public &#064;interface MetaAnnotationType {
 *        ... 
 *    }
 * </pre>
 * This meta-annotation indicates that the declared type is intended solely
 * for use as a member type in complex annotation type declarations.  It
 * cannot be used to annotate anything directly:
 * <pre>
 *    &#064;Target({}) 
 *    public &#064;interface MemberType {
 *        ...
 *    }
 * </pre>
 * It is a compile-time error for a single ElementType constant to
 * appear more than once in a Target annotation.  For example, the
 * following meta-annotation is illegal:
 * <pre>
 *    &#064;Target({ElementType.FIELD, ElementType.METHOD, ElementType.FIELD})
 *    public &#064;interface Bogus {
 *        ...
 *    }
 * </pre>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    ElementType[] value();
}
