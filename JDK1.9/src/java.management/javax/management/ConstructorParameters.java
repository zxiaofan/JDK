/*
 * Copyright (c) 2006, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.management;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * <p>
 * An annotation on a constructor that shows how the parameters of
 * that constructor correspond to the constructed object's getter
 * methods.  For example:
 * </p>
 * <blockquote>
 *     <pre>
 *         public class MemoryUsage {
 *             // standard JavaBean conventions with getters
 *             <b>@ConstructorParameters({"init", "used", "committed", "max"})</b>
 *             public MemoryUsage(long init, long used,
 *                                long committed, long max) {...}
 *             public long getInit() {...}
 *             public long getUsed() {...}
 *             public long getCommitted() {...}
 *             public long getMax() {...}
 *         }
 *     </pre>
 * </blockquote>
 * <p>
 * The annotation shows that the first parameter of the constructor
 * can be retrieved with the {@code getInit()} method, the second one with
 * the {@code getUsed()} method, and so on. Since parameter names are not in
 * general available at runtime, without the annotation there would be
 * no way of knowing which parameter corresponds to which property.
 * </p>
 * <p>
 * If a constructor is annotated by the both {@code @java.beans.ConstructorProperties}
 * and {@code @javax.management.ConstructorParameters} annotations
 * the JMX introspection will give an absolute precedence to the latter one.
 * </p>
 *
 * @since 9
 */
@Documented @Target(CONSTRUCTOR) @Retention(RUNTIME)
public @interface ConstructorParameters {
    /**
     * <p>The getter names.</p>
     *
     * @return the getter names corresponding to the parameters in the
     * annotated constructor.
    */
    String[] value();
}
