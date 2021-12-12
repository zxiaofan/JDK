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

package com.sun.tools.javac.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**Methods that directly implement a method declared in a public, supported API should be marked
 * with this annotation.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface DefinedBy {

    /**The API which defines the implemented method.
     */
    Api value();

    public enum Api {
        ANNOTATION_PROCESSING("javax.annotation.processing"),
        COMPILER("javax.tools"),
        COMPILER_TREE("com.sun.source"),
        LANGUAGE_MODEL("javax.lang.model");

        /**The package under which all interfaces/classes of this API belong.
         */
        public final String packageRoot;

        private Api(String packageRoot) {
            this.packageRoot = packageRoot;
        }

    }
}
