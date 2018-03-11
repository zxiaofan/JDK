/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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

package javax.annotation;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * The PostConstruct annotation is used on a method that needs to be executed
 * after dependency injection is done to perform any initialization. This
 * method MUST be invoked before the class is put into service. This
 * annotation MUST be supported on all classes that support dependency
 * injection. The method annotated with PostConstruct MUST be invoked even
 * if the class does not request any resources to be injected. Only one
 * method can be annotated with this annotation. The method on which the
 * PostConstruct annotation is applied MUST fulfill all of the following
 * criteria -
- The method MUST NOT have any parameters except in the case of EJB
 * interceptors   in which case it takes an InvocationC ontext object as
 * defined by the EJB   specification.
 * - The return type of the method MUST be void.
 * - The method MUST NOT throw a checked exception.
 * - The method on which PostConstruct is applied MAY be public, protected,
 * package private or private.
 * - The method MUST NOT be static except for the application client.
 * - The method MAY be final.
 * - If the method throws an unchecked exception the class MUST NOT be put into
 * service except in the case of EJBs where the EJB can handle exceptions and
 * even   recover from them.
 * @since Common Annotations 1.0
 * @see javax.annotation.PreDestroy
 * @see javax.annotation.Resource
 */
@Documented
@Retention (RUNTIME)
@Target(METHOD)
public @interface PostConstruct {
}
