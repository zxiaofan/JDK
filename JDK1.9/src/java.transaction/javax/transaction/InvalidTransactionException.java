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
 * This exception indicates that the request carried an invalid transaction
 * context. For example, this exception could be raised if an error
 * occured when trying to register a resource.
 */
@SuppressWarnings("serial")             // serialVersionUID intentionally omitted
public class InvalidTransactionException extends java.rmi.RemoteException {

    /**
     * Specify serialVersionUID for backward compatibility
     */
    private static final long serialVersionUID = 3597320220337691496L;

    /**
     * Constructs an {@code InvalidTransactionException}.
     */
    public InvalidTransactionException() {
        super();
    }

    /**
     * Constructs an {@code InvalidTransactionException}.
     * @param msg the detail message
     */
    public InvalidTransactionException(String msg) {
        super(msg);
    }
}
