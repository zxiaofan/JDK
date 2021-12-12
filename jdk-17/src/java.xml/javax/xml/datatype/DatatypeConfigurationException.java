/*
 * Copyright (c) 2004, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.datatype;

/**
 * <p>Indicates a serious configuration error.</p>
 *
 * @author Jeff Suttor
 * @since 1.5
 */

public class DatatypeConfigurationException extends Exception {
    private static final long serialVersionUID = -1699373159027047238L;

    /**
     * <p>Create a new <code>DatatypeConfigurationException</code> with
     * no specified detail message and cause.</p>
     */

    public DatatypeConfigurationException() {
        super();
    }

    /**
     * <p>Create a new <code>DatatypeConfigurationException</code> with
         * the specified detail message.</p>
     *
         * @param message The detail message.
     */

    public DatatypeConfigurationException(String message) {
        super(message);
    }

        /**
         * <p>Create a new <code>DatatypeConfigurationException</code> with
         * the specified detail message and cause.</p>
         *
         * @param message The detail message.
         * @param cause The cause.  A <code>null</code> value is permitted, and indicates that the cause is nonexistent or unknown.
         */

        public DatatypeConfigurationException(String message, Throwable cause) {
                super(message, cause);
        }

        /**
         * <p>Create a new <code>DatatypeConfigurationException</code> with
         * the specified cause.</p>
         *
         * @param cause The cause.  A <code>null</code> value is permitted, and indicates that the cause is nonexistent or unknown.
         */

        public DatatypeConfigurationException(Throwable cause) {
                super(cause);
        }
}
