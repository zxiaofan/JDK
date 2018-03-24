/*
 * Copyright (c) 1996, 2017, Oracle and/or its affiliates. All rights reserved.
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

package java.security.acl;


/**
 * This interface represents a permission, such as that used to grant
 * a particular type of access to a resource.
 *
 * @author Satish Dharmaraj
 * @since 1.1
 *
 * @deprecated This class is deprecated and subject to removal in a future
 *     version of Java SE. It has been replaced by {@code java.security.Policy}
 *     and related classes since 1.2.
 */
@Deprecated(since="9", forRemoval=true)
public interface Permission {

    /**
     * Returns true if the object passed matches the permission represented
     * in this interface.
     *
     * @param another the Permission object to compare with.
     *
     * @return true if the Permission objects are equal, false otherwise
     */
    public boolean equals(Object another);

    /**
     * Prints a string representation of this permission.
     *
     * @return the string representation of the permission.
     */
    public String toString();

}
