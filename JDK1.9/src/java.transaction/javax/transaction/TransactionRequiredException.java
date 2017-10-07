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
 * This exception indicates that a request carried a null transaction context,
 * but the target object requires an activate transaction.
 */
@SuppressWarnings("serial")             // serialVersionUID intentionally omitted
public class TransactionRequiredException extends java.rmi.RemoteException {

    /**
     * Specify serialVersionUID for backward compatibility
     */
    private static final long serialVersionUID = -1898806419937446439L;

    /**
     * Constructs a {@code TransactionRequiredException}.
     */
    public TransactionRequiredException() {
        super();
    }

    /**
     * Constructs a {@code TransactionRequiredException}.
     * @param msg the detail message
     */
    public TransactionRequiredException(String msg) {
        super(msg);
    }
}
