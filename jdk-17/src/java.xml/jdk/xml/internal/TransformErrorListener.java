/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.xml.internal;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

/**
 * Implements an ErrorListener for use by the JDK as the default ErrorListener.
 * For compatibility, this implementation retains the behavior as was implemented
 * by TransformerFactoryImpl and TransformerImpl where both the error and
 * fatalError methods re-throw the exception.
 */
public class TransformErrorListener implements ErrorListener {
    /**
     * Receives notification of a warning.
     *
     * @param e The warning information encapsulated in a TransformerException.
     * @throws TransformerException not thrown in this implementation
     */
    @Override
    public void warning(TransformerException e)
        throws TransformerException
    {
        // no op
    }

    /**
     * Receives notification of an error.
     * The transformer may continue the process if the error is recoverable.
     * It may decide not to if it can not continue after the error.
     *
     * @param e The error information encapsulated in a TransformerException.
     * @throws TransformerException re-throws the exception.
     */
    @Override
    public void error(TransformerException e)
        throws TransformerException
    {
        throw e;
    }

    /**
     * Receives notification of a fatal error.
     *
     * @param e The error information encapsulated in a TransformerException.
     * @throws TransformerException re-throws the exception.
     */
    @Override
    public void fatalError(TransformerException e)
        throws TransformerException
    {
        throw e;
    }
}
