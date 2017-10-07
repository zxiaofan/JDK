/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package javax.jws.soap;

/**
 * @since 1.6
 * @deprecated
 */
@Deprecated public @interface SOAPMessageHandler {
    String name() default "";
    String className();
    InitParam[] initParams() default {};
    String[] roles() default {};
    String[] headers() default {};
}
