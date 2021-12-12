/*
 * Copyright (c) 2000, 2002, Oracle and/or its affiliates. All rights reserved.
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

package javax.transaction.xa;

/**
 * The Xid interface is a Java mapping of the X/Open transaction identifier
 * XID structure. This interface specifies three accessor methods to
 * retrieve a global transaction format ID, global transaction ID,
 * and branch qualifier. The Xid interface is used by the transaction
 * manager and the resource managers. This interface is not visible to
 * the application programs.
 *
 * @since 1.4
 */
public interface Xid {

    /**
     * Maximum number of bytes returned by {@link #getGlobalTransactionId }.
     */
    static final int MAXGTRIDSIZE = 64;

    /**
     * Maximum number of bytes returned by {@link #getBranchQualifier }.
     */
    static final int MAXBQUALSIZE = 64;

    /**
     * Obtain the format identifier part of the XID.
     *
     * @return Format identifier. O means the OSI CCR format.
     */
    int getFormatId();

    /**
     * Obtain the global transaction identifier part of XID as an array
     * of bytes.
     *
     * @return Global transaction identifier.
     */
    byte[] getGlobalTransactionId();

    /**
     * Obtain the transaction branch identifier part of XID as an array
     * of bytes.
     *
     * @return Global transaction identifier.
     */
    byte[] getBranchQualifier();
}
