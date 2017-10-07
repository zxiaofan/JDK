/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * The type of all primitive float values accessed in
 * the target VM. Calls to {@link Value#type} will return an
 * implementor of this interface.
 *
 * @see FloatValue
 *
 * @author James McIlree
 * @since  1.3
 */
public interface FloatType extends PrimitiveType {
}
