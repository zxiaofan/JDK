/*
 * Copyright (c) 2003, 2005, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.xpath;

/**
 * {@code XPathFactoryConfigurationException} represents
 * a configuration error in a {@code XPathFactory} environment.
 *
 * @author  Norman Walsh
 * @author  Jeff Suttor
 * @since 1.5
 */
public class XPathFactoryConfigurationException extends XPathException {

    /**
     * Stream Unique Identifier.
     */
    private static final long serialVersionUID = -1837080260374986980L;

    /**
     * Constructs a new {@code XPathFactoryConfigurationException}
     * with the specified detail {@code message}.
     *
     * <p>The {@code cause} is not initialized.
     *
     * <p>If {@code message} is {@code null},
     * then a {@code NullPointerException} is thrown.
     *
     * @param message The detail message.
     *
     * @throws NullPointerException When {@code message} is
     *   {@code null}.
     */
    public XPathFactoryConfigurationException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code XPathFactoryConfigurationException}
     * with the specified {@code cause}.
     *
     * <p>If {@code cause} is {@code null},
     * then a {@code NullPointerException} is thrown.
     *
     * @param cause The cause.
     *
     * @throws NullPointerException if {@code cause} is {@code null}.
     */
    public XPathFactoryConfigurationException(Throwable cause) {
        super(cause);
    }
}
