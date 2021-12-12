/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit;

/**
 * Common behavior for writing members of a type.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public interface MemberWriter {

    /**
     * Returns a list to be used for the members of a given kind.
     *
     * @return a list to be used for the members of a given kind
     * @see #getMemberListItem(Content)
     */
    Content getMemberList();

    /**
     * Returns an item for the list of elements of a given kind.
     *
     * @param content the content tree of the member to be documented
     * @return an item for the list of elements of a given kind
     * @see #getMemberList()
     */
    Content getMemberListItem(Content content);
}
