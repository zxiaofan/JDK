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
 * This is an exception that is thrown whenever the modification of an object
 * (such as an Access Control List) is only allowed to be done by an owner of
 * the object, but the Principal attempting the modification is not an owner.
 *
 * @author      Satish Dharmaraj
 * @since 1.1
 *
 * @deprecated This class is deprecated and subject to removal in a future
 *     version of Java SE. It has been replaced by {@code java.security.Policy}
 *     and related classes since 1.2.
 */
@Deprecated(since="9", forRemoval=true)
public class NotOwnerException extends Exception {

    private static final long serialVersionUID = -5555597911163362399L;

    /**
     * Constructs a NotOwnerException.
     */
    public NotOwnerException() {
    }
}
