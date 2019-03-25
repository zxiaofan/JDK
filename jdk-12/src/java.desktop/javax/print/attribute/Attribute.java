/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.print.attribute;

import java.io.Serializable;

/**
 * Interface {@code Attribute} is the base interface implemented by any and
 * every printing attribute class to indicate that the class represents a
 * printing attribute. All printing attributes are serializable.
 *
 * @author David Mendenhall
 * @author Alan Kaminsky
 */
public interface Attribute extends Serializable {

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value when it is added to an attribute set.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public Class<? extends Attribute> getCategory();

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * <i>Note:</i> This method is intended to provide a default, nonlocalized
     * string for the attribute's category. If two attribute objects return the
     * same category from the {@code getCategory()} method, they should return
     * the same name from the {@code getName()} method.
     *
     * @return attribute category name
     */
    public String getName();
}
