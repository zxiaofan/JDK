/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;

/**
 * To represent property setting in an object literal tree.
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface PropertyTree extends Tree {
    /**
     * Returns the name of this property.
     *
     * @return the name of the property
     */
    public ExpressionTree getKey();

    /**
     * Returns the value of this property. This is null for accessor properties.
     *
     * @return the value of the property
     */
    public ExpressionTree getValue();

    /**
     * Returns the setter function of this property if this
     * is an accessor property. This is null for data properties.
     *
     * @return the setter function of the property
     */
    public FunctionExpressionTree getGetter();

    /**
     * Returns the getter function of this property if this
     * is an accessor property. This is null for data properties.
     *
     * @return the getter function of the property
     */
    public FunctionExpressionTree getSetter();

    /**
     * Is this a class static property?
     *
     * @return true if this is a static property
     */
    public boolean isStatic();

    /**
     * Is this a computed property?
     *
     * @return true if this is a computed property
     */
    public boolean isComputed();
}
