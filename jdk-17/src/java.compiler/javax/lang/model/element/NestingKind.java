/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.element;

/**
 * The <i>nesting kind</i> of a type element.
 * Type elements come in four varieties:
 * top-level, member, local, and anonymous.
 * <i>Nesting kind</i> is a non-standard term used here to denote this
 * classification.
 *
 * <p>Note that it is possible additional nesting kinds will be added
 * in future versions of the platform.
 *
 * <p><b>Example:</b> The classes below are annotated with their nesting kind.
 * <blockquote><pre>
 *
 * import java.lang.annotation.*;
 * import static java.lang.annotation.RetentionPolicy.*;
 * import javax.lang.model.element.*;
 * import static javax.lang.model.element.NestingKind.*;
 *
 * &#64;Nesting(TOP_LEVEL)
 * public class NestingExamples {
 *     &#64;Nesting(MEMBER)
 *     static class MemberClass1{}
 *
 *     &#64;Nesting(MEMBER)
 *     class MemberClass2{}
 *
 *     public static void main(String... argv) {
 *         &#64;Nesting(LOCAL)
 *         class LocalClass{};
 *
 *         Class&lt;?&gt;[] classes = {
 *             NestingExamples.class,
 *             MemberClass1.class,
 *             MemberClass2.class,
 *             LocalClass.class
 *         };
 *
 *         for(Class&lt;?&gt; clazz : classes) {
 *             System.out.format("%s is %s%n",
 *                               clazz.getName(),
 *                               clazz.getAnnotation(Nesting.class).value());
 *         }
 *     }
 * }
 *
 * &#64;Retention(RUNTIME)
 * &#64;interface Nesting {
 *     NestingKind value();
 * }
 * </pre></blockquote>
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public enum NestingKind {
    /**
     * A top-level class or interface, not contained within another
     * class or interface.
     */
    TOP_LEVEL,

    /**
     * A class or interface that is a named member of another class or
     * interface.
     * @jls 8.5 Member Class and Interface Declarations
     */
    MEMBER,

    /**
     * A named class or interface declared within a construct other
     * than a class or interface.
     * @jls 14.3 Local Class Declarations
     */
    LOCAL,

    /**
     * A class without a name.
     * @jls 15.9.5 Anonymous Class Declarations
     */
    ANONYMOUS;

    /**
     * Does this constant correspond to a nested type element?
     * A <i>nested</i> type element is any that is not top-level.
     * More specifically, an <i>inner</i> type element is any nested type element that
     * is not {@linkplain Modifier#STATIC static}.
     * @return whether or not the constant is nested
     * @jls 14.3 Local Class Declarations
     */
    public boolean isNested() {
        return this != TOP_LEVEL;
    }
}
