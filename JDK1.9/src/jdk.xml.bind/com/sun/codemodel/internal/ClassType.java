/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.codemodel.internal;
/**
 * This helps enable whether the JDefinedClass is a Class or Interface or
 * AnnotationTypeDeclaration or Enum
 *
 * @author
 *     Bhakti Mehta (bhakti.mehta@sun.com)
 */
public final class ClassType {

    /**
     * The keyword used to declare this type.
     */
    final String declarationToken;

    private ClassType(String token) {
        this.declarationToken = token;
    }

    public static final ClassType CLASS = new ClassType("class");
    public static final ClassType INTERFACE = new ClassType("interface");
    public static final ClassType ANNOTATION_TYPE_DECL = new ClassType("@interface");
    public static final ClassType ENUM = new ClassType("enum");
}
