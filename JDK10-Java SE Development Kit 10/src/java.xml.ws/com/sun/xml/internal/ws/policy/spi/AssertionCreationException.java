/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.policy.spi;

import com.sun.xml.internal.ws.policy.PolicyException;
import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;

/**
 * Exception thrown in case of assertion creation failure.
 *
 * @author Marek Potociar
 */
public final class AssertionCreationException extends PolicyException {

    private final AssertionData assertionData;

    /**
     * Constructs a new assertion creation exception with the specified detail message and cause.
     * <p/>
     * Note that the detail message associated with {@code cause} is <emph>not</emph> automatically incorporated in
     * this exception's detail message.
     *
     * @param assertionData the data provided for assertion creation
     * @param  message the detail message.
     */
    public AssertionCreationException(final AssertionData assertionData, final String message) {
        super(message);
        this.assertionData = assertionData;
    }

    /**
     * Constructs a new assertion creation exception with the specified detail message and cause.
     * <p/>
     * Note that the detail message associated with {@code cause} is <emph>not</emph> automatically incorporated in
     * this exception's detail message.
     *
     * @param assertionData the data provided for assertion creation
     * @param  message the detail message.
     * @param  cause the cause.  (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public AssertionCreationException(final AssertionData assertionData, final String message, final Throwable cause) {
        super(message, cause);
        this.assertionData = assertionData;
    }

    /**
     * Constructs a new assertion creation exception with the specified detail message and cause.
     *
     * @param assertionData the data provided for assertion creation
     * @param  cause the cause.  (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public AssertionCreationException(AssertionData assertionData, Throwable cause) {
        super(cause);
        this.assertionData = assertionData;
    }

    /**
     * Retrieves assertion data associated with the exception.
     *
     * @return associated assertion data (present when assertion creation failed raising this exception).
     */
    public AssertionData getAssertionData() {
        return this.assertionData;
    }
}
