/*
 * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
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

/* ********************************************************************
 **********************************************************************
 **********************************************************************
 *** COPYRIGHT (c) Eastman Kodak Company, 1997                      ***
 *** As  an unpublished  work pursuant to Title 17 of the United    ***
 *** States Code.  All rights reserved.                             ***
 **********************************************************************
 **********************************************************************
 **********************************************************************/

package java.awt.color;

import java.io.Serial;

/**
 * This exception is thrown if the native CMM returns an error.
 */
public class CMMException extends RuntimeException {

    /**
     * Use serialVersionUID from JDK 1.2 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 5775558044142994965L;

    /**
     * Constructs a {@code CMMException} with the specified detail message.
     *
     * @param  s the specified detail message
     */
    public CMMException(String s) {
        super(s);
    }
}
