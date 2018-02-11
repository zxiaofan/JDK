/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.reflect.generics.tree;

/**
 * Common superinterface for nodes that represent a (possibly generic)
 * type.
 * Corresponds to the production of the same name in the JVMS
 * section on signatures.
 */
public interface FieldTypeSignature
    extends BaseType, TypeSignature, TypeArgument {}
