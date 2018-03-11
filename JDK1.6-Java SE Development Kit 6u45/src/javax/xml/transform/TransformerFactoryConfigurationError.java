/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://jaxp.dev.java.net/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://jaxp.dev.java.net/CDDLv1.0.html
 * If applicable add the following below this CDDL HEADER
 * with the fields enclosed by brackets "[]" replaced with
 * your own identifying information: Portions Copyright
 * [year] [name of copyright owner]
 */

/*
 * $Id: XMLEntityReader.java,v 1.3 2005/11/03 17:02:21 jeffsuttor Exp $
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 */

package javax.xml.transform;

/**
 * Thrown when a problem with configuration with the Transformer Factories
 * exists. This error will typically be thrown when the class of a
 * transformation factory specified in the system properties cannot be found
 * or instantiated.
 */
public class TransformerFactoryConfigurationError extends Error {

    /**
     * <code>Exception</code> for the
     *  <code>TransformerFactoryConfigurationError</code>.
     */
    private Exception exception;

    /**
     * Create a new <code>TransformerFactoryConfigurationError</code> with no
     * detail mesage.
     */
    public TransformerFactoryConfigurationError() {

        super();

        this.exception = null;
    }

    /**
     * Create a new <code>TransformerFactoryConfigurationError</code> with
     * the <code>String</code> specified as an error message.
     *
     * @param msg The error message for the exception.
     */
    public TransformerFactoryConfigurationError(String msg) {

        super(msg);

        this.exception = null;
    }

    /**
     * Create a new <code>TransformerFactoryConfigurationError</code> with a
     * given <code>Exception</code> base cause of the error.
     *
     * @param e The exception to be encapsulated in a
     * TransformerFactoryConfigurationError.
     */
    public TransformerFactoryConfigurationError(Exception e) {

        super(e.toString());

        this.exception = e;
    }

    /**
     * Create a new <code>TransformerFactoryConfigurationError</code> with the
     * given <code>Exception</code> base cause and detail message.
     *
     * @param e The exception to be encapsulated in a
     * TransformerFactoryConfigurationError
     * @param msg The detail message.
     */
    public TransformerFactoryConfigurationError(Exception e, String msg) {

        super(msg);

        this.exception = e;
    }

    /**
     * Return the message (if any) for this error . If there is no
     * message for the exception and there is an encapsulated
     * exception then the message of that exception will be returned.
     *
     * @return The error message.
     */
    public String getMessage() {

        String message = super.getMessage();

        if ((message == null) && (exception != null)) {
            return exception.getMessage();
        }

        return message;
    }

    /**
     * Return the actual exception (if any) that caused this exception to
     * be raised.
     *
     * @return The encapsulated exception, or null if there is none.
     */
    public Exception getException() {
        return exception;
    }
}
