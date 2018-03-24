/*
 * Copyright (c) 1998, 2015, Oracle and/or its affiliates. All rights reserved.
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
/*
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 */

package javax.transaction;

/**
 * This exception indicates that the transaction associated with processing
 * of the request has been rolled back, or marked to roll back. Thus the
 * requested operation either could not be performed or was not performed
 * because further computation on behalf of the transaction would be
 * fruitless
 */
@SuppressWarnings("serial")             // serialVersionUID intentionally omitted
public class TransactionRolledbackException extends java.rmi.RemoteException {

    /**
     * Specify serialVersionUID for backward compatibility
     */
    private static final long serialVersionUID = -3142798139623020577L;

    /**
     * Constructs a {@code TransactionRolledbackException}.
     */
    public TransactionRolledbackException() {
        super();
    }

    /**
     * Constructs a {@code TransactionRolledbackException}.
     * @param msg the detail message
     */
    public TransactionRolledbackException(String msg) {
        super(msg);
    }
}
