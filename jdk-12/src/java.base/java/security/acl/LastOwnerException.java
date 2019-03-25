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
 * This is an exception that is thrown whenever an attempt is made to delete
 * the last owner of an Access Control List.
 *
 * @see java.security.acl.Owner#deleteOwner
 *
 * @author Satish Dharmaraj
 * @since 1.1
 *
 * @deprecated This class is deprecated and subject to removal in a future
 *     version of Java SE. It has been replaced by {@code java.security.Policy}
 *     and related classes since 1.2.
 */
@Deprecated(since="9", forRemoval=true)
public class LastOwnerException extends Exception {

    private static final long serialVersionUID = -5141997548211140359L;

    /**
     * Constructs a LastOwnerException.
     */
    public LastOwnerException() {
    }
}
